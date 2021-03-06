package panels;
import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

import shapes.ObjectsContainer;
import utilities.Parameters;

import java.awt.event.*;

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
				
				ObjectsContainer Grouping = new  ObjectsContainer(canvas_panel.chosen_groups);
				ObjectsContainer tmp_container = new ObjectsContainer();

				//包裹其他沒有被group的containers
				for(int g_index=0; g_index< canvas_panel.array_of_groups.size();g_index++) {
					if(group_chosen(g_index)){continue;}
					else {
						tmp_container.add(canvas_panel.array_of_groups.get(g_index));
					}
				}
				canvas_panel.array_of_groups.clear();
				canvas_panel.array_of_groups.addAll(tmp_container.all_input);
				canvas_panel.array_of_groups.add(Grouping);
				canvas_panel.array_of_groups.get(canvas_panel.array_of_groups.size()- Parameters.subtract_one_for_right_index).it_is_a_BasicObject = false;
				updata_every_obj_its_group_id();
			};
		 });
	}	
	private void updata_every_obj_its_group_id()
	{
		for(int g_index=0; g_index < canvas_panel.array_of_groups.size(); g_index++)
		{
			int tmp_obj_array_size = canvas_panel.array_of_groups.get(g_index).current_objs.size();
			for(int o_index = 0; o_index < tmp_obj_array_size; o_index++) {
				canvas_panel.array_of_groups.get(g_index).current_objs.get(o_index).idx_in_array_of_groups = g_index;
			}
		}
	}
	private boolean group_chosen(int g_index) {
		boolean true_or_false = false;
		for(int c_index=0; c_index< canvas_panel.chosen_group_idx.size(); c_index++) {
			if(g_index == canvas_panel.chosen_group_idx.get(c_index)) {
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
				
				if(canvas_panel.chosen_groups.size() == 1) {
					int disgroup_idx = canvas_panel.chosen_groups.get(0).current_objs.get(0).idx_in_array_of_groups;
					ObjectsContainer.disGroup(disgroup_idx);
					updata_every_obj_its_group_id();
				}
			};
		 });
	}
	
	private void init_change_obj_name()
	{
		change_obj_name = new JMenuItem("Change object name");
		 change_obj_name.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				if(chosing_a_singal_obj()) {
					String new_name;
					new_name =  JOptionPane.showInputDialog("new name","new name");
					if(new_name != null) {
						canvas_panel.chosen_groups.get(0).current_objs.get(0).name = new_name;
					}
				}
			};
		 });
	}
	private boolean chosing_a_singal_obj() {
		return (canvas_panel.chosen_groups.size() == 1 &&
		   canvas_panel.chosen_groups.get(0).current_objs.size()== 1) ;
	}
	public void menuSelected(MenuEvent e) {}
	public void menuDeselected(MenuEvent e) {}
	public void menuCanceled(MenuEvent e) {}
}
