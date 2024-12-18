package entity;

import Main.GamePanel;
import Main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.awt.Graphics2D;


public class Player extends Entity {
    GamePanel gp;
    KeyHandler keyH;
    public final int screenX;
    public final int screenY;
    public int hasKey=0;
    public int potiune=0;

    public Player(GamePanel gp, KeyHandler keyH) {
        this.gp = gp;
        this.keyH = keyH;
        setDefaultValues();
        getPlayerImage();
        screenX = gp.screedWidth / 2 - (gp.tileSize) / 2;
        screenY = gp.screenHeight / 2 - (gp.tileSize) / 2;

        solidArea = new Rectangle();
        solidArea.x = 8;
        solidArea.y = 16;
        solidAreaDefaultX=solidArea.x;
        solidAreaDefaultY=solidArea.y;
        solidArea.width = 25;
        solidArea.height = 25;
        setDefaultValues();
        getPlayerImage();

    }

    public void setDefaultValues() {
        worldX = gp.tileSize + 390;
        worldY = gp.tileSize + 390;
        speed = 4;
        direction = "down";

    }

    public void getPlayerImage() {
        try {
            up1 = ImageIO.read(getClass().getResourceAsStream("/player1/up1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/player1/up2.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/player1/right1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/player1/right2-1.png.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/player1/left1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/player1/right2-2.png.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/player1/down1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/player1/down2.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update() {

            if (keyH.upPressed) {
                direction = "up";
                worldY -= speed;
            } else if (keyH.downPressed) {
                direction = "down";
                worldY += speed;
            } else if (keyH.leftPressed) {
                direction = "left";
                worldX -= speed;
            } else if (keyH.rightPressed) {
                direction = "right";
                worldX += speed;
            }

            collisionOn = false;
            gp.cChecker.checkTile(this);
           int objectIndex= gp.cChecker.checkObject(this, true);
           pickUpObj(objectIndex);
            if (collisionOn) {
                // Dacă avem o coliziune, revenim la poziția anterioară
                if (keyH.upPressed) {
                    worldY += speed;
                } else if (keyH.downPressed) {
                    worldY -= speed;
                } else if (keyH.leftPressed) {
                    worldX += speed;
                } else if (keyH.rightPressed) {
                    worldX -= speed;
                }
            }

            spriteCounter++;
            if (spriteCounter > 12) {
                if (spriteNumber == 1) {
                    spriteNumber = 2;
                } else if (spriteNumber == 2) {
                    spriteNumber = 1;
                }
                spriteCounter = 0;
            }

        int margin = gp.tileSize + 310;

        if (worldX >= margin && worldX + gp.tileSize <= gp.worldWidth - margin &&
                worldY >= margin && worldY + gp.tileSize <= gp.worldHeight - margin) {
            // Jucătorul este în interiorul limitelor hărții
        } else {
            // Jucătorul este în afara limitelor hărții, reamplasăm jucătorul pe poziția anterioară
            if (keyH.upPressed) {
                worldY += speed;
            } else if (keyH.downPressed) {
                worldY -= speed;
            } else if (keyH.leftPressed) {
                worldX += speed;
            } else if (keyH.rightPressed) {
                worldX -= speed;
            }
        }}


 public void pickUpObj(int i) {
     if (i != 999) {
      String objectName = gp.obj[i].name;
      switch (objectName)
      {
          case "key":
              gp.playSE(1);
              hasKey++;
              gp.obj[i]=null;
              gp.ui.showMessage("You got a key!");
              break;
          case "door":
              gp.playSE(3);
              if(hasKey>0)
              {
                  gp.obj[i]=null;
                  hasKey--;
              }else
                  gp.ui.showMessage("You need a key!");
              System.out.println("key"+hasKey);
              break;
          case "boots":
              gp.playSE(2);
              gp.ui.showMessage("Speed up!");
              speed+=1;
              gp.obj[i]=null;
              break;
          case "chest":
              gp.ui.gameFinished=true;
              gp.stopMusi();
              gp.playSE(4);
          case "iron":
              gp.playSE(3);
              if(potiune>0)
              {
                  gp.obj[i]=null;
                  potiune--;
              }else
                  gp.ui.showMessage("No match key!");
           break;
          case "potion":
              gp.playSE(1);
              potiune++;
              gp.obj[i]=null;
              gp.ui.showMessage("GO!");
              break;
          case "diamond":
              gp.playSE(1);
              gp.obj[i]=null;
              gp.ui.showMessage("You got a diamond!");
              break;

      }
     }
 }
 public void draw (Graphics2D g2){
            // g2.setColor(Color.white);
            //g2.fillRect(x,y,gp.tileSize,gp.tileSize);
            BufferedImage image = null;
            switch (direction) {
                case "up":
                    if (spriteNumber == 1)
                        image = up1;
                    if (spriteNumber == 2)
                        image = up2;
                    break;
                case "down":
                    if (spriteNumber == 1)
                        image = down1;
                    if (spriteNumber == 2)
                        image = down2;
                    break;
                case "left":
                    if (spriteNumber == 1)
                        image = left1;
                    if (spriteNumber == 2)
                        image = left2;
                    break;
                case "right":
                    if (spriteNumber == 1)
                        image = right1;
                    if (spriteNumber == 2)
                        image = right2;
                    break;

            }

            g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);

        }
    }

