package Tile;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

import Main.GamePanel;

public class TileManager {

	
	
		GamePanel gp;
		public tile [] Tile;
		public int mapTileNum[][];
		public TileManager(GamePanel gp)
		{
			this.gp = gp;

			Tile = new tile[10];
			mapTileNum = new int[gp.maxWorldCol][gp.maxWorldRow];
		
			
			
			getTileImage();
			loadMap("/Maps/maps.txt");
		}
		
		public void getTileImage()
		{
			try 
			{
				Tile[0] = new tile();
				Tile[0].Image = ImageIO.read(getClass().getResourceAsStream("/Tiles/pared1.png"));
				Tile[0].collision = true;
				
				Tile[2] = new tile();
				Tile[2].Image = ImageIO.read(getClass().getResourceAsStream("/Tiles/pared_2.png"));
				Tile[2].collision = true;
				
				Tile[3] = new tile();
				Tile[3].Image = ImageIO.read(getClass().getResourceAsStream("/Tiles/piso_sangre.png"));

				Tile[1] = new tile();
				Tile[1].Image = ImageIO.read(getClass().getResourceAsStream("/Tiles/piso.png"));
			
				
			}catch(IOException e)
			{
				e.printStackTrace();
			    System.out.println("Error loading tile image: " + e.getMessage());

			}
		}
		
		public void loadMap(String filePath)
		{
			try
			{
			InputStream is = getClass().getResourceAsStream(filePath);	
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			
			
			int col = 0;
			int row = 0;
			
			while(col < gp.maxWorldCol && row < gp.maxWorldRow)
			{
				String line = br.readLine();
				
				while(col < gp.maxWorldCol)
				{
					String numbers[] = line.split(" ");
					
					int num = Integer.parseInt(numbers[col]);
					
					mapTileNum[col][row] = num;
					col++;
				}
				
				if(col == gp.maxWorldCol)
				{
					col = 0;
					row++;
				}
			}
			br.close();
			
			}catch(Exception e)
			{
				
			}
		}
		
		public void draw(Graphics2D g2)
		{
			int worldCol = 0;
			int worldRow = 0;
			
			while(worldCol < gp.maxWorldCol && worldRow < gp.maxWorldRow) {
				
				int tileNum = mapTileNum[worldCol][worldRow];			
				int worldX = worldCol * gp.tileSize;
				int worldY = worldRow * gp.tileSize;
				int screenX = worldX - gp.player.worldX + gp.player.screenX;
				int screenY = worldY - gp.player.worldY + gp.player.screenY;
				
				if(	worldX + gp.tileSize > gp.player.worldX - gp.player.screenX &&
					worldX - gp.tileSize < gp.player.worldX + gp.player.screenX &&
					worldY + gp.tileSize > gp.player.worldY - gp.player.screenY &&
					worldY - gp.tileSize < gp.player.worldY + gp.player.screenY) {
					
					g2.drawImage(Tile[tileNum].Image, screenX, screenY, gp.tileSize, gp.tileSize, null);
				}			
				worldCol++;			
				if(worldCol == gp.maxWorldCol) {
					worldCol = 0; 
					worldRow++;			
				}
			}	
			

			
		}
}
