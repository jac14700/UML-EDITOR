import java.awt.event.MouseEvent;

public interface mode {
	abstract void mouseClicked(MouseEvent arg0);
	abstract void mouseExited(MouseEvent arg0);
	abstract void mouseEntered(MouseEvent arg0);
	abstract void mousePressed(MouseEvent arg0);
	abstract void mouseReleased(MouseEvent arg0);
	abstract void mouseDragged(MouseEvent e); 
	abstract void mouseMoved(MouseEvent e);
	abstract int getMode();
}