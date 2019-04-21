import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.MouseEvent;

public class canvas_panel extends JPanel_Listener_MotionListener_Mouse {
	private int panel_w;
	private int panel_h;
	private int current_mode;
	private BasicObject pie,apple;

	canvas_panel(int frame_w,int frame_h) {
		init_every_setting(frame_w,frame_h);
		pie = new BasicObject(10,100);
		pie.label.setLocation(new Point(10,10));
		apple = new BasicObject(120,200);
		this.add(apple.label);
		this.add(pie.label);
	}
	private void init_every_setting(int frame_w,int frame_h)
	{
		this.panel_w = frame_w - button_panel.panel_w;
		this.panel_h = frame_h;
		this.setBackground(Color.GREEN);
		this.setLocation(new Point(button_panel.panel_w,0));
		this.setSize(new Dimension(this.panel_w, this.panel_h));
		this.setLayout(null);
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
	}
	 public void mouseClicked(MouseEvent event) {
	        System.out.println("mouseClicked()");
	    }

}