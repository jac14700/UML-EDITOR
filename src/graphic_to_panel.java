import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
public class graphic_to_panel{
	protected int x , y;
	protected int layer_order;
	graphic_to_panel()
	{
	}
	graphic_to_panel(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
}
