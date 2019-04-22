import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class canvas_panel extends JPanel_Listener_MotionListener_Mouse {
	private int panel_w;
	private int panel_h;
	private ObjectsContainer pie,apple,apple2,pie2;
	private mode user_mode = new mode_no_action();
	private ObjectsContainer temp,temp2;
	
	canvas_panel(int frame_w,int frame_h) {
		init_every_setting(frame_w,frame_h);
		pie = new DrawClass(new Point(10,100),pie);
		apple = new DrawClass(new Point(120,200),apple);

		pie2 = new DrawClass(new Point(50,100),pie2);
		apple2 = new DrawClass(new Point(520,200),apple2);
		/*temp = new ObjectsContainer();
		temp.add(apple);
		temp.add(pie);
		temp2 = new ObjectsContainer();
		temp2.add(apple2);
		temp2.add(pie2);*/
		//System.out.println(temp.group);
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