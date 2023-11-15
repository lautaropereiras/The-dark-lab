package Entity;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import Main.GamePanel;

public class Player extends entity {
	
	GamePanel gp;	
	Main.KeyHandler keyH;
	


	public Player (GamePanel gp, Main.KeyHandler keyH)
	{
		this.gp = gp;
		this.keyH = keyH;
		
		

		setDefaultValues();
		getPlayerImage();
	}
	public void setDefaultValues()
	{
		x = 880;
		y = 460;
		speed = 4;
		direction ="down";
	}
	public void getPlayerImage()
	{
		try
		{
			up1 = ImageIO.read(getClass().getResourceAsStream("/player/movimiento espalda1.png"));
			up2 = ImageIO.read(getClass().getResourceAsStream("/player/movimiento espalda2.png"));
			up3 = ImageIO.read(getClass().getResourceAsStream("/player/movimiento espalda3.png"));
			up4 = ImageIO.read(getClass().getResourceAsStream("/player/movimiento espalda4.png"));
			down1 = ImageIO.read(getClass().getResourceAsStream("/player/movimiento abajo1.png"));
			down2 = ImageIO.read(getClass().getResourceAsStream("/player/movimiento abajo2.png"));
			down3 = ImageIO.read(getClass().getResourceAsStream("/player/movimiento abajo3.png"));
			down4 = ImageIO.read(getClass().getResourceAsStream("/player/movimiento abajo4.png"));
			left1 = ImageIO.read(getClass().getResourceAsStream("/player/movimiento izquierda1.png"));
			left2 = ImageIO.read(getClass().getResourceAsStream("/player/movimiento izquierda2.png"));
			left3 = ImageIO.read(getClass().getResourceAsStream("/player/movimiento izquierda3.png"));
			left4 = ImageIO.read(getClass().getResourceAsStream("/player/movimiento izquierda4.png"));
			right1 = ImageIO.read(getClass().getResourceAsStream("/player/movimiento derecha1.png"));
			right2 = ImageIO.read(getClass().getResourceAsStream("/player/movimiento derecha2.png"));
			right3 = ImageIO.read(getClass().getResourceAsStream("/player/movimiento derecha1.png"));
			right4 = ImageIO.read(getClass().getResourceAsStream("/player/movimiento derecha1.png"));

		}catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	public void update()
	{
		
		if(keyH.upPressed == true || keyH.downPressed == true || keyH.leftPressed == true || keyH.rightPressed == true)
		{
			if(keyH.upPressed == true)
			{
				direction = "up";
				y -= speed;
			}
			else if (keyH.downPressed == true)
			{
				direction = "down";
				y += speed;
			}
			else if (keyH.leftPressed == true)
			{
				direction = "left";
				x -= speed;
			}
			else if (keyH.rightPressed == true)
			{
				direction = "right";
				x += speed;
			}
			
			
			spriteCounter++;
			if (spriteCounter > 12) {
			    spriteNum = (spriteNum % 4) + 1;

			    spriteCounter = 0;
			}

		}
		
	}
	public void draw(Graphics2D g2) 
	{

		
		
		BufferedImage image = null;
		
		switch(direction)
		{
		case "up":
			if(spriteNum == 1)
			{
				image = up1;

			}
			if(spriteNum == 2)
			{
				image = up2;
			}
			if(spriteNum == 3)
			{
				image = up3;

			}
			if(spriteNum == 4)
			{
				image = up4;

			}
			break;
		case "down":
			if(spriteNum == 1)
			{
				image = down1;
			}
			if(spriteNum == 2)
			{
				image = down2;
			}
			if(spriteNum == 3)
			{
				image = down3;
			}
			if(spriteNum == 4)
			{
				image = down4;
			}
			break;
		case "left":
			if(spriteNum == 1)
			{
				image = left1;

			}
			if(spriteNum == 2)
			{
				image = left2;

			}
			if(spriteNum == 3)
			{
				image = left3;

			}
			if(spriteNum == 4)
			{
				image = left4;

			}
			break;
		case "right":
			if(spriteNum == 1)
			{
				image = right1;

			}
			if(spriteNum == 2)
			{
				image = right2;

			}
			if(spriteNum == 3)
			{
				image = right3;

			}
			if(spriteNum == 4)
			{
				image = right4;

			}
			break;
		}
		g2.drawImage(image, x, y,gp.tileSize,gp.tileSize, null);

	}
}
