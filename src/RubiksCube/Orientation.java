package RubiksCube;

public enum Orientation {
	
	PositiveX(0),
	PositiveY(1),
	PositiveZ(2),
	NegativeX(3),
	NegativeY(4),
	NegativeZ(5),;
	private int value;
	Orientation(int i) {
		value = i;
	} 
	
	public int getValue() {
		return value;
	}
}
