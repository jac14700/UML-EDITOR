
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

import java.awt.image.BufferedImage;
import java.io.File;
import javax.swing.*;

import java.awt.*;

public class button_graphic extends graphic_to_panel{
	private String path, file_name;
	protected BufferedImage myPicture;
	protected JLabel picLabel;
	protected ImageIcon icon;
	protected Boolean selected;
	
	button_graphic(){}
	
	protected void set_parameters(int x , int y, String path, String file_name)
	{
			this.x = x;
			this.y = y;
			this.path = path;
			this.file_name = file_name;
			init();
	}
	protected void set_path(String path)
	{
		this.path = path;
	}
	
	private void read_img(String path)
	{
		try {
			myPicture = ImageIO.read(new File(path + this.file_name));
		}
		catch(IOException ex) {
			System.out.println("Didn't find " + path + this.file_name);
			utility.Pause();
		}
	}
	
	protected void update_parmeters()
	{
		read_img(this.path);
		this.icon.setImage(this.myPicture); 
		this.picLabel.setIcon(this.icon);
	}

	private void init()
	{
		this.selected = false;
		read_img(this.path);
		this.icon = new ImageIcon(this.myPicture);
		this.picLabel = new JLabel(this.icon);
	}
}