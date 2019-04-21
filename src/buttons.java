public class buttons extends button_graphic{
	private int total_buttons = 6;
	private int no_action = -1;
	public int idx_which_is_chosen = no_action;
	private int idx_which_to_unchoose;
	public button_graphic [] group;
	
	buttons()
	{
		this.group = new button_graphic[this.total_buttons];
	}
	
	private void set_choosen(int button_index)
	{
		this.idx_which_is_chosen = button_index;
		this.group[this.idx_which_is_chosen].selected = true;
		this.group[this.idx_which_is_chosen].set_path(Parameters.img_directory_chosen);
		this.group[this.idx_which_is_chosen].update_parmeters();
		this.group[this.idx_which_is_chosen].picLabel.repaint();
	}
	private void cancel_choosen(int button_index)
	{
		this.idx_which_to_unchoose = button_index;
		this.idx_which_is_chosen = no_action;
		this.group[this.idx_which_to_unchoose].selected = false;
		this.group[this.idx_which_to_unchoose].set_path(Parameters.img_directory_unchosen);
		this.group[this.idx_which_to_unchoose].update_parmeters();
		this.group[this.idx_which_to_unchoose].update_parmeters();
		this.group[this.idx_which_to_unchoose].picLabel.repaint();
	}
	private void set_unchoosen()
	{
		this.idx_which_to_unchoose = this.idx_which_is_chosen;
		this.group[this.idx_which_to_unchoose].selected = false;
		this.group[this.idx_which_to_unchoose].set_path(Parameters.img_directory_unchosen);
		this.group[this.idx_which_to_unchoose].update_parmeters();
		this.group[this.idx_which_to_unchoose].update_parmeters();
		this.group[this.idx_which_to_unchoose].picLabel.repaint();
	}
	
	
	public void button_clicked(int button_index)
	{
		if( this.idx_which_is_chosen == no_action)
		{
			set_choosen(button_index);
		}
		else if(this.idx_which_is_chosen  ==  button_index)
		{
			System.out.println("cancel_choosen");
			cancel_choosen(button_index);

		}else {
			set_unchoosen();
			set_choosen(button_index);
		}
	}
}
