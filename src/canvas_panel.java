import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;



public class canvas_panel extends JPanel_Listener_MotionListener_Mouse {
	
	private int panel_w;
	private int panel_h;
	private Point pointStart = null;
	private Point pointEnd   = null;
	
	private BasicObject pie,apple,apple2,pie2;
	private ArrayList<ObjectsContainer> array_of_containers;
	private ObjectsContainer group;
	private ArrayList<BasicObject> all_objs = new ArrayList<BasicObject>(),
								   chosen_objs =  new ArrayList<BasicObject>();
	private mode user_mode = new mode_no_action();
	
	canvas_panel(int frame_w,int frame_h) {
		init_every_setting(frame_w,frame_h);
		pie = new DrawClass(new Point(10,100));
		this.apple = new DrawClass(new Point(120,200));
		this.pie2 = new DrawClass(new Point(50,100));
		this.apple2 = new DrawClass(new Point(520,200));
		
		
		
		//group ªº¤u§@
		this.chosen_objs.add(apple);
		this.chosen_objs.add(pie);
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
	 public void mouseReleased(MouseEvent e) {
         pointStart = null;
         repaint();
     }
	 public void mouseMoved(MouseEvent e) {
         pointEnd = e.getPoint();
     }
	 public void mouseDragged(MouseEvent e) {
         pointEnd = e.getPoint();
         repaint();
     }
	 private void get_mode(int mode_type,MouseEvent event,canvas_panel canvas)
	 {
		 if(event.getButton()== MouseEvent.BUTTON1)
		 switch(mode_type) {
		 	case -1:
		 		user_mode = new mode_no_action();
		 		
		 		break;
		 	case 0:
		 		user_mode = new mode_mouse(canvas);
				this.pointStart = event.getPoint();
		 		
		 		break;
		 	case 4:
		 		user_mode = new mode_class(canvas,all_objs);
		 		user_mode.mousePressed(event);
		 		break;
		 }
	 }
	 
	 //public void mousePressed

	 public void drawRect(Graphics g)
	 {
         g.setColor(Color.BLACK);
         
		 g.drawLine(this.pointStart.x, this.pointStart.y, this.pointEnd.x, this.pointStart.y);
         g.drawLine(this.pointStart.x, this.pointStart.y, this.pointStart.x, this.pointEnd.y);
         g.drawLine(this.pointEnd.x,   this.pointStart.y, this.pointEnd.x, this.pointEnd.y);
         g.drawLine(this.pointStart.x, this.pointEnd.y, this.pointEnd.x, this.pointEnd.y);
	 }
	 public void paint(Graphics g) {
	      super.paint(g);  
	      if (pointStart != null && user_mode.getMode() == "mouse") {
	    	  drawRect(g);
          }
	   }
}