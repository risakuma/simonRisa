package simon;

import guiPractice.GUIApplication;

public class SimonGameRisa extends GUIApplication {

	public SimonGameRisa() {
		// TODO Auto-generated constructor stub
	}

	protected void initScreen() {
		SimonScreenRisa simon = new SimonScreenRisa(getWidth(), getHeight());
		setScreen(simon);
	}

	public static void main(String[] args) {
		SimonGameRisa game = new SimonGameRisa();
		Thread app = new Thread(game);
		app.start();
	}

}
