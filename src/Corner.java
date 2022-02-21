import RubiksCube.Point;
public class Corner extends Piece{

	public Corner(Face face0, Face face1, Face face2, Point p) {
		super(face0, face1, face2, p);
	}
	@Override
	public boolean isCorner(){
		return true;
	}

}
