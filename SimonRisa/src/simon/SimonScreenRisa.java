package simon;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import guiPractice.components.Action;
import guiPractice.components.Button;
import guiPractice.components.TextLabel;
import guiPractice.components.Visible;
import guiPractice.components.ClickableScreen;

public class SimonScreenRisa extends ClickableScreen implements Runnable {

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
	public void run() {
		label.setText("");
	    nextRound();
	}

	private void nextRound() {
		acceptingInput = false;
		roundNumber++;
		
		sequence.add(randomMove());
		progress.setRound(roundNumber);
		progress.setSequenceSize(sequence.size());
		changeText("Simon's turn");
		label.setText("");
		
		playSequence();
		changeText("Your turn");
		acceptingInput = true;
		sequenceIndex = 0;
	}

	private void playSequence() {
		ButtonInterfaceRisa b = null;
		for(MoveInterfaceRisa seq : sequence){
			
			if(b != null)
				b.dim();
			
			b = seq.getButton();
			b.highlight();
			
			int sleepTime = ;//create equation depending on roundNumber
			
			try {
				Thread.sleep(sleepTime);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		b.dim();
	}

	private void changeText(String s){
		try{
			Thread.sleep(1000);
			label.setText(s);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		addButtons(viewObjects);
		progress = getProgress();
		label = new TextLabel(130,230,300,40,"Let's play Simon!");
		sequence = new ArrayList<MoveInterfaceRisa>();
		lastSelectedButton = -1;
		sequence.add(randomMove());
		sequence.add(randomMove());
		roundNumber = 0;
		viewObjects.add(progress);
		viewObjects.add(label);
	}

	private MoveInterfaceRisa randomMove() {
		//ButtonInterfaceRisa b;
		int indx = (int)Math.random() * button.length;
		while(indx == lastSelectedButton)
			indx = (int)Math.random() * button.length;
		
		lastSelectedButton = indx;
		
		return Move(button[indx]);
	}

	private ProgressInterfaceRisa getProgress() {
		//Placeholder until partner finishes implementation of ProgressInterface
		return null;
	}

	private void addButtons(List<Visible> viewObjects) {
		int numOfButtons = 5;
		Color[] buttonColor = {Color.red, Color.blue, Color.yellow, Color.green, Color.orange};
		
		for(int i = 0; i < numOfButtons; i++){
			final ButtonInterfaceRisa b = getAButton();
			b.setColor(buttonColor[i]);
			//circle!!
			b.setX(0);
			b.setY(0);
			
	        b.setAction(new Action(){
	            public void act(){
	            	
	            	if(acceptingInput){
	            		
	            		//to show that button was pressed
	            	    Thread pressed = new Thread(new Runnable(){
	            	        public void run(){
	            	        	b.highlight();
	            	        	try {
									Thread.sleep(800);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
	            	        	b.dim();
	            	        }
	            	    });
	            	    pressed.start();
	            	  
	            	    //check if button clicked was correct
	            	    if(b == sequence.get(sequenceIndex).getButton()){
	            	    	sequenceIndex++;
	            	    }else{
	            	    	progress.gameOver();
	            	    	return;
	            	    }
	            	    
	            	    //check if sequence is complete
	            	    if(sequenceIndex == sequence.size()){
	            	    	Thread nextRound = new Thread(SimonScreenRisa.this);
	            	    	nextRound.start(); 
	            	    }
	            	    
	            	}

	            }
	        });
	        viewObjects.add(b);
		}
	}

	private ButtonInterfaceRisa getAButton() {
		return null;
		
	}

}
