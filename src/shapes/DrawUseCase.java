package shapes;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Point;
import javax.swing.JLabel;

import panels.canvas_panel;
import utilities.Parameters;

public class DrawUseCase extends BasicObject{
	private static final long serialVersionUID = 1L;
	private Dimension size_of_use_case = new Dimension(100, 100);
	
	public DrawUseCase(Point start,canvas_panel canvas){
		super(start,canvas);
		this.size = size_of_use_case;
		this.end = new Point(this.start.x + this.size.width, this.start.y + this.size.width);
		init_obj_points_parameters();
		init_main_label();
		init_message();
	}
	
	private void init_message() {
		GridBagConstraints gbc = new GridBagConstraints();
	    gbc.anchor = GridBagConstraints.CENTER;
	    gbc.weighty = 1;
	    this.message.setText(name);
	    this.message.setVerticalAlignment(JLabel.TOP);
	    this.main_label.add(message, gbc);
	}
	
	private void init_main_label() {
		this.main_label.mode = Parameters.Button.user_case.ordinal();
		this.main_label.setOpaque(false);
		this.main_label.setLocation(this.start.x,this.start.y);
		this.main_label.setLayout(new GridBagLayout());
		this.main_label.setSize(size);
	}
	
	private void init_obj_points_parameters() {
		this.end.x = this.start.x + this.size.width;
		this.end.y = this.start.y + this.size.height;
		this.center.x = this.start.x + this.size.width/2;
		this.center.y = this.start.y + this.size.height/2;
	}
	public void drawBound(Graphics g) {
        g.setColor(Color.black);
		g.drawLine(this.start.x, this.start.y, this.start.x, this.start.y+100);
		g.drawLine(this.start.x, this.start.y, this.start.x+100, this.start.y);
		g.drawLine(this.start.x+100, this.start.y+100, this.start.x+100, this.start.y);
		g.drawLine(this.start.x+100, this.start.y+100, this.start.x, this.start.y+100);
	}
	public void draw(Graphics g) {
        g.setColor(Color.orange);
        g.fillOval(this.start.x, this.start.y, 100, 100);
        g.setColor(Color.black);
        g.drawString(name, this.start.x+7, this.start.y+50);

	    if(this.selected) {
	        drawBound(g);
	    	g.setColor(Color.RED);
 		    g.fillOval(this.up.point.x - w_h_of_port/2		,this.up.point.y  - w_h_of_port/2, w_h_of_port, w_h_of_port);
 		    g.fillOval(this.down.point.x - w_h_of_port/2	,this.down.point.y  - w_h_of_port/2, w_h_of_port, w_h_of_port);
 		    g.fillOval(this.left.point.x - w_h_of_port/2	,this.left.point.y  - w_h_of_port/2, w_h_of_port, w_h_of_port);
 		    g.fillOval(this.right.point.x - w_h_of_port/2	,this.right.point.y  - w_h_of_port/2, w_h_of_port, w_h_of_port);
	    }
	}
}
