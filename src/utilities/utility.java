package utilities;
import java.util.Scanner;

import panels.canvas_panel;

public class utility {
     private static final Scanner SCANNER = new java.util.Scanner(System.in);

	public static void Pause(){

          System.out.println("Press Any Key To Continue...");
          SCANNER.nextLine();
     };
	 public static void unselect_all_obj()
	 {
		 for(int index = 0; index < canvas_panel.all_objs_in_canvas.size(); index++){
			 canvas_panel.all_objs_in_canvas.get(index).unselected_this_obj();
		}
	 }
}