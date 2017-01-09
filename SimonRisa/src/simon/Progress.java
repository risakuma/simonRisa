package simon;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import guiPractice.components.Component;

public class Progress extends Component implements ProgressInterfaceRisa {
	private boolean gameOver;
	private String round;
	private String seq;
	private int width;
	private int height;
	public Progress(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void gameOver() {
		gameOver = true;
		update();

	}

	@Override
	public void setRound(int r) {
		round = "This is round "+ r;
		update();

	}

	@Override
	public void setSequenceSize(int size) {
		seq = "Sequence "+ size;
		update();

	}
//s
	@Override
	public void update(Graphics2D g) {
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		g.setColor(Color.white);
		g.fillRect(0, 0, getWidth(), getHeight());
		g.setColor(Color.black);
		String status = "";
		if(gameOver){
			status = "Game Over";
			g.drawString(status, 40, 40);
			
		}
		if(!gameOver){
			
			g.drawString(round, 40, 40);
			g.drawString(seq, 40, 80);
			
		}

	}

}
