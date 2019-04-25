import java.awt.Point;
import java.util.ArrayList;

public class Parameters {
	
	public static String img_directory_chosen = "C:\\Users\\user\\source\\eclipse\\UML-EDITOR\\images\\chosen\\";
	public static String img_directory_unchosen = "C:\\Users\\user\\source\\eclipse\\UML-EDITOR\\images\\unchosen\\";
	public static Point temp_for_mode_mouse_start_p = new Point(0,0);
	public static String file_name_of_oval = "C:\\Users\\user\\source\\eclipse\\UML-EDITOR\\images\\oval";
	public static String[] file_names_of_buttons= 
		{
			"select.png",
			"association.png",
		    "general.png",
		    "composition.png",
		    "class.png",
		    "usecase.png"
		};

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
	public static int line_start_group_idx = undefined;
	public static int line_end_group_idx = undefined;
	public static int line_start_obj_idx = undefined;
	public static int line_end_obj_idx = undefined;
	
	public enum Button {
		mouse,
		association_line,
		gerneralization_line,
		composition_line, 
		draw_class, 
		user_case;	
	}
}