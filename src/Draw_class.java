import java.awt.*;

public class Draw_class extends Graphic_to_c_panel{
	protected void draw() {};
    protected void moveTo(int newX, int newY){};
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(new Color(255, 212, 212));
        g2d.drawRect(10, 15, 90, 60);


        g2d.setColor(new Color(255, 21, 1));
        g2d.fillRect(250, 195, 90, 60);

      }

}