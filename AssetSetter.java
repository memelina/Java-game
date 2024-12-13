package Main;

import object.*;

public class AssetSetter {
    GamePanel gp;
    public AssetSetter(GamePanel gp){
        this.gp=gp;
    }
    public void setObject(){
        gp.obj[0] = new ObjKey();
        gp.obj[0].worldX=21* gp.tileSize;
        gp.obj[0].worldY=15*gp.tileSize;

        gp.obj[1] = new ObjKey();
        gp.obj[1].worldX=14* gp.tileSize;
        gp.obj[1].worldY=17*gp.tileSize;

        gp.obj[2] = new ObjectDoor();
        gp.obj[2].worldX=13* gp.tileSize;
        gp.obj[2].worldY=16*gp.tileSize;

        gp.obj[3] = new ObjectDoor();
        gp.obj[3].worldX=30* gp.tileSize;
        gp.obj[3].worldY=10*gp.tileSize;



        gp.obj[4] = new ObjectChest();
        gp.obj[4].worldX=30* gp.tileSize;
        gp.obj[4].worldY=12*gp.tileSize;

        gp.obj[5] = new ObjBoots();
        gp.obj[5].worldX=24* gp.tileSize;
        gp.obj[5].worldY=23*gp.tileSize;

        gp.obj[6] = new ObjectDoor();
        gp.obj[6].worldX=12* gp.tileSize;
        gp.obj[6].worldY=22*gp.tileSize;

        gp.obj[7] = new ObjectDoor();
        gp.obj[7].worldX=12* gp.tileSize;
        gp.obj[7].worldY=27*gp.tileSize;

        gp.obj[8] = new ObjKey();
        gp.obj[8].worldX=25* gp.tileSize;
        gp.obj[8].worldY=26*gp.tileSize;

        gp.obj[9] = new ObjDoorIron();
        gp.obj[9].worldX=25* gp.tileSize;
        gp.obj[9].worldY=15*gp.tileSize;

        gp.obj[10] = new ObjPotion();
        gp.obj[10].worldX=19* gp.tileSize;
        gp.obj[10].worldY=32*gp.tileSize;

        gp.obj[11] = new ObjKey();
        gp.obj[11].worldX=31* gp.tileSize;
        gp.obj[11].worldY=15*gp.tileSize;

        gp.obj[12]=new ObjDiamond();
        gp.obj[12].worldX=13* gp.tileSize;
        gp.obj[12].worldY=17*gp.tileSize;


    }

}
