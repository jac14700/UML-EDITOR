package shapes;

import java.awt.Graphics;

public class gerneralization extends line{

	public gerneralization() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	 public void to_draw_arrow(Graphics g, int start_port_type) {
		 int x_change =7,y_change =7;
		 switch(start_port_type) {
		 	case 0://¤W
		 		g.drawLine( this.start_port.point.x,
		 					this.start_port.point.y,
		 					this.start_port.point.x -x_change,
		 					this.start_port.point.y -y_change);
		 		g.drawLine( this.start_port.point.x,
		 				  	this.start_port.point.y,
		 				  	this.start_port.point.x +x_change,
		 				  	this.start_port.point.y -y_change);
		 		break;
		 	case 1://¥ª
		 		g.drawLine( this.start_port.point.x,
		 					this.start_port.point.y,
		 					this.start_port.point.x -x_change,
		 					this.start_port.point.y -y_change);
		 		g.drawLine( this.start_port.point.x,
		 					this.start_port.point.y,
		 					this.start_port.point.x -x_change,
		 					this.start_port.point.y +y_change);
		 		break;
		 	case 2://¥k
		 		g.drawLine( this.start_port.point.x,
			 				this.start_port.point.y,
			 				this.start_port.point.x +x_change,
			 				this.start_port.point.y -y_change);
		 		g.drawLine( this.start_port.point.x,
			 				this.start_port.point.y,
			 				this.start_port.point.x +x_change,
			 				this.start_port.point.y +y_change);
		 		break;
		 	case 3://¤U
		 		g.drawLine( this.start_port.point.x,
			 				this.start_port.point.y,
			 				this.start_port.point.x -x_change,
			 				this.start_port.point.y +y_change);
		 		g.drawLine( this.start_port.point.x,
			 				this.start_port.point.y,
			 				this.start_port.point.x +x_change,
			 				this.start_port.point.y +y_change);
		 		break;
		 }
	 }
	
	 public void drawLine(Graphics g) {
		 g.drawLine(this.start_port.point.x, this.start_port.point.y,
				 	this.end_port.point.x, this.end_port.point.y);
		 drawArrow(g);
	}
	
	private void drawArrow(Graphics g) {
		to_draw_arrow(g, this.start_port_type);
	}	 
}
