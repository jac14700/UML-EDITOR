import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Point;
import java.awt.image.BufferedImage;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.border.Border;

public class canvas_panel extends JPanel_with_MouseListener {
	private int panel_w;
	private int panel_h;
	private int current_mode;
	private BasicObject pie,apple;

	canvas_panel(int fram_w,int fram_h) {
		this.panel_w = fram_w - button_panel.panel_w;
		this.panel_h = fram_h;
		this.setBackground(Color.GREEN);
		this.setLocation(new Point(button_panel.panel_w,0));
		this.setSize(new Dimension(this.panel_w, this.panel_h));
		this.setLayout(null);
		pie = new BasicObject(10,100);
		pie.label.setLocation(new Point(10,10));

		apple = new BasicObject(120,200);
		//apple.label.setLocation(new Point(10,10));
		this.add(apple.label);
		this.add(pie.label);
	}
}