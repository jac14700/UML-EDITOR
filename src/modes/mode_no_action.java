package modes;

import utilities.Parameters;

public class mode_no_action extends mode {
	private static final long serialVersionUID = 1L;
	private int mode_type = Parameters.Button_no_action;
	public int getMode()
	{
		return this.mode_type;
	}
}
