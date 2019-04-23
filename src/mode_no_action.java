import java.awt.event.MouseEvent;

public class mode_no_action implements mode {
	private String mode = "no_action";
	public mode_no_action()
	{
		
	}
	public void mouseClicked(MouseEvent arg0) {};
	public void mouseExited(MouseEvent arg0){};
	public void mouseEntered(MouseEvent arg0){};
	public void mousePressed(MouseEvent arg0){};
	public void mouseReleased(MouseEvent arg0){};
	public void mouseDragged(MouseEvent e){}; 
	public void mouseMoved(MouseEvent e){};
	public String getMode()
	{
		return this.mode;
	}
}
