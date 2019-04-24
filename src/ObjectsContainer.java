import java.util.ArrayList;

public class ObjectsContainer {
	public ArrayList<ObjectsContainer> all_input =new ArrayList<ObjectsContainer>();
	public ArrayList<BasicObject> current_objs = new ArrayList<BasicObject>();
	public Boolean it_is_a_BasicObject = false;
	
	ObjectsContainer(){}
	
	ObjectsContainer(ArrayList<ObjectsContainer> input_containers){
		this.all_input = input_containers;
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
	
	
	private void flatten_all_input_to_current_objs(ArrayList<ObjectsContainer> input_containers) {
		for (int c_index = 0; c_index < input_containers.size(); c_index++) {
			this.current_objs.addAll(input_containers.get(c_index).current_objs);
		}
	}
	
	public void disGroup(){
		if(this.it_is_a_BasicObject == true) {
			return;
		}
	}
}
	