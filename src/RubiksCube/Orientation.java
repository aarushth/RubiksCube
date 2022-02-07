package RubiksCube;


public enum Orientation {
	
	PositiveX(0, new Vector(1, 0, 0)),
	PositiveY(1, new Vector(0, 1, 0)),
	PositiveZ(2, new Vector(0, 0, 1)),
	NegativeX(0, new Vector(-1, 0, 0)),
	NegativeY(1, new Vector(0, -1, 0)),
	NegativeZ(2, new Vector(0, 0, -1)),;
	private int value;
	private Vector vector;
	Orientation(int i, Vector v) {
		value = i;
		vector = v;
	} 

	public int getValue() {
		return value;
	}
	public Vector getVector() {
		return vector;
	}
}
