import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Point;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

class BasicObject extends JPanel{
	private static final long serialVersionUID = 1L;
	protected Point start,end;
	protected int layer_order;
	public JLabel label;
	protected JLabel message= new JLabel();
	protected Dimension size;
	protected Boolean selected = false;
	
	BasicObject(){}
	BasicObject(Point start){}
    protected void setStartPoint(Point start) {
    	this.start = start;
    }
    public void paint(Graphics g)
    {
    	super.paint(g);
    	g.setColor(Color.RED);
    	g.drawRect(this.start.x, this.start.y, 100, 100);
    }
}