package buttons;

public class buttons{
	private int total_buttons = 6;
	private static int no_action = -1;
	public static int idx_which_is_chosen = no_action;
	private int idx_which_to_unchoose;
	public static  button_graphic [] group;
	public String dir = "G:\\java\\12\\12\\images";
	public String img_directory_chosen = dir + "\\chosen\\";
	public String img_directory_unchosen = dir + "\\unchosen\\";


	public buttons()
	{
		buttons.group = new button_graphic[this.total_buttons];
	}


	
	private void set_chosen(int button_index)	
	{
		buttons.idx_which_is_chosen = button_index;
		
		buttons.group[buttons.idx_which_is_chosen].selected = true;
		buttons.group[buttons.idx_which_is_chosen].set_path(img_directory_chosen);
		buttons.group[buttons.idx_which_is_chosen].update_parmeters();
		buttons.group[buttons.idx_which_is_chosen].picLabel.repaint();
	}
	private void cancel_chosen(int button_index)
	{
		this.idx_which_to_unchoose = button_index;
		buttons.idx_which_is_chosen = no_action;
		buttons.group[this.idx_which_to_unchoose].selected = false;
		buttons.group[this.idx_which_to_unchoose].set_path(img_directory_unchosen);
		buttons.group[this.idx_which_to_unchoose].update_parmeters();
		buttons.group[this.idx_which_to_unchoose].update_parmeters();
		buttons.group[this.idx_which_to_unchoose].picLabel.repaint();
	}
	private void set_unchosen()
	{
		this.idx_which_to_unchoose = buttons.idx_which_is_chosen;
		buttons.group[this.idx_which_to_unchoose].selected = false;
		buttons.group[this.idx_which_to_unchoose].set_path(img_directory_unchosen);
		buttons.group[this.idx_which_to_unchoose].update_parmeters();
		buttons.group[this.idx_which_to_unchoose].update_parmeters();
		buttons.group[this.idx_which_to_unchoose].picLabel.repaint();
	}
	


	
	public void button_clicked(int button_index)
	{
		if( buttons.idx_which_is_chosen == no_action)
		{
			set_chosen(button_index);
		}
		else if(buttons.idx_which_is_chosen  ==  button_index)
		{
			System.out.println("cancel_chosen");
			cancel_chosen(button_index);

		}else {
			set_unchosen();
			set_chosen(button_index);
		}
	}
}
