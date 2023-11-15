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
		tile [] Tile;
		int mapTileNum[][];
		public TileManager(GamePanel gp)
		{
			this.gp = gp;

			Tile = new tile[10];
			mapTileNum = new int[gp.maxScreenCol][gp.maxScreenRow];
		
			
			
			getTileImage();
			loadMap("/Maps/maps.txt");
		}
		
		public void getTileImage()
		{
			try 
			{
				Tile[0] = new tile();
				Tile[0].Image = ImageIO.read(getClass().getResourceAsStream("/Tiles/pared1.png"));
				
				Tile[3] = new tile();
				Tile[3].Image = ImageIO.read(getClass().getResourceAsStream("/Tiles/piso_sangre.png"));
				
				Tile[1] = new tile();
				Tile[1].Image = ImageIO.read(getClass().getResourceAsStream("/Tiles/piso.png"));
				
				Tile[2] = new tile();
				Tile[2].Image = ImageIO.read(getClass().getResourceAsStream("/Tiles/puerta.png"));
				
				Tile[4] = new tile();
				Tile[4].Image = ImageIO.read(getClass().getResourceAsStream("/Tiles/puerta1.png"));
				
				Tile[5] = new tile();
				Tile[5].Image = ImageIO.read(getClass().getResourceAsStream("/Tiles/puerta2.png"));
				
				
				
			}catch(IOException e)
			{
				e.printStackTrace();
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
			
			while(col < gp.maxScreenCol && row < gp.maxScreenRow)
			{
				String line = br.readLine();
				
				while(col < gp.maxScreenCol)
				{
					String numbers[] = line.split(" ");
					
					int num = Integer.parseInt(numbers[col]);
					
					mapTileNum[col][row] = num;
					col++;
				}
				
				if(col == gp.maxScreenCol)
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
			int col = 0;
			int row = 0;
			int y = 0;
			int x = 0;
			
			while(col < gp.maxScreenCol && row < gp.maxScreenRow)
			{
				
				int tileNum = mapTileNum[col][row];
				
				g2.drawImage(Tile[tileNum].Image, x, y, gp.tileSize, gp.tileSize, null);
				col++;
				x += gp.tileSize;
				
				if(col == gp.maxScreenCol)
				{
					col = 0;
					x = 0;
					row ++;
					y += gp.tileSize; 
				}

			}
			

			
		}
}
