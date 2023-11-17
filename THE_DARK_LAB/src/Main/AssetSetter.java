package Main;
import Object.OBJ_Card;
import Object.OBJ_Door;

public class AssetSetter {

    GamePanel gp;
    
    public AssetSetter(GamePanel gp) 
    {
        this.gp = gp;
    }

    public void setObject() {
        gp.obj[0] = new OBJ_Card();
        gp.obj[0].worldX = 23 * gp.tileSize; // 4
        gp.obj[0].worldY = 28 * gp.tileSize; // 46 LUGAR DONDE APARECE LA TARJETA 
        
        gp.obj[1] = new OBJ_Door();
        gp.obj[1].worldX = 22 * gp.tileSize;
        gp.obj[1].worldY = 23 * gp.tileSize; // LUGAR DONDE APARECE LA TARJETA 
        
        gp.obj[2] = new OBJ_Card();
        gp.obj[2].worldX = 25 * gp.tileSize;
        gp.obj[2].worldY = 27 * gp.tileSize; // LUGAR DONDE APARECE LA TARJETA 
        
        gp.obj[3] = new OBJ_Card();
        gp.obj[3].worldX = 22 * gp.tileSize;
        gp.obj[3].worldY = 27 * gp.tileSize; // LUGAR DONDE APARECE LA TARJETA 
        
        
        
        
        
    }
}
