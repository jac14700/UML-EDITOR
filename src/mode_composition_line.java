import java.awt.event.MouseEvent;
import javax.swing.JPanel;

public class mode_composition_line extends mode {
	public static Boolean dragged = false, entered_a_obj = false; 
	public static int start_g_idx_in_array_of_groups = Parameters.no_obj;
	public static int start_obj_idx_in_the_group  = Parameters.no_obj;
	public void mouseClicked(MouseEvent arg0) {}
	public void mouseExited(MouseEvent arg0) {}
	public void mouseEntered(MouseEvent arg0) {}
	public void mousePressed(MouseEvent arg0) {}
	public void mouseReleased(MouseEvent arg0) {}
	public void mouseDragged(MouseEvent e) {}
	public void mouseMoved(MouseEvent e) {}
	public int getMode() {
		return Parameters.Button.association_line.ordinal();
	}
}