import java.awt.Color;
import java.awt.Graphics;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JPanel;


public class AntPanel extends JPanel{
	private Square[][] plane;
	private final int screenSize = 1000;
	private FileWriter wr;
	private int numBlack = 0;
	private int trial = 0;
	private Ant ant;
	public AntPanel() {
		try {
			wr = new FileWriter("file.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
		plane = new Square[100][100];
		setLayout(null);
		for (int i = 0; i < plane.length; i++) {
			for (int j = 0; j < plane[i].length; j++) {
				plane[i][j] = new Square(i*10, j*10);
				plane[i][j].setVisible(true);
				plane[i][j].setLayout(null);
				plane[i][j].setBounds(i*10,j*10,10,10);
				add(plane[i][j]);
			}
		}
		ant = new Ant(0, 50, 50);
	}
	class Ant {
		private int orientation;
		private int x;
		private int y;
		public Ant (int o, int x, int y) {
			this.x = x;
			this.y = y;
			this.orientation = o;
		}
	}
	class Square extends JPanel{
		private int black;
		private int x;
		private int y;
		
		public Square(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		public Color getColor() {
			if (black == 1) {
				return Color.red;
			}
			return Color.blue;
		}
		
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			setBackground(getColor());
		}
	}

	public void move () {
		if (plane[ant.x][ant.y].getColor() == Color.blue) {
			ant.orientation++;
			plane[ant.x][ant.y].black = 1;
		} else {
			plane[ant.x][ant.y].black = 0;
			ant.orientation--;
		}
		
		
		plane[ant.x][ant.y].repaint();
		
		int o = ant.orientation % 4;
		if (o == 0) {
			ant.x++;
		} else if (o == 1) {
			ant.y++;
		} else if (o == 2) {
			ant.x--;
		} else {
			ant.y--;
		}
		trial++;
	
		System.out.println(trial);
	}
}
