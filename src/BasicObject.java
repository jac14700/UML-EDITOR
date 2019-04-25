import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

class BasicObject extends JPanel{
	private static final long serialVersionUID = 1L;
	public Point start,end;
	public Main_Label main_label = new Main_Label();
	protected JLabel message= new JLabel();
	protected Dimension size;
	protected int idx_in_array_of_groups = Parameters.nonGroup;
	BasicObject(){
	 init();
	}
	BasicObject(Point start){
		init(start);
	}
	protected void init()
	{
		add_mouse_listener_to_main_label(this,this.start);
	}
	protected void init(Point start)
	{
		this.start = start;
		add_mouse_listener_to_main_label(this,this.start);
	}
	protected void add_mouse_listener_to_main_label (BasicObject obj,Point start) {
		this.main_label.addMouseListener(
		new MouseListener() {
			private Point m_start = new Point(0,0);
			private Point m_end = new Point(0,0);
			public void mouseClicked(MouseEvent event){}
			public void mouseExited(MouseEvent event){}
			public void mouseEntered(MouseEvent event){}
			public void mousePressed(MouseEvent event){
				if(buttons.idx_which_is_chosen == Parameters.Button.mouse.ordinal())
				{
					canvas_panel.unselect_all_obj();
					System.out.println("this obj belong to " + idx_in_array_of_groups + "group.");
					select_the_entire_group();
                }
			}
			public void mouseReleased(MouseEvent event) {
				System.out.println("mouseReleased:"+m_end);
				//move_the_entire_group();
			}
			public void mouseDragged(MouseEvent event){
				System.out.println("mouseDragged:"+m_end);
				obj.main_label.setLocation(m_end.x,m_end.y);
	            getParent().repaint();
			}; 
			public void mouseMoved(MouseEvent event){
				m_end = event.getPoint();
				System.out.println("mouseMoved:"+m_end);
				obj.main_label.setLocation(m_end.x,m_end.y);
				revalidate();
	            getParent().repaint();
			}
		});
	}
	protected void move_the_entire_group() {}
	protected void select_the_entire_group(){
		canvas_panel.chosen_groups.clear();
		canvas_panel.chosen_group_idx.clear();
		int selected_group = this.idx_in_array_of_groups;
		canvas_panel.chosen_groups.add(canvas_panel.array_of_groups.get(selected_group));
		canvas_panel.chosen_group_idx.add(selected_group);
		
		repainting_every_obj_in_the_container(selected_group);
	}
	private void repainting_every_obj_in_the_container(int selected_group) {
		for(int obj_idx = 0; obj_idx < canvas_panel.array_of_groups.get(selected_group).current_objs.size(); obj_idx++) {
			BasicObject tmp_obj = canvas_panel.array_of_groups.get(selected_group).current_objs.get(obj_idx);
			tmp_obj.main_label.select_this_object();
		}
	}
}