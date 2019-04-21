import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class canvas_panel extends JPanel_Listener_MotionListener_Mouse {
	private int panel_w;
	private int panel_h;
	private ArrayList<ObjectsContainer> group;
	private ObjectsContainer pie,apple;
	private mode user_mode = new mode_no_action();

	canvas_panel(int frame_w,int frame_h) {
		init_every_setting(frame_w,frame_h);
		pie = new DrawClass(new Point(10,100));
		apple = new DrawClass(new Point(120,200));
		group = new ArrayList<ObjectsContainer>();
		group.add(pie);
		group.add(apple);
		this.add(apple.label);
		this.add(pie.label);
		moveto();
	}
	private void moveto() 
	{
		for(ObjectsContainer temp : this.group)
		{
			temp.start.x = temp.start.x +500;
			temp.label.setLocation(temp.start);
		}
		this.repaint();
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
		get_mode(buttons.idx_which_is_chosen,event,this);
	 }
	 private void get_mode(int mode_type,MouseEvent event,canvas_panel canvas)
	 {
		 switch(mode_type) {
		 	case -1:
		 		user_mode = new mode_no_action();
		 		break;
		 	case 4:
		 		user_mode = new mode_class(canvas);
		 		user_mode.mousePressed(event);
		 		break;
		 }
	 }
	 //public void mousePressed

}