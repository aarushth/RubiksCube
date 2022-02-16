package RubiksCube;

public enum Color{
	
	RED(Orientation.PositiveX), 
	ORANGE(Orientation.NegativeX), 
	YELLOW(Orientation.NegativeZ), 
	GREEN(Orientation.PositiveZ), 
	BLUE(Orientation.PositiveY), 
	WHITE(Orientation.NegativeY);
	
	private Orientation orientation;
	Color(Orientation o){
		orientation = o;
	}
	public Orientation getOrientation() {
		return orientation;
	}
}