package modes;
import java.awt.event.MouseEvent;
import panels.canvas_panel;
import shapes.association;
import utilities.Parameters;

public class mode_association_line extends mode {
	private static final long serialVersionUID = 1L;
	public Boolean dragged = false, entered_a_obj = false; 
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
			canvas_panel.all_lines.add(new association());
		}
	}
}