import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.ArrayList;



public class canvas_panel extends JPanel_Listener_MotionListener_Mouse {

	private static final long serialVersionUID = 1L;
	private int panel_w;
	private int panel_h;
	private Point pointStart = null;
	private Point pointEnd   = null;
	
	private BasicObject pie,apple,banana;
	private ArrayList<ObjectsContainer> array_of_containers;
	private ObjectsContainer group;
	public static ArrayList<BasicObject> all_objs_in_canvas = new ArrayList<BasicObject>();
	public ArrayList<BasicObject> chosen_objs =  new ArrayList<BasicObject>();
	private mode user_mode = new mode_no_action();
	private mode_mouse mouse;
	private mode_no_action no_action;
	private mode_class class_;
	canvas_panel(int frame_w,int frame_h) {
		init_every_setting(frame_w,frame_h);
		pie = new DrawClass(new Point(10,100));
		this.apple = new DrawClass(new Point(120,200));	
		banana = new DrawClass(new Point(320,500)); 
		
		//group ���u�@
		this.chosen_objs.add(apple);
		this.chosen_objs.add(pie);
		this.chosen_objs.add(banana);
		
		group = new ObjectsContainer(new ArrayList<BasicObject>(chosen_objs));

		all_objs_in_canvas.add(apple);
		all_objs_in_canvas.add(pie);
		all_objs_in_canvas.add(banana);
		System.out.println(all_objs_in_canvas.get(1).start);
		System.out.println(all_objs_in_canvas.get(1).end);
		System.out.println(all_objs_in_canvas.get(0).start);
		System.out.println(all_objs_in_canvas.get(0).end);
		
		this.add(group.current_array.get(0).main_label);
		this.add(group.current_array.get(1).main_label);
		this.add(group.current_array.get(2).main_label);
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
		 this.pointStart = event.getPoint();
		 get_mode(buttons.idx_which_is_chosen,event,this);
		 user_mode.mousePressed(event);
	 }
	 public void mouseEntered(MouseEvent event) {
		 this.mouse = new mode_mouse(this);
		 this.no_action= new mode_no_action();
		 this.class_= new mode_class(this,all_objs_in_canvas);
	 }
	 public void mouseReleased(MouseEvent event) {
		 this.pointStart = null;
		 get_mode(buttons.idx_which_is_chosen,event,this);
		 user_mode.mouseReleased(event);
         repaint();
     }
	 public void mouseMoved(MouseEvent event) {
		 this.pointEnd = event.getPoint();
		 get_mode(buttons.idx_which_is_chosen,event,this);
		 user_mode.mouseMoved(event);
     }
	 public void mouseDragged(MouseEvent event) {
		 this.pointEnd = event.getPoint();
         get_mode(buttons.idx_which_is_chosen,event,this);
         user_mode.mouseDragged(event);
         repaint();
     }
	 
	 private void get_mode(int mode_type,MouseEvent event,canvas_panel canvas)
	 {
		 if(event.getButton()== MouseEvent.BUTTON1)
		 switch(mode_type) {
		 	case -1:
		 		user_mode = no_action;
		 		
		 		break;
		 	case 0:
		 		user_mode = mouse;
		 		
		 		break;
		 	case 4:
		 		user_mode = class_;
		 		break;
		 }
	 }
	 private void call_all_m_listener(MouseEvent event)
	 {
		/*user_mode.mousePressed(event);
	 	user_mode.mouseClicked(event);
		user_mode.mouseExited(event);
		user_mode.mouseEntered(event);
		user_mode.mouseDragged(event);
		user_mode.mouseMoved(event);
		user_mode.mouseReleased(event);
		*/
	 }
	 
	 public static void unselect_all_obj()
	 {
		 for(int index = 0; index < all_objs_in_canvas.size(); index++){
				all_objs_in_canvas.get(index).main_label.unselected_this_obj();
		}
	 }
	 
	 public void paint(Graphics g){
	     super.paint(g);
	     if (pointStart != null && 
	   	  user_mode.getMode() == Parameters.Button.mouse.ordinal()) {
	   	  drawRect(g);
         }
	   }
	 
	 public void drawRect(Graphics g)
	 {
         g.setColor(Color.BLACK);
		 g.drawLine(this.pointStart.x, this.pointStart.y, this.pointEnd.x, this.pointStart.y);
         g.drawLine(this.pointStart.x, this.pointStart.y, this.pointStart.x, this.pointEnd.y);
         g.drawLine(this.pointEnd.x,   this.pointStart.y, this.pointEnd.x, this.pointEnd.y);
         g.drawLine(this.pointStart.x, this.pointEnd.y, this.pointEnd.x, this.pointEnd.y);
	 }
}