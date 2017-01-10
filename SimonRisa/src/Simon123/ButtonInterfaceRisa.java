package Simon123;

import java.awt.Color;

import guiPractice.components.Action;
import guiPractice.components.Clickable;

public interface ButtonInterfaceRisa extends Clickable {
	void setColor(Color color);
	void setX(int x);
	void setY(int y);
	void setAction(Action action);
	void dim();
	void highlight();
}
