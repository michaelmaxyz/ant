import javax.swing.Timer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Window implements ActionListener {
	private JFrame window;
	private AntPanel panel;
	public Window() {
		panel = new AntPanel();
		panel.setVisible(true);
		panel.setBounds(0, 0, 1000, 1000);
		window = new JFrame();
		window.setSize(1000, 1000);
		window.setVisible(true);
		window.add(panel);
		Timer timer = new Timer(1, this);
        timer.start();

	}
	
	public static void main(String[] args) {
		new Window();
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		panel.move();
		panel.repaint();
	}
}
