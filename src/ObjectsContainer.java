import java.util.ArrayList;

public class ObjectsContainer extends BasicObject{
	public ArrayList<ObjectsContainer>input_group;
	public ArrayList<ObjectsContainer> original_group;
	public ArrayList<ObjectsContainer> group;
	
	ObjectsContainer(){
	}
	
	public void add(ArrayList<ObjectsContainer> input_group)
	{
		    this.original_group = this.group; 
			this.input_group.addAll(input_group);
			this.group.addAll(input_group);
	}
	public ArrayList<ObjectsContainer> disgroup()
	{
		this.group = this.original_group;
		return input_group;
	}
}
