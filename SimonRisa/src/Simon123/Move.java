package Simon123;
public class Move implements MoveInterfaceRisa {

private ButtonInterfaceRisa b; 
	
	public Move(ButtonInterfaceRisa b) {
		this.b = b;
	}

	public ButtonInterfaceRisa getButton() {
		return b;
	}

}