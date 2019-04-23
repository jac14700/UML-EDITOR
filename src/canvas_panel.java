import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class canvas_panel extends JPanel_Listener_MotionListener_Mouse {
	private int panel_w;
	private int panel_h;
	private BasicObject pie,apple,apple2,pie2;
	private ArrayList<ObjectsContainer> array_of_containers;
	private ObjectsContainer group;
	private ArrayList<BasicObject> all_objs = new ArrayList<BasicObject>(),
								   chosen_objs =  new ArrayList<BasicObject>();
	private mode user_mode = new mode_no_action();
	
	canvas_panel(int frame_w,int frame_h) {
		init_every_setting(frame_w,frame_h);
		pie = new DrawClass(new Point(10,100));
		apple = new DrawClass(new Point(120,200));
		pie2 = new DrawClass(new Point(50,100));
		apple2 = new DrawClass(new Point(520,200));
		
		
		
		//group ªº¤u§@
		chosen_objs.add(apple);
		chosen_objs.add(pie);
		group = new ObjectsContainer(new ArrayList<BasicObject>(chosen_objs));
		
		this.add(group.current_array.get(1).label);
		this.add(group.current_array.get(0).label);
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
		 if(event.getButton()== MouseEvent.BUTTON1)
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