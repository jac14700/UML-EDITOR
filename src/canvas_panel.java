import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;

public class canvas_panel extends JPanel_with_MouseListener {
	private int panel_w;
	private int panel_h;
	private int current_mode;
	private Graphic_to_c_panel pie;
	canvas_panel(int fram_w,int fram_h) {
		this.panel_w = fram_w - button_panel.panel_w;
		this.panel_h = fram_h;
		this.setBackground(Color.GREEN);
		this.setLocation(new Point(button_panel.panel_w,0));
		this.setSize(new Dimension(this.panel_w, this.panel_h));
		pie =new Draw_class();
		//pie.draw();
		this.add(pie);		
	}
	 public void paint(Graphics g) {
		    g.setColor(Color.yellow);
		    g.fillRect(10,10,100,100);
	}
}