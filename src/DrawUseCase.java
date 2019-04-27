import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Point;
import javax.swing.JLabel;

public class DrawUseCase extends BasicObject{
	private static final long serialVersionUID = 1L;
	private String  name = "Now or never!";
	private Dimension size_of_use_case = new Dimension(100, 100);
	
	DrawUseCase(Point start){
		super(start);
		this.size = size_of_use_case;
		this.end = new Point(this.start.x + this.size.width, this.start.y + this.size.width);
		init_obj_points_parameters();
		init_main_label();
		init_message();
	}
	
	private void init_message() {
		GridBagConstraints gbc = new GridBagConstraints();
	    gbc.anchor = GridBagConstraints.CENTER;
	    gbc.weighty = 1;
	    this.message.setText(name);
	    this.message.setVerticalAlignment(JLabel.TOP);
	    this.main_label.add(message, gbc);
	}
	
	private void init_main_label() {
		this.main_label.mode = Parameters.Button.user_case.ordinal();
		this.main_label.setOpaque(false);
		this.main_label.setLocation(this.start.x,this.start.y);
		this.main_label.setLayout(new GridBagLayout());
		this.main_label.setSize(size);
	}
	
	private void init_obj_points_parameters() {
		this.end.x = this.start.x + this.size.width;
		this.end.y = this.start.y + this.size.height;
		this.center.x = this.start.x + this.size.width/2;
		this.center.y = this.start.y + this.size.height/2;
		this.port_up.x = this.center.x;
		this.port_up.y = this.start.y;
		this.port_down.x = this.center.x;
		this.port_down.y = this.end.y;
		this.port_left.x = this.start.x;
		this.port_left.y = this.center.y;
		this.port_down.x = this.center.x;
		this.port_down.y = this.end.y;
	}
}
