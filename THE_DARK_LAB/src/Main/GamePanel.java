package Main;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.*;

import Entity.Player;
import Object.SuperObject;
import Tile.TileManager;

public class GamePanel extends JPanel implements Runnable {
	
	int FPS = 60; 
	 final int originalTileSize = 32;
	 final int scale = 3;
	public final int tileSize = originalTileSize * scale;
	public final int maxScreenCol = 50;
	public final int maxScreenRow = 50;
	public final int screenWidth = tileSize * maxScreenCol;
	public final int screenHeight = tileSize * maxScreenRow;
	
	
	public final int maxWorldCol = 50;
	public final int maxWorldRow = 50;
	public final int worldWidth = tileSize * maxWorldCol;
	public final int worldHeight = tileSize * maxWorldRow;

	TileManager tileM = new TileManager(this);
	KeyHandler keyH = new KeyHandler(this);
	Thread gameThread;
	public CollisionCheker cChecker = new CollisionCheker(this);
	public AssetSetter aSetter = new AssetSetter(this);
	public Player player = new Player(this,keyH);
	public SuperObject obj[] = new SuperObject[10];
	
	
	public int gameState;
	public int playState = 1;
	public int pauseState = 2;

	
	
	
	

	
	public GamePanel()
	{
		this.setPreferredSize(new Dimension(screenHeight, screenWidth));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);
		this.addKeyListener(keyH);
		this.setFocusable(true);
	}
	
	public void setupGame()
	{
		aSetter.setObject();
		gameState = playState;
	}
	
	public void startGameThread() {
		gameThread = new Thread( this);
		gameThread.start();
	}
	
	public void run()
	{
		double drawInterval = 1000000000/FPS;
		double delta = 0;
		long lastTime = System.nanoTime();
		double nextDrawTime = System.nanoTime() + drawInterval;
  		long currentTime;
  		long timer = 0;
  		int drawCount = 0;
  		
		while (gameThread != null)
		{

				currentTime = System.nanoTime();		
				delta += (currentTime - lastTime) / drawInterval;				
				timer += (currentTime -lastTime);
				lastTime = currentTime;
				
				if(delta >= 1)
				{
					update();
					repaint();
					delta--;
					drawCount++;
				}
				
				if(timer >= 1000000000)
				{
					System.out.println("FPS"+ drawCount);
					drawCount = 0;
					timer = 0;
				}

	}
	}
	
	public void update()
	{
		if(gameState == playState)
		{
			player.update();
		}
		if(gameState == playState)
		{
			
		}
		
		
		
		
	}
	public void paintComponent (Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		
		
		tileM.draw(g2);
		
		for(int i = 0; i < obj.length; i++)
		{
			if(obj[i] != null)
			{
				obj[i].draw(g2, this);
			}
		}
		
		player.draw(g2);
		
		g2.dispose();
	}
}
