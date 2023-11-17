package Object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_Card extends SuperObject{

	
	public OBJ_Card ()
	{
		name = "Card";
		
		try
		{
			image = ImageIO.read(getClass().getResourceAsStream("/objects/Tarjeta llave.png"));
			collision = true;
			
		}catch(IOException e)
		{
			e.printStackTrace();
		}
		
		solidArea.x = 5; 
	}
	
}
