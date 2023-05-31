package interfaces;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class PantallaFondoGris extends JPanel{
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		try {
		    BufferedImage fondo = ImageIO.read(new File("./plane.jpeg"));
		    BufferedImage grayImage = new BufferedImage(fondo.getWidth(), fondo.getHeight(), BufferedImage.TYPE_BYTE_GRAY);
		    Graphics2D g2d = grayImage.createGraphics();
		    g2d.drawImage(fondo, 0, 0, null);
		    g2d.dispose();
		    
		    g.drawImage(grayImage, 0, 0, this.getWidth(), this.getHeight(), null);
		} catch (IOException e) {
		    e.printStackTrace();
		}
	}

}
