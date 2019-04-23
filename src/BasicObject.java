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
	protected Point start,end;
	protected int layer_order;
	public Main_Label main_label = new Main_Label();
	protected JLabel message= new JLabel();
	protected Dimension size;
	
	BasicObject(){
	 init();
	}
	BasicObject(Point start){
		init(start);
	}
	protected void init()
	{
		add_mouse_listener_to_main_label();
	}
	protected void init(Point start)
	{
		this.start = start;
		add_mouse_listener_to_main_label();
	}
	protected void add_mouse_listener_to_main_label () {
		this.main_label.addMouseListener(
		new MouseListener() {
			public void mouseClicked(MouseEvent arg0) {
			}
			public void mouseExited(MouseEvent arg0) {
			}
			public void mouseEntered(MouseEvent arg0) {
			}
			public void mousePressed(MouseEvent arg0) {
				if(buttons.idx_which_is_chosen == Parameters.Button.mouse.ordinal())
				{
					canvas_panel.unselect_all_obj();
					main_label.select_this_object();
				}
			}
			public void mouseReleased(MouseEvent arg0) {
			}
		});
	}
	
    protected void setStartPoint(Point start){
    	
    }
}