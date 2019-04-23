import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class Main_Label extends JPanel  {
	private static final long serialVersionUID = 1L;
	public Boolean selected = false;
	
	public void unselected_this_obj()
	{
		this.selected = false;
		this.setBorder(null);
		System.out.println("unselected_this_obj");
	}
	
	
	//不是這個方式運作
	public void select_this_object()
	{
		this.selected = true;
		Border border = BorderFactory.createLineBorder(Color.BLACK, 2);
		this.setBorder(border);
	}
}
