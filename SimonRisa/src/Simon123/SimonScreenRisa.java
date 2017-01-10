package Simon123;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import guiPractice.components.Action;
import guiPractice.components.TextLabel;
import guiPractice.components.Visible;
import guiPractice.ClickableScreen;

public class SimonScreenRisa extends ClickableScreen implements Runnable{

	private TextLabel label;
	private ButtonInterfaceRisa[] button;
	private ProgressInterfaceRisa progress;
	private ArrayList<MoveInterfaceRisa> sequence; 
	private int roundNumber;
	private boolean acceptingInput;
	private int sequenceIndex;
	private int lastSelectedButton;

	public SimonScreenRisa(int width, int height) {
		super(width, height);
		Thread app = new Thread(this);
		app.start();
	}

	@Override
	public void run(){
		label.setText("");
		nextRound();
	}
	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		addButtons();
		progress = getProgress();
		label = new TextLabel(200,100,300,40,"Let's play Simon!");
		sequence = new ArrayList<MoveInterfaceRisa>();
		lastSelectedButton = -1;
		sequence.add(randomMove());
		sequence.add(randomMove());
		roundNumber = 0;
		viewObjects.add(progress);
		viewObjects.add(label);
	}
	
	public void nextRound() {
		acceptingInput = false;
		roundNumber ++;
		progress.setRound(roundNumber);
		sequence.add(randomMove());
		progress.setSequenceSize(sequence.size());
		changeText("Simon's turn.");
		label.setText("");
		playSequence();
		changeText("Your turn.");
		label.setText("");
		acceptingInput = true;
		sequenceIndex = 0;
	}

	
	private void playSequence() {
		ButtonInterfaceRisa b = null;
		for(MoveInterfaceRisa m: sequence){
			if(b!=null)b.dim();
			b = m.getButton();
			b.highlight();
			int sleepTime=1000;
			try {
				Thread.sleep(sleepTime);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		b.dim();
	}

	private void changeText(String string) {
		try {
			label.setText(string);
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		
			e.printStackTrace();
		}
	}

	private MoveInterfaceRisa randomMove() {
		int select = (int) (Math.random()*button.length);
		while(select == lastSelectedButton){
			select = (int) (Math.random()*button.length);
		}
		lastSelectedButton = select;
		return new Move(button[select]);
	}

	private ProgressInterfaceRisa getProgress() {
		return new Progress();
	}
	
	private ButtonInterfaceRisa getAButton() {
		return new Button();
	}

	private void addButtons(){
		int numberOfButtons = 6;
		int[][] coords = {{140,150}, {220,150}, {300,150}, {140,230}, {220,230}, {300,230}};
		Color[] colors = {Color.red, Color.blue, new Color(240,160,70), new Color(20,255,140), Color.yellow, new Color(180,90,210)};
		button = new ButtonInterfaceRisa[numberOfButtons];
		for(int i = 0; i < numberOfButtons; i++ ){			
			button[i] = getAButton();
			button[i].setColor(colors[i]);
			button[i].setX(coords[i][0]);
			button[i].setY(coords[i][1]);
			final ButtonInterfaceRisa b = button[i];
			b.dim();
			b.setAction(new Action() {
				public void act() {
					if(acceptingInput){
					Thread blink = new Thread(new Runnable() {
						public void run() {
							b.highlight();
							try {
								Thread.sleep(1000);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
							b.dim();
						}
					});
					blink.start();
						if(b==sequence.get(sequenceIndex).getButton()){
							sequenceIndex++;
						}else{
							progress.gameOver();
							return;
						}
					}
					if(sequence.size()==sequenceIndex){
						Thread nextRound = new Thread(SimonScreenRisa.this);
						nextRound.start();
					}
				}
			});
			viewObjects.add(b);
		}
	}
}
