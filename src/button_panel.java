import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.*;

public class button_panel extends JPanel_Listener_MotionListener_Mouse {

	private static final long serialVersionUID = 1L;
	private int total_button_num = 6;
	public static int panel_w = 150;
	private int panel_h;
	private buttons button_group = new buttons();
	
	public button_panel(int fram_h) {
			this.panel_h = fram_h;
			init_panel_setting();
			init_every_button();
	}
	
	
	
	private void init_panel_setting()
	{
			this.setBackground(Color.RED);
			this.setSize(new Dimension(button_panel.panel_w, this.panel_h));
	}
	private void init_every_button()
	{
			for(int index = 0; index < this.total_button_num; index ++) {
				load_image_and_set_x_and_y(this.button_group ,index );
				add_mouse_listener(this.button_group ,index ,this.total_button_num );
				this.add( this.button_group.group[index].picLabel );
			}
	}
	
	
	
	
	private void load_image_and_set_x_and_y(buttons button_group,int index)
	{
		this.button_group.group[index] = new button_graphic();
		this.button_group.group[index].set_parameters(Parameters.img_directory_unchosen,
													  Parameters.file_names_of_buttons[index]);
	}
	
	private void add_mouse_listener(buttons button_group, int chosen_idx, int total_button_num) 
	{
		this.button_group.group[chosen_idx].picLabel.addMouseListener(
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