package Simon123;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.RenderingHints;

import guiPractice.components.Action;
import guiPractice.components.Component;

public class Button extends Component implements ButtonInterfaceRisa {

	private static final int WIDTH = 70;
	private static final int HEIGHT = 70;
	private Action action;
	private Color c;
	private Color displayColor;
	private boolean highlight;
	
	public Button() {
		super(0,0,WIDTH,HEIGHT);
	}

	public boolean isHovered(int x, int y) {
		if(x>getX()&&x<(getX()+getWidth())&&y>getY()&&y<(getY()+getHeight()))return true;
		else return false;
	}

	public void act() {
		action.act();
	}
	
	public void setColor(Color color) {
		this.c = color;
		displayColor = c;
		update();
	}

	public void highlight() {
		if(c != null) displayColor = c;
		highlight = true;
		update();
	}

	public void dim() {
		displayColor = Color.gray;
		highlight = false;
		update();
	}

	public void setAction(Action action) {
		this.action = action;
	}

	@Override
	public void update(Graphics2D g) {
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		if(displayColor != null) g.setColor(displayColor);
		else g.setColor(Color.gray);
		g.fillOval(0, 0, WIDTH, HEIGHT);
		g.setColor(Color.black);
		g.drawOval(0, 0, WIDTH-1, HEIGHT-1);
		if(highlight){

		}
		
	}

	
	private String name;
	public void setName(String s){
		this.name = s;
	}
	
	public String toString(){
		return name;
	}


	public ButtonInterfaceRisa getAButton() {
		return null;
	}
	
}