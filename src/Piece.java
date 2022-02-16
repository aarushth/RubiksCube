import java.util.ArrayList;
import java.util.HashMap;
import RubiksCube.*;
public class Piece {
	
	private HashMap<Orientation, Face> faceByOrientation = new HashMap<>();
	private HashMap<Color, Face> faceByColor = new HashMap<>();
	private ArrayList<Face> faces = new ArrayList<Face>();

	private static HashMap<Vector, Orientation> orientationVectors = new HashMap<Vector, Orientation>();
	static {
		orientationVectors.put(new Vector(1, 0, 0), Orientation.PositiveX);
		orientationVectors.put(new Vector(0, 1, 0), Orientation.PositiveY);
		orientationVectors.put(new Vector(0, 0, 1), Orientation.PositiveZ);
		orientationVectors.put(new Vector(-1, 0, 0), Orientation.NegativeX);
		orientationVectors.put(new Vector(0, -1, 0), Orientation.NegativeY);
		orientationVectors.put(new Vector(0, 0, -1), Orientation.NegativeZ);
	}
	public boolean isEdge() {
		return false;
	}
	public Piece(Face face0, Face face1, Face face2) {

		if(face0 != null) {
			faceByOrientation.put(face0.getOrientation(), face0);
			faceByColor.put(face0.getColor(), face0);
			faces.add(face0);
		}
		if(face1 != null) {
			faceByOrientation.put(face1.getOrientation(), face1);
			faceByColor.put(face1.getColor(),face1);
			faces.add(face1);
		}
		if(face2 != null) {
			faceByOrientation.put(face2.getOrientation(), face2);
			faceByColor.put(face2.getColor(),face2);
			faces.add(face2);
		}
	}

	public Color getColorOfFace(Orientation o) {
		if(faceByOrientation.containsKey(o)) {
			return faceByOrientation.get(o).getColor();
		}
		return null;
	}
	public Orientation getOrientationOfColor(Color c) {
		for (int i = 0; i < faces.size(); i++) {
			if(faces.get(i).getColor() == c){
				return faces.get(i).getOrientation();
			}
		}
		return null;
	}
	public boolean isSolved() {
		for (int i = 0; i < faces.size(); i++) {
			if(faces.get(i).getColor() != faces.get(i).getOrientation().getColor()) {
				return false;
			}
		}
		return true;
	}
	public boolean hasFace(Color c) {
		for (int i = 0; i < faces.size(); i++) {
			if(faces.get(i).getColor() == c) {
				return true;
			}
		}
		return false;
	}
	public boolean isColorFacingDirection(Color c, Orientation o) {
		if(!hasFace(c)) {
			return false;
		}
		for (int i = 0; i < faces.size(); i++) {
			if(faces.get(i).getColor() == c && faces.get(i).getOrientation() == o) {
				return true;
			}
		}
		return false;
	}
	public Color getNotThisColor(Color c) {
		for (int i = 0; i < faces.size(); i++) {
			if(faces.get(i).getColor() != c) {
				return faces.get(i).getColor();
			}
		}
		return null;
	}
	public void rotate(Orientation o) {
		faceByOrientation.clear();
		for (int i = 0; i < faces.size(); i++) {
			Face f = faces.get(i);
			if(f.getOrientation().getValue() != o.getValue()) {
				Vector v = f.getOrientation().getVector().crossProduct(o.getVector());
				f.setOrientation(orientationVectors.get(v));
				faceByOrientation.put(f.getOrientation(), f);
			}else {
				faceByOrientation.put(f.getOrientation(), f);
			}
			faces.set(i, f);
		}
	}
}
