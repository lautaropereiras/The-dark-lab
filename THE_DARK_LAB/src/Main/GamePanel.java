package Main;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.*;

import Entity.Player;
import Tile.TileManager;

public class GamePanel extends JPanel implements Runnable {
	
	int FPS = 60; 
	 final int originalTileSize = 16;
	 final int scale = 3;
	public final int tileSize = originalTileSize * scale;
	public final int maxScreenCol = 96;
	public final int maxScreenRow = 96;
	public final int screenWidth = tileSize * maxScreenCol;
	public final int screenHeight = tileSize * maxScreenRow;
	
	
	public final int maxWorldCol = 100;
	public final int maxWorldRow = 100;
	public final int worldWidth = tileSize * maxWorldCol;
	public final int worldHeight = tileSize * maxWorldRow;

	TileManager tileM = new TileManager(this);
	KeyHandler keyH = new KeyHandler();
	Thread gameThread;
	public Player player = new Player(this,keyH);
	

	
	public GamePanel()
	{
		this.setPreferredSize(new Dimension(screenHeight, screenWidth));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);
		this.addKeyListener(keyH);
		this.setFocusable(true);
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
		player.update();
		
	}
	public void paintComponent (Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		tileM.draw(g2);
		player.draw(g2);
		g2.dispose();
	}
}
