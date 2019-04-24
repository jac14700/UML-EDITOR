import java.util.ArrayList;

public class ObjectsContainer {
	public ArrayList<ObjectsContainer> all_input =new ArrayList<ObjectsContainer>();
	public ArrayList<BasicObject> current_objs = new ArrayList<BasicObject>();
	public static Boolean it_is_a_BasicObject = false;
	
	ObjectsContainer(){}
	
	ObjectsContainer(ArrayList<ObjectsContainer> input_containers){
		flatten_input_containers_to_current_objs(input_containers);		
		flatten_all_input_to_current_objs(input_containers);
	}
	ObjectsContainer(BasicObject basic_obj){
		this.current_objs.add(basic_obj);
		this.it_is_a_BasicObject = true;
	}
	
	//add只能用在一次的連續包裹，之後此container則不能再繼續使用
	public void add(ObjectsContainer input_container) {
		this.all_input.add(input_container);
		this.current_objs.addAll(input_container.current_objs);
	}
	public void add(ArrayList<ObjectsContainer> chosen_groups) {
		flatten_all_input_to_current_objs(chosen_groups);
		this.all_input.addAll(chosen_groups);
	}
	
	private void flatten_input_containers_to_current_objs(ArrayList<ObjectsContainer> input_containers) {
		for(int idx =0; idx < input_containers.size(); idx++) {
			this.all_input.add(input_containers.get(idx));
		}
	}
	
	private void flatten_all_input_to_current_objs(ArrayList<ObjectsContainer> input_containers) {
		for (int c_index = 0; c_index < input_containers.size(); c_index++) {
			this.current_objs.addAll(input_containers.get(c_index).current_objs);
		}
	}
	
	public static void disGroup(int disgoup_index){
		if(canvas_panel.array_of_groups.get(disgoup_index).it_is_a_BasicObject == true){}
		else {
				ObjectsContainer tmp_groups = new ObjectsContainer(canvas_panel.array_of_groups);
				ObjectsContainer the_disgroup_group = tmp_groups.all_input.get(disgoup_index);
				canvas_panel.array_of_groups.remove(disgoup_index);
				canvas_panel.array_of_groups.addAll(the_disgroup_group.all_input);
		}
	}
}
	