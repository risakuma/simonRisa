package simon;

import java.awt.Color;

import guiPractice.components.Action;
import guiPractice.components.Clickable;

public interface ButtonInterfaceRisa extends Clickable {
	public void setColor(Color color);
	public void setX(int x);
	public void setY(int y);
	public void setAction(Action a);
	public void highlight();
	public void dim();
}
