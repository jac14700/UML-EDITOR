package modes;
import java.awt.event.MouseEvent;
import panels.canvas_panel;
import shapes.gerneralization;
import utilities.Parameters;

public class mode_gerneralization_line  extends mode {
	private static final long serialVersionUID = 1L;
	public Boolean dragged = false, entered_a_obj = false; 
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
	public void ExitedObjs() {this.entered_a_obj = false;}
	public void EnterObjs()  {
		if(this.dragged) {
			this.entered_a_obj = true;
		}
	}
	public void PressObjs(int idx) {
		this.dragged = true;
	}	

	public void ReleaseObjs() {
		if(this.dragged&&this.entered_a_obj) {
			canvas_panel.all_lines.add(new gerneralization());
		}
	}
}