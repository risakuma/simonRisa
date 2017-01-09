package simon;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import guiPractice.components.Action;
import guiPractice.components.Component;

public class Button extends Component implements ButtonInterfaceRisa {
	private int width = 40;
	private int height = 40;
	private Action action;
	private Color colour;
	private Color hue;
	private boolean lit;
	
	public Button(int x, int y, int w, int h) {
		super(x, y, w, h);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void act() {
		action.act();

	}

	@Override
	public boolean isHovered(int x, int y) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setColor(Color color) {
		this.colour = color;

	}

	@Override
	public void setAction(Action a) {
		this.action = a;

	}

	@Override
	public void highlight() {
		if(colour!= null){
			hue = colour;
			lit = true;
		}

	}

	@Override
	public void dim() {
		colour = Color.gray;

	}

	@Override
	public void update(Graphics2D g) {
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		g.setColor(Color.white);
		g.fillRect(0, 0, getWidth(), getHeight());
		g.setColor(Color.black);
		g.drawOval( 10 , 20 , width, height); // just random numbers atm


	}

}
