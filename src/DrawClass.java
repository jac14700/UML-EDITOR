import java.awt.*;
import javax.swing.JLabel;

public class DrawClass extends BasicObject{
	private static final long serialVersionUID = 1L;
	private String  name = "Now or never!";
	private Dimension size_of_class = new Dimension(100, 100);
	
	DrawClass(Point start){
		super(start);
		this.main_label.setOpaque(true);
		this.main_label.setBackground(Color.orange);
		this.main_label.setLocation(this.start.x,this.start.y);
		this.main_label.setLayout(new GridBagLayout());
	    GridBagConstraints gbc = new GridBagConstraints();
	    gbc.anchor = GridBagConstraints.NORTH;
	    gbc.weighty = 1;
	    
	    this.message.setText(name);
	    this.message.setVerticalAlignment(JLabel.TOP);        
	    this.main_label.add(message, gbc);
	    this.size = size_of_class;
	    this.main_label.setSize(size);
	    this.end = new Point(this.start.x + this.size.width, this.start.y + this.size.width);
	}
}