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
	BasicObject(Point start)
	{
		setStartPoint(start);
		label = new JLabel();
		label.setOpaque(true);
		label.setBackground(Color.orange);
		label.setLocation(start.x,start.y);
        label.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.weighty = 1;
        Border border = BorderFactory.createLineBorder(Color.BLACK, 2);
        label.setBorder(border);
        message = new JLabel("Go that way!");
        message.setVerticalAlignment(JLabel.TOP);        
        label.add(message, gbc);
        this.size=new Dimension(100, 100);
        label.setSize(size);
    }
    private void setStartPoint(Point start) {
    	this.start = start;
    }
}