import java.util.ArrayList;
import java.util.HashMap;
import RubiksCube.*;
public class Piece {
	
	private HashMap<Orientation, Face> faceByOrientation = new HashMap<>();
	private HashMap<Color, Face> faceByColor = new HashMap<>();
	private Orientation[] orientations = new Orientation[6];
	
	public Piece(Face face0, Face face1, Face face2) {
		orientations[0] = Orientation.PositiveX;
		orientations[1] = Orientation.PositiveY;
		orientations[2] = Orientation.PositiveZ;
		orientations[3] = Orientation.NegativeX;
		orientations[4] = Orientation.NegativeY;
		orientations[5] = Orientation.NegativeZ;
		
		if(face0 != null) {
			faceByOrientation.put(face0.getOrientation(), face0);
			faceByColor.put(face0.getColor(),face1);
		}
		if(face1 != null) {
			faceByOrientation.put(face1.getOrientation(), face0);
			faceByColor.put(face1.getColor(),face1);
		}
		if(face2 != null) {
			faceByOrientation.put(face2.getOrientation(), face2);
			faceByColor.put(face2.getColor(),face2);
		}
	}

	public Color getColorOfFace(Orientation o) {
		if(faceByOrientation.containsKey(o)) {
			return faceByOrientation.get(o).getColor();
		}
		return null;
	}
	
	public void rotate(Orientation o) {
		ArrayList<Face> temp = new ArrayList<Face>();
		for (int i = 0; i < 6; i++) {
			if(orientations[i].getValue() % 3 != o.getValue() % 3 && faceByOrientation.getOrDefault(orientations[i], null) != null) {
				temp.add(faceByOrientation.get(orientations[i]));
			}
		}
	}
}
