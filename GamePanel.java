package Main;

import entity.Player;
import object.SuperObject;
import tile.TileManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;

public class GamePanel extends JPanel implements Runnable {
    //setari pentru ecran
    final int originalTileSize = 16; // Dimensiunea implicită pentru caractere
    final int scale = 3;
    public final int tileSize = originalTileSize * scale; // Dimensiunea actuală pe ecran
    public final int maxScreenCol = 16;
    public final int maxScreenRow = 13;
    public final int screedWidth = tileSize * maxScreenCol; // Lățimea ecranului
    public final int screenHeight = tileSize * maxScreenRow; // Înălțimea ecranului
    public final int maxWorldCol = 50;
    public final int maxWorldRows = 50;
    public final int worldWidth = tileSize * maxWorldCol;
    public final int worldHeight = tileSize * maxWorldRows;


    KeyHandler keyH=new KeyHandler();
    Sound sound = new Sound();
    Sound music = new Sound();

    //set player's default position

    int FPS=60;
    TileManager tileM= new TileManager(this);
   public  CollisionChecker cChecker = new CollisionChecker(this);

   public Player player= new Player(this,keyH);
   public AssetSetter aSetter = new AssetSetter(this);
   public UI ui= new UI(this);
    Thread gameThread;
   public SuperObject obj[] =new SuperObject[15];
    //you can start and keeps program running until you stop it
    //   //if FPS is 60 means it updates the screen 60 times per second
    //        //in 2D games program never stops
    public GamePanel() {
        this.setDoubleBuffered(true);

        this.setPreferredSize(new Dimension(screedWidth, screenHeight)); // Asigură-te că dimensiunile sunt setate corespunzător.
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);//redare perfomante mai bune?
        this.addKeyListener(keyH);
        this.requestFocusInWindow();
        this.setFocusable(true);//Main.Main.GamePanel can be "focused" to receive key input

    }
    public void setupGame()
    {
        aSetter.setObject();
        playMusic(0);
    }
    public void startGameThread()
    {
        gameThread= new Thread(this);//passing Main.Main.GamePanel class to this thread's constructor
        gameThread.start();//apeleaza run method

    }

    @Override
    /*public void run() { //create a game loop which will be the core of our game
       double drawInterval=1000000000/FPS;// 1 second
        //draw the screen every 0.016 seconds
        double nextDrawTime=System.nanoTime()+drawInterval;
        //next draw time will be current time plus drawInterval
        while(gameThread!=null)
      {
     // System.out.println("The game loop is running!");
      //update info such as character positions
      //draw the screen with de updated info
         long currentTime = System.nanoTime();//returns the current value of the running time

          update();
          repaint();//keeps calling  paintComponent

          try {
              double remainingTime= nextDrawTime- System.nanoTime();
              remainingTime=remainingTime/1000000000;
              Thread.sleep((long)remainingTime);
              nextDrawTime+=drawInterval;
              if(remainingTime<0)
                  remainingTime=0;
          } catch (InterruptedException e) {
              e.printStackTrace();
          }
      }
    }*///sleep method


    public void run() {//delta method
        double drawInterval=1000000000/FPS;
        double delta=0;
        long lastTime=System.nanoTime();
        long currentTime;
        while(gameThread!=null)
        {
            currentTime=System.nanoTime();
            delta+=(currentTime-lastTime)/drawInterval;
            lastTime=currentTime;
            if(delta>=1)
            {
                update();
                repaint();
                delta--;
            }
        }

    }


    public void update()//change player positions
    {
        player.update();
    }
    public void paintComponent(Graphics g)//clasa pentru desenare
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        // Nu desenați niciun fundal aici

        // Desenarea hărții și jucătorului
        tileM.draw(g2);
        for(int i=0;i<obj.length;i++)
        {
            if(obj[i]!=null)
            {
                obj[i].draw(g2,this);
            }
        }
        player.draw(g2);
        ui.draw(g2);

        g2.dispose();
    }
    public void playMusic(int i)
    {
     sound.setFile(i);
     sound.play();
     sound.loop();
    }
    public void stopMusi(){
       sound.stop();
    }
    public void playSE(int i){
        music.setFile(i);
        music.play();
    }

}
