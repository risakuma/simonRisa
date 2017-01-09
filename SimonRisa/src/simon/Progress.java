package simon;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import guiPractice.components.Component;

public class Progress extends Component implements ProgressInterfaceRisa {
	private boolean gameOver;
	public Progress(int x, int y, int w, int h) {
		super(x, y, w, h);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void gameOver() {
		gameOver = true;
		update();

	}

	@Override
	public void setRound(int r) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setSequenceSize(int size) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Graphics2D g) {
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		g.setColor(Color.white);
		g.fillRect(0, 0, getWidth(), getHeight());
		g.setColor(Color.black);
		if(gameOver){
			
		}
		if(!gameOver){
			
		}

	}

}
