package shapes;

import java.awt.Graphics;

import utilities.Parameters;

public class composition extends line{

	public composition() {
		super();
		this.line_type = Parameters.composition_line;
		// TODO Auto-generated constructor stub
	}
	 public void drawLine(Graphics g) {
		 g.drawLine(this.start_port.point.x, this.start_port.point.y,
				 	this.end_port.point.x, this.end_port.point.y);
		 drawArrow(g);
	}
	
	private void drawArrow(Graphics g) {
		g.fillOval(this.start_port.point.x, this.start_port.point.y, 5, 5);
	}
}