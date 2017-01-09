package simon;

public class Move implements MoveInterfaceRisa {

	public ButtonInterfaceRisa button;
	public Move(ButtonInterfaceRisa button){
		this.button = button;
	}
	@Override
	public ButtonInterfaceRisa getButton() {
		// TODO Auto-generated method stub
		return button;
	}

}
