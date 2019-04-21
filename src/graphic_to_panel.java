import javax.swing.JPanel;

abstract class Graphic_to_c_panel extends JPanel{
	private static final long serialVersionUID = 1L;
	protected int start_x , start_y ,end_x ,end_y;
	protected int layer_order;
	Graphic_to_c_panel(){}
	Graphic_to_c_panel(int x, int y)
	{
		setStartPoint(x,y);
    }
    private void setStartPoint(int x, int y) {
        this.start_x = x;
        this.start_y = y;
    }
    protected abstract void draw();
    protected abstract void moveTo(int newX, int newY);
}