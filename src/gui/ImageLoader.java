package gui;

import java.awt.Image;
import java.util.HashMap;

import javax.swing.ImageIcon;

public class ImageLoader {
	
private static HashMap<String,ImageIcon>  icons = new HashMap<>();

public ImageLoader(int size)
{
	int pix = 55*10/size;
	loadIcon("grass","data/grass.png",pix,pix);
	loadIcon("cobblestone","data/cobblestone.png",pix,pix);
	loadIcon("sand","data/sand.png",pix,pix);
}

private void loadIcon(String name,String path, int x, int y)
{
	ImageIcon imageIcon = new ImageIcon(path);
	Image image = imageIcon.getImage();
	Image newImg = image.getScaledInstance(x, y,  java.awt.Image.SCALE_SMOOTH);
	ImageIcon newIcon = new ImageIcon(newImg);
	
	icons.put(name, newIcon);
	
}

	ImageIcon getIcon(String name)
	{
		return icons.get(name);
		
	}
}
