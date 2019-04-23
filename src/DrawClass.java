import java.awt.*;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.border.Border;

public class DrawClass extends BasicObject{
	
	DrawClass(Point start){
		this.setStartPoint(start);
		this.label = new JLabel();
		this.label.setOpaque(true);
		this.label.setBackground(Color.orange);
		this.label.setLocation(this.start.x,this.start.y);
		this.label.setLayout(new GridBagLayout());
	    GridBagConstraints gbc = new GridBagConstraints();
	    gbc.anchor = GridBagConstraints.NORTH;
	    gbc.weighty = 1;
	    Border border = BorderFactory.createLineBorder(Color.BLACK, 2);
	    this.label.setBorder(border);
	    this.message = new JLabel("Go that way!");
	    this.message.setVerticalAlignment(JLabel.TOP);        
	    this.label.add(message, gbc);
	    this.size=new Dimension(100, 100);
	    this.label.setSize(size);
	}
}