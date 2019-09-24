package utilities;
import java.awt.Point;
import java.util.ArrayList;

import shapes.BasicObject;
import shapes.ObjectsContainer;

public class Parameters {

	public static int undefined = -1;
	public static Point temp_for_mode_mouse_m_start = new Point(0,0);
	public static ArrayList<ObjectsContainer> tmp_array_of_groups = new ArrayList<ObjectsContainer>();
	public static ArrayList<BasicObject> tmp_all_objs_in_canvas = new ArrayList<BasicObject>();
	public static ArrayList<ObjectsContainer> tmp_chosen_groups =  new ArrayList<ObjectsContainer>();
	public static ArrayList<Integer> tmp_chosen_group_idx = new ArrayList<Integer>();
	public static int subtract_one_for_right_index = 1;
	public static int nonGroup = undefined;
	public static int Button_no_action = undefined;
	public static int no_obj = undefined;
	public static int line_start_obj_idx = undefined;
	public static int line_end_obj_idx = undefined;
	public static int association_line = 0;
	public static int gerneralization_line = 1;
	public static int composition_line = 2;
	public static final int up_port = 0;
	public static final int left_port = 1;
	public static final int right_port = 2;
	public static final int down_port = 3;
	
	public enum Button {
		mouse,
		association_line,
		gerneralization_line,
		composition_line, 
		draw_class, 
		user_case;	
	}
}