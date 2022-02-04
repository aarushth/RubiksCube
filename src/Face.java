import RubiksCube.*;

public class Face {

	private Color c;
	private Orientation o;
	
	public Face(Color color, Orientation orientation)
	{
		c = color;
		o = orientation;
	}
	
	public Orientation getOrientation() {
		return o;
	}
	public Color getColor() {
		return c;
	}
}
