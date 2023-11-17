package Object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_Door extends SuperObject{

	
	public OBJ_Door ()
	{
		name = "Door";
		
		try
		{
			image = ImageIO.read(getClass().getResourceAsStream("/objects/puerta.png"));
			collision = true;
			
		}catch(IOException e)
		{
			e.printStackTrace();
		}
		
		collision = true;
	}
	
}
