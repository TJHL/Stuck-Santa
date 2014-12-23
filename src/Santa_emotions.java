//Copyright Wintriss Technical Schools 2013
import java.applet.AudioClip;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Robot;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Santa_emotions extends JPanel implements Runnable,
		MouseMotionListener {

	BufferedImage maze;
	final int frameWidth = 600;
	final int frameHeight = 400;

	Santa_emotions() throws Exception {

		maze = ImageIO.read(getClass().getResource("santa6.png"));

		addMouseMotionListener(this);

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		int mouseX = e.getX();
		int mouseY = e.getY();
		int mouseColor = maze.getRGB(mouseX, mouseY);

		System.out.println(mouseColor);

		int Red = -65536;
		int White = -1;

		if (mouseColor == Red) {
			JOptionPane.showMessageDialog(null, "HO, HO, HO!");
		}
		if (mouseColor == White) {
			JOptionPane.showMessageDialog(null,
					"What the- MY BEARD IS STUCK IN THE CHIMINY!!!!!!");
			AudioClip sound = JApplet.newAudioClip(getClass().getResource(
					"Stuck Santa.aif"));

			sound.play();
		}

	}

	private void scare() {
		System.out.println("BOO!");

	}

	private void showScaryImage(String imageName) {
		try {
			maze = ImageIO.read(getClass().getResource(imageName));
		} catch (Exception e) {
			System.err.println("Couldn't find this image: " + imageName);
		}
		repaint();
	}

	public static void main(String[] args) throws Exception {
		SwingUtilities.invokeLater(new Santa_emotions());
	}

	@Override
	public void run() {
		JFrame frame = new JFrame("Emotional santa");
		frame.add(this);
		setPreferredSize(new Dimension(frameWidth, frameHeight));
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setVisible(true);
	}

	@Override
	public void paintComponent(Graphics g) {
		g.drawImage(maze, 0, 0, null);
	}

	@Override
	public void mouseDragged(MouseEvent e) {

	}

}
