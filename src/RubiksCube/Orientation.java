package RubiksCube;


public enum Orientation {
	
	PositiveX(0, new Vector(1, 0, 0), Color.RED),
	PositiveY(1, new Vector(0, 1, 0), Color.BLUE),
	PositiveZ(2, new Vector(0, 0, 1), Color.WHITE),
	NegativeX(0, new Vector(-1, 0, 0), Color.ORANGE),
	NegativeY(1, new Vector(0, -1, 0), Color.GREEN),
	NegativeZ(2, new Vector(0, 0, -1), Color.YELLOW),;
	private int value;
	private Vector vector;
	private Color color;
	Orientation(int i, Vector v, Color c) {
		value = i;
		vector = v;
		color = c;
	} 

	public int getValue() {
		return value;
	}
	public Vector getVector() {
		return vector;
	}
	public Color getColor() {
		return color;
	}
}
