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
	public static ArrayList<ObjectsContainer> array_of_groups = new ArrayList<ObjectsContainer>();
	public static ArrayList<BasicObject> all_objs_in_canvas = new ArrayList<BasicObject>();
	public static ArrayList<ObjectsContainer> chosen_groups =  new ArrayList<ObjectsContainer>();
	public static ArrayList<Integer> chosen_group_idx = new ArrayList<Integer>();
	public static ArrayList<line> all_lines = new ArrayList<line>();
	private mode user_mode = new mode_no_action();
	private mode_mouse mouse;
	private mode_no_action no_action;
	private mode_class class_;
	private mode_use_case use_case;
	private mode_association_line association_line;
	
	canvas_panel(int frame_w,int frame_h) {
		init_every_setting(frame_w,frame_h);
		
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
		 this.no_action= new mode_no_action();
		 this.mouse = new mode_mouse(this);
		 this.association_line= new mode_association_line();
		 this.class_= new mode_class(this);
		 this.use_case= new mode_use_case(this);
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
		 		Parameters.Button.mouse.ordinal();
		 		break;
		 	case 0:
		 		user_mode = mouse;
		 		
		 		break;
		 	case 1:
		 		user_mode = association_line;
		 		break;
		 	case 4:
		 		user_mode = class_;
		 		break;
		 	case 5:
		 		user_mode = use_case;
		 		break;
		 }
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
	     if(all_lines.size()!=0) {
	    	 System.out.println("Hi");
	    	 drawLine(g);
	     }
	   }
	 public void drawLine(Graphics g) {
		 g.setColor(Color.BLACK);
		 for(int idx =0; idx <all_lines.size(); idx++) {
			 System.out.println(this.all_lines.get(idx).start_p);
	    	 System.out.println(this.all_lines.get(idx).end_p);
			 g.drawLine(this.all_lines.get(idx).start_p.x, this.all_lines.get(idx).start_p.y,
					 	this.all_lines.get(idx).end_p.x, this.all_lines.get(idx).end_p.y); 
		 }
	 } 
	 public static void draw_line(Point line_start, Point line_end) {
		 
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