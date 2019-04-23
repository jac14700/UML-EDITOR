import java.util.ArrayList;

public class ObjectsContainer {
	ArrayList<ArrayList<BasicObject>> pre_arrays =new ArrayList<ArrayList<BasicObject>>();
	ArrayList<BasicObject> current_array = new ArrayList<BasicObject>();
	
	ObjectsContainer(ArrayList<BasicObject> obj_array){
		this.current_array.addAll(obj_array);
		this.pre_arrays.add(obj_array);
	}
	
	ObjectsContainer(ArrayList<ArrayList<BasicObject>> array_of_obj_array, boolean it_is_an_array_of_array){
		this.pre_arrays.addAll(array_of_obj_array);
		for(int index = 0; index < array_of_obj_array.size(); index++)
		{
			this.current_array.addAll(array_of_obj_array.get(index));
		}
	}

	public ArrayList<ArrayList<BasicObject>> disgroup()
	{
		return pre_arrays;
	}
}