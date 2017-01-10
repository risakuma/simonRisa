package Simon123;

import guiPractice.GUIApplication;

public class SimonGameRisa extends GUIApplication {

	public SimonGameRisa(int width,int height) {
		super(width, height);
	}

	@Override
	protected void initScreen() {
		SimonScreenRisa s = new SimonScreenRisa(getWidth(), getHeight());
		setScreen(s);
	}

	public static void main(String[] args) {
		SimonGameRisa game = new SimonGameRisa(500, 1000);
		Thread app = new Thread(game);
		app.start();
	}

}
