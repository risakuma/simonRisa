package simon;

public class Move implements MoveInterfaceRisa {

	public ButtonInterfaceRisa button;
	public Move(ButtonInterfaceRisa button){
		this.button = button;
	}
	@Override
	public ButtonInterfaceRisa getButton() {
		
		return button;
	}

}
