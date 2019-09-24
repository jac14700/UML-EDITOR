package shapes;

import java.awt.Graphics;

import utilities.Parameters;

public class association extends line{

	public association() {
		super();
		this.line_type = Parameters.association_line;
		// TODO Auto-generated constructor stub
	}
	public void drawLine(Graphics g) {
		 g.drawLine(this.start_port.point.x, this.start_port.point.y,
				 	this.end_port.point.x, this.end_port.point.y); 
	}
}
