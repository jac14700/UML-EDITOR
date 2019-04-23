import java.awt.Color;
import java.awt.Dimension;
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
	protected JLabel message;
	protected Dimension size;
	BasicObject(){}
	BasicObject(Point start){}
    protected void setStartPoint(Point start) {
    	this.start = start;
    }
}