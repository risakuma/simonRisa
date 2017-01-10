package Simon123;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import guiPractice.components.Component;

public class Progress extends Component implements ProgressInterfaceRisa {

	private static final int WIDTH = 120;
	private static final int HEIGHT = 50;

	private boolean gameOver;
	private String round;
	private String sequence;

	public Progress() {
		super(200,60,WIDTH,HEIGHT);
	}



	public void setRound(int roundNumber) {
		round = "Round "+roundNumber;
		update();
	}

	public void setSequenceSize(int size) {
		sequence = "Sequence length "+size;
		update();
	}

	public void gameOver() {
		gameOver = true;
		update();
	}



	@Override
	public void update(Graphics2D g) {
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		FontMetrics fm = g.getFontMetrics();
		g.setColor(Color.gray);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		g.setColor(Color.white);
		String status;
		g.drawRect(0, 0, WIDTH-1, HEIGHT-1);
		if(gameOver){
			status = "GAME OVER!";
			g.drawString(status, (WIDTH - fm.stringWidth(status))/2, 20);
			g.drawString(sequence, (WIDTH - fm.stringWidth(sequence))/2, 40);

		}else{
		
			if(round !=null && sequence != null){
				g.drawString(round, (WIDTH - fm.stringWidth(round))/2, 20);
				g.drawString(sequence, (WIDTH - fm.stringWidth(sequence))/2, 40);
			}
		}
	}

}