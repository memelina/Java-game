package entity;

import javax.swing.plaf.PanelUI;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.Rectangle;
import java.security.PublicKey;

public class Entity {

    public int worldX, worldY;
    public int speed;
    public BufferedImage up1,up2, right1, right2,down1, down2, left1,left2,up11,up12,right11,right12,down11, down12,left11, left12;
    public String direction;
    public int spriteCounter=0;
    public int spriteNumber=1;
    public boolean collision = false;
    public Rectangle solidArea;
    public int solidAreaDefaultX, solidAreaDefaultY;

    public boolean collisionOn=false;
}
