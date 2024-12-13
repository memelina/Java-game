package Main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {


        public boolean upPressed = false;
        public boolean downPressed = false;
        public boolean leftPressed = false;
        public boolean rightPressed = false;

    //interface for receiving keyboard events
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override

    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        switch (code) {
            case KeyEvent.VK_W:
                upPressed = true;
                break;
            case KeyEvent.VK_S:
                downPressed = true;
                break;
            case KeyEvent.VK_A:
                leftPressed = true;
                break;
            case KeyEvent.VK_D:
                rightPressed = true;
                break;
        }
    }


    @Override
    public void keyReleased(KeyEvent e) {
        int code=e.getKeyCode();
        if(code==KeyEvent.VK_W)
        {
            upPressed=false;
        }
        if(code==KeyEvent.VK_S)
        {
            downPressed=false;
        }
        if(code==KeyEvent.VK_A)
        {
            leftPressed=false;
        }
        if(code==KeyEvent.VK_D)
        {
            rightPressed=false;
        }


    }//interface for receiving keyboard events
}
