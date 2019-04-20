public class canvas_panel extends JPanel_with_MouseListener {
	private int width_size = 150;
	private int panel_w;
	private int panel_h;
	public canvas_panel(int fram_w,int fram_h) {
			this.panel_w = fram_w - button_panel.panel_w;
			this.panel_h = fram_h;
	}
}