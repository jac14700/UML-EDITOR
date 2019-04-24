import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

import java.awt.event.*;
import java.util.ArrayList;
public class menu_bar  implements MenuListener{
	public JMenuBar menu_bar;
	private JMenu edit;
	private JMenuItem group,disgroup,change_obj_name;
	private canvas_panel canvas;
	menu_bar(canvas_panel canvas)
	{
		this.canvas = canvas;
		 menu_bar = new JMenuBar();
		 edit = new JMenu("Edit Menu");
		 edit.addMenuListener(this);
		 group = new JMenuItem("Group");
		 disgroup = new JMenuItem("Disgroup");
		 init_change_obj_name();
		 init_group(this.canvas);
		 init_disgroup(this.canvas);
		 edit.add(group);
		 edit.add(disgroup);
		 edit.add(change_obj_name);
		 menu_bar.add(edit);
	}
	private void init_group(canvas_panel canvas)
	{
		group = new JMenuItem("Group");
		group.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){

				ObjectsContainer tmp_container = new ObjectsContainer(canvas_panel.chosen_groups);
				System.out.println(tmp_container.all_input.size());
				
				
				for(int g_index=0; g_index< canvas_panel.array_of_groups.size();g_index++) {
					if(group_chosen(g_index)){continue;}
					else {tmp_container.add(canvas_panel.array_of_groups.get(g_index));}
				}

				System.out.println(tmp_container.all_input.size());
				canvas_panel.array_of_groups.clear();
				System.out.println(canvas_panel.array_of_groups.size());
				canvas_panel.array_of_groups.addAll(tmp_container.all_input);
				System.out.println(canvas_panel.array_of_groups.size());
				System.out.println("Hello");
				updata_every_obj_its_group_id();
				canvas_panel.saving_static_variable();
			};
		 });
	}	

	private boolean group_chosen(int g_index) {
		boolean true_or_false = false;
		for(int c_index=0; c_index< canvas_panel.chosen_group_idx.size(); c_index++) {
			if(g_index == c_index) {
				true_or_false =true;
				break;}
		}
		return true_or_false;
	}
	private void init_disgroup(canvas_panel canvas)
	{
		disgroup = new JMenuItem("Disgroup");
		disgroup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				int the_most_outside_group_id = canvas_panel.array_of_groups.size() - Parameters.subtract_one_for_right_index;
				canvas_panel.unselect_all_obj();
			};
		 });
	}
	private void updata_every_obj_its_group_id()
	{
		for(int g_index=0; g_index < canvas_panel.array_of_groups.size(); g_index++)
		{
			ArrayList<BasicObject> tmp_obj_array = canvas_panel.array_of_groups.get(g_index).current_objs;
			for(int o_index = 0; o_index < tmp_obj_array.size(); o_index++) {
				tmp_obj_array.get(o_index).idx_in_array_of_groups = g_index;
			}
		}
		/*int id = canvas_panel.array_of_groups.size() - Parameters.subtract_one_for_right_index;
		System.out.println(id );
		ObjectsContainer tmp_container = canvas_panel.array_of_groups.get(id);
		
		for(int tmp_idx = 0; tmp_idx < tmp_container.current_group.size(); tmp_idx++) {
			BasicObject tmp_obj = tmp_container.current_group.get(tmp_idx);
			tmp_obj.idx_in_array_of_groups = id;
		}*/
	}
	private void init_change_obj_name()
	{
		change_obj_name = new JMenuItem("Change object name");
		 change_obj_name.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
			 JOptionPane.showMessageDialog(null,"Hi");
			};
		 });
	}
	@Override
	public void menuSelected(MenuEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void menuDeselected(MenuEvent e) {
		// TODO Auto-generated method stub
		
		
	}
	@Override
	public void menuCanceled(MenuEvent e) {
		// TODO Auto-generated method stub
		
	}
}
