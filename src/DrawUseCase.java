import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class DrawUseCase extends BasicObject{
	private static final long serialVersionUID = 1L;
	private String  name = "Now or never!";
	private Dimension size_of_use_case = new Dimension(100, 100);
	DrawUseCase(Point start){
		super(start);
		this.size = size_of_use_case;
		this.center.x = this.start.x + this.size.width/2;
		this.center.y = this.start.y + this.size.height/2;
		this.main_label.mode = Parameters.Button.user_case.ordinal();
		this.main_label.setOpaque(false);
		this.main_label.setLocation(this.start.x,this.start.y);
		this.main_label.setLayout(new GridBagLayout());
		//BufferedImage img = ImageIO.read(new File(Parameters.file_name_of_oval));
		//this.main_label.setIcon(new ImageIcon(img));
		
	    GridBagConstraints gbc = new GridBagConstraints();
	    gbc.anchor = GridBagConstraints.CENTER;
	    gbc.weighty = 1;
	    
	    this.message.setText(name);
	    this.message.setVerticalAlignment(JLabel.TOP);        
	    this.main_label.add(message, gbc);
	    this.main_label.setSize(size);
	    this.end = new Point(this.start.x + this.size.width, this.start.y + this.size.width);
	}
}
