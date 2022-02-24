import RubiksCube.*;

public class Face {

	private Color color;
	private Orientation orientation;

	
	public Face(Color c, Orientation o)
	{
		color = c;
		orientation = o;
	}
	
	public Orientation getOrientation() {
		return orientation;
	}
	public Color getColor() {
		return color;
	}
	
	public void setOrientation(Orientation o) {
		orientation = o;
	}

}