import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class canvas_panel extends JPanel_Listener_MotionListener_Mouse {
	private int panel_w;
	private int panel_h;
	private ArrayList<BasicObject> group;
	private BasicObject pie,apple;
	private mode user_mode;

	canvas_panel(int frame_w,int frame_h) {
		init_every_setting(frame_w,frame_h);
		pie = new BasicObject(new Point(10,100));
		apple = new BasicObject(new Point(120,200));
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
	
	 public void mousePressed(MouseEvent event) {
		user_mode = get_mode(buttons.idx_which_is_chosen,event,this);
	 }
	 private mode get_mode(int mode_type,MouseEvent event,canvas_panel canvas)
	 {
		 mode tmp = new mode_no_action();
		 switch(mode_type) {
		 	case -1:
		 		tmp = new mode_no_action();
		 		break;
		 	case 4:
		 		tmp = new mode_class(canvas);
		 		tmp.mousePressed(event);
		 		break;
		 }
		 return tmp;
	 }
	 //public void mousePressed

}