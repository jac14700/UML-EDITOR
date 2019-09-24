package panels;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.*;

import buttons.button_graphic;
import buttons.buttons;
import modes.mode_association_line;
import modes.mode_class;
import modes.mode_composition_line;
import modes.mode_gerneralization_line;
import modes.mode_mouse;
import modes.mode_use_case;

public class button_panel extends JPanel_Listener_MotionListener_Mouse {
	private static final long serialVersionUID = 1L;	
	public String dir = "G:\\java\\12\\12\\images";
	public String img_directory_chosen = dir + "\\chosen\\";
	public String img_directory_unchosen = dir + "\\unchosen\\";
	public Point temp_for_mode_mouse_start_p = new Point(0,0);
	public String file_name_of_oval = "C:\\Users\\user\\source\\eclipse\\UML-EDITOR\\images\\oval";
	public String[] file_names_of_buttons= 
		{
			"select.png",
			"association.png",
		    "general.png",
		    "composition.png",
		    "class.png",
		    "usecase.png"
		};
	
	private int total_button_num = 6;
	public static int panel_w = 150;
	private int panel_h;
	public buttons button_group = new buttons();

	public static mode_mouse mouse = new mode_mouse();
	public canvas_panel canvas;
	
	public button_panel(int fram_h, canvas_panel canvas) {
			this.panel_h = fram_h;
			this.canvas = canvas;
			init_panel_setting();
			init_every_button(this.canvas);
			
	}
	
	
	
	private void init_panel_setting()
	{
			this.setBackground(Color.RED);
			this.setSize(new Dimension(button_panel.panel_w, this.panel_h));
	}
	private void init_every_button(canvas_panel canvas)
	{
			for(int index = 0; index < this.total_button_num; index ++) {
				load_image_and_set_x_and_y(this.button_group ,index );
				add_mouse_listener(this.button_group ,index ,this.total_button_num );
				this.add( buttons.group[index].picLabel );
			}
			buttons.group[0].mode_ = new mode_mouse();
			buttons.group[1].mode_ = new mode_association_line();
			buttons.group[2].mode_ = new mode_gerneralization_line();
			buttons.group[3].mode_ = new mode_composition_line();
			buttons.group[4].mode_ = new mode_class(this.canvas);;
			buttons.group[5].mode_ = new mode_use_case(this.canvas);;
			
	}
	
	
	private void load_image_and_set_x_and_y(buttons button_group,int index)
	{
		buttons.group[index] = new button_graphic();
		buttons.group[index].set_parameters(this.img_directory_unchosen,
													  this.file_names_of_buttons[index]);
	}
	
	private void add_mouse_listener(buttons button_group, int chosen_idx, int total_button_num) 
	{
		buttons.group[chosen_idx].picLabel.addMouseListener(
			new MouseListener() {
	
				public void mouseClicked(MouseEvent arg0) {
				}
				public void mouseExited(MouseEvent arg0) {
				}
				public void mouseEntered(MouseEvent arg0) {
				}
				public void mousePressed(MouseEvent arg0) {
					button_group.button_clicked(chosen_idx);
				}
				public void mouseReleased(MouseEvent arg0) {
				}
			});
		}	
}