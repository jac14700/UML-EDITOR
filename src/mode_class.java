import java.awt.event.MouseEvent;

public class mode_class implements mode {
	private ObjectsContainer tmp_obj;
	private canvas_panel canvas;
	public mode_class(canvas_panel canvas)
	{
		this.canvas = canvas;
	}
	public void mouseClicked(MouseEvent arg0) {};
	public void mouseExited(MouseEvent arg0){};
	public void mouseEntered(MouseEvent arg0){};
	public void mousePressed(MouseEvent arg0){
		this.tmp_obj = new DrawClass(arg0.getPoint(),this.tmp_obj);
		this.canvas.add(this.tmp_obj.label);
		this.canvas.repaint();
	};
	public void mouseReleased(MouseEvent arg0){};
	public void mouseDragged(MouseEvent e){}; 
	public void mouseMoved(MouseEvent e){};
}
