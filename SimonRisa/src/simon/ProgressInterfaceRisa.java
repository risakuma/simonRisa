package simon;

import guiPractice.components.Visible;

public interface ProgressInterfaceRisa extends Visible {
	void gameOver();
	void setRound(int r);
	void setSequenceSize(int size);
}
