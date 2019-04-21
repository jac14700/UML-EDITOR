import java.awt.*;
import javax.swing.*;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.*;
import javax.imageio.ImageIO;


public class Drawing extends JFrame {
	private static int fram_w = 1000, fram_h = 700;
	public Drawing(){
			JFrame frame = new JFrame("twing - twing doodling");
			button_panel b_panel = new button_panel(fram_h);
			canvas_panel canvas = new canvas_panel(fram_w, fram_h);
			menu_bar bar = new menu_bar();
			
			frame.pack();
			frame.setSize(fram_w, fram_h);
			frame.setLocationRelativeTo(null);
			frame.setLayout(null);

			frame.getContentPane().add(canvas, BorderLayout.CENTER);
			frame.getContentPane().add(b_panel, BorderLayout.WEST);
			frame.setJMenuBar(bar.menu_bar);
			
		    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    frame.setVisible(true);
	}
	public static void main(String[] args) {
			new Drawing(); 
	}
}