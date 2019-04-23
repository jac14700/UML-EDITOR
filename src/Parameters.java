import java.awt.Point;

public class Parameters {
	
	public static String img_directory_chosen = "C:\\Users\\user\\source\\eclipse\\UML-EDITOR\\images\\chosen\\";
	public static String img_directory_unchosen = "C:\\Users\\user\\source\\eclipse\\UML-EDITOR\\images\\unchosen\\";
	public static Point temp_for_mode_mouse_start_p = new Point(0,0);
	public static String[] file_names_of_buttons= 
		{
			"select.png",
			"association.png",
		    "general.png",
		    "composition.png",
		    "class.png",
		    "usecase.png"
		};
	
	public static int Button_no_action = -1;
	public enum Button {
		mouse,
		association_line,
		gerneralization_line,
		composition_line, 
		draw_class, 
		user_case;	
	}
}