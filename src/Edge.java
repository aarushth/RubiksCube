import RubiksCube.Point;
public class Edge extends Piece{

	public Edge(Face face0, Face face1, Face face2, Point p) {
		super(face0, face1, face2, p);
	}
	@Override
	public boolean isEdge() {
		return true;
	}
}