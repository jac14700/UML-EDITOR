import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

class BasicObject extends JPanel{
	private static final long serialVersionUID = 1L;
	protected int start_x , start_y ,end_x ,end_y;
	protected int layer_order;
	public JLabel label;
	protected JLabel message;
	protected Dimension size;
	BasicObject(){}
	BasicObject(int x, int y)
	{
		setStartPoint(x,y);
		label = new JLabel();
		label.setOpaque(true);
		label.setBackground(Color.orange);
		label.setLocation(this.start_x,this.start_y);
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
    private void setStartPoint(int x, int y) {
        this.start_x = x;
        this.start_y = y;
    }
}