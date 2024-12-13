package Main;

import object.ObjKey;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.text.DecimalFormat;

public class UI {
    GamePanel gp;
    Font arial40, arial80;
    BufferedImage keyImage;
    public boolean messageOn=false;
    public String message= "";
    int messagrCounter=0;
    public boolean gameFinished= false;
    double playTime;
    DecimalFormat dFormat= new DecimalFormat("#0.00");
    public UI(GamePanel gp)
    {
        this.gp=gp;
        arial40=new Font("Arial", Font.BOLD,30);
        arial80=new Font("Arial", Font.BOLD,70);
        ObjKey key = new ObjKey();
        keyImage=key.image;
    }
    public void showMessage(String text)
    {
        message= text;
        messageOn=true;
    }
    public void draw(Graphics2D g2){
        if(gameFinished==true)
        {
            g2.setFont(arial40);
            g2.setColor(Color.white);
            String text;
            int textLength;
            text="You found the treasure!";
            textLength=(int)g2.getFontMetrics().getStringBounds(text,g2).getWidth();

            int x= gp.screedWidth/2-textLength/2;
            int y= gp.screenHeight/2-(gp.tileSize*3);
            g2.drawString(text,x,y);

            text="Your time is:"+ dFormat.format(playTime)+ "!";
            textLength=(int)g2.getFontMetrics().getStringBounds(text,g2).getWidth();
            x= gp.screedWidth/2-textLength/2;
            y= gp.screenHeight/2+(gp.tileSize*4);
            g2.drawString(text,x,y);

            g2.setFont(arial80);
            g2.setColor(Color.yellow);
            text="Congratulations!";
            textLength=(int)g2.getFontMetrics().getStringBounds(text,g2).getWidth();

             x= gp.screedWidth/2-textLength/2;
             y= gp.screenHeight/2+(gp.tileSize*2);
            g2.drawString(text,x,y);

            gp.gameThread= null;

        }
        else {
        g2.setFont(arial40);
        g2.setColor(Color.white);
        g2.drawImage(keyImage, gp.tileSize/2, gp.tileSize/2, gp.tileSize, gp.tileSize, null);
        g2.drawString(":"+gp.player.hasKey,74,65);
        playTime+=(double) 1/60;
        g2.drawString("Time:"+dFormat.format(playTime), gp.tileSize*13, 65);
        if(messageOn==true)
        {
           g2.setFont(g2.getFont().deriveFont(30));
            g2.drawString(message, gp.tileSize/2, gp.tileSize*5);
            messagrCounter++;
            if(messagrCounter>120){
                messagrCounter=0;
                messageOn=false;
            }
        }

    }
}}
