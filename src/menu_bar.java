import javax.swing.*;
import java.awt.event.*;
public class menu_bar {
	public JMenuBar menu_bar;
	private JMenu edit;
	private JMenuItem group;
	private JMenuItem ungroup;
	private JMenuItem change_obj_name;
	
	menu_bar()
	{
		 menu_bar = new JMenuBar();
		 edit = new JMenu("Edit Menu");
		 group = new JMenuItem("Group");
		 ungroup = new JMenuItem("UnGroup");
		 init_change_obj_name();
		 		 
		 edit.add(group);
		 edit.add(ungroup);
		 edit.add(change_obj_name);
		 menu_bar.add(edit);
	}
	private void init_change_obj_name()
	{
		change_obj_name = new JMenuItem("change object name");
		 change_obj_name.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
			 JOptionPane.showMessageDialog(null,"Hi");
			};
		 });
	}
}
