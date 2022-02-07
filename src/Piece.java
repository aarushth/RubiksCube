import java.util.ArrayList;
import java.util.HashMap;
import RubiksCube.*;
public class Piece {
	
	private HashMap<Orientation, Face> faceByOrientation = new HashMap<>();
	private HashMap<Color, Face> faceByColor = new HashMap<>();
	private ArrayList<Face> faces = new ArrayList<Face>();
	/*
	private static HashMap<Orientation, HashMap<Orientation,Orientation>> transforms;
	static
	{
		HashMap<Orientation, HashMap<Orientation, Orientation>> temp = new HashMap<Orientation, HashMap<Orientation, Orientation>>();
		
		HashMap<Orientation, Orientation> xpTransform = new HashMap<Orientation, Orientation>();
		xpTransform.put(Orientation.PositiveX, Orientation.PositiveX);
		xpTransform.put(Orientation.NegativeX, Orientation.NegativeX);
		
		xpTransform.put(Orientation.PositiveZ, Orientation.PositiveY);
		xpTransform.put(Orientation.PositiveY, Orientation.NegativeZ);
		xpTransform.put(Orientation.NegativeZ, Orientation.NegativeY);
		xpTransform.put(Orientation.NegativeY, Orientation.PositiveZ);
		temp.put(Orientation.PositiveX, xpTransform);
		
		HashMap<Orientation, Orientation> ypTransform = new HashMap<Orientation, Orientation>();
		ypTransform.put(Orientation.PositiveY, Orientation.PositiveY);
		ypTransform.put(Orientation.NegativeY, Orientation.NegativeY);
		
		ypTransform.put(Orientation.PositiveZ, Orientation.NegativeX);
		ypTransform.put(Orientation.NegativeX, Orientation.NegativeZ);
		ypTransform.put(Orientation.NegativeZ, Orientation.PositiveX);
		ypTransform.put(Orientation.PositiveX, Orientation.PositiveZ);
		temp.put(Orientation.PositiveY, ypTransform);
		
		HashMap<Orientation, Orientation> zpTransform = new HashMap<Orientation, Orientation>();
		zpTransform.put(Orientation.PositiveZ, Orientation.PositiveZ);
		zpTransform.put(Orientation.NegativeZ, Orientation.NegativeZ);
		
		zpTransform.put(Orientation.PositiveY, Orientation.PositiveX);
		zpTransform.put(Orientation.PositiveX, Orientation.NegativeY);
		zpTransform.put(Orientation.NegativeY, Orientation.NegativeX);
		zpTransform.put(Orientation.NegativeX, Orientation.PositiveY);
		temp.put(Orientation.PositiveZ, zpTransform);
		
		HashMap<Orientation, Orientation> xnTransform = new HashMap<Orientation, Orientation>();
		xnTransform.put(Orientation.NegativeX, Orientation.NegativeX);
		xnTransform.put(Orientation.PositiveX, Orientation.PositiveX);
		
		xnTransform.put(Orientation.PositiveZ, Orientation.NegativeY);
		xnTransform.put(Orientation.NegativeY, Orientation.NegativeZ);
		xnTransform.put(Orientation.NegativeZ, Orientation.PositiveY);
		xnTransform.put(Orientation.PositiveY, Orientation.PositiveZ);
		temp.put(Orientation.NegativeX, xnTransform);
		
		HashMap<Orientation, Orientation> ynTransform = new HashMap<Orientation, Orientation>();
		ynTransform.put(Orientation.NegativeY, Orientation.NegativeY);
		ynTransform.put(Orientation.PositiveY, Orientation.PositiveY);
		
		ynTransform.put(Orientation.PositiveZ, Orientation.PositiveX);
		ynTransform.put(Orientation.PositiveX, Orientation.NegativeZ);
		ynTransform.put(Orientation.NegativeZ, Orientation.NegativeX);
		ynTransform.put(Orientation.NegativeX, Orientation.PositiveZ);
		temp.put(Orientation.NegativeY, ynTransform);
		
		HashMap<Orientation, Orientation> znTransform = new HashMap<Orientation, Orientation>();
		zpTransform.put(Orientation.NegativeZ, Orientation.NegativeZ);
		zpTransform.put(Orientation.PositiveZ, Orientation.PositiveZ);
		
		zpTransform.put(Orientation.PositiveY, Orientation.NegativeX);
		zpTransform.put(Orientation.NegativeX, Orientation.NegativeY);
		zpTransform.put(Orientation.NegativeY, Orientation.PositiveX);
		zpTransform.put(Orientation.PositiveX, Orientation.PositiveY);
		temp.put(Orientation.NegativeZ, znTransform);
		
		transforms = temp;
	}
	*/
	private static HashMap<Vector, Orientation> orientationVectors = new HashMap<Vector, Orientation>();
	static {
		orientationVectors.put(new Vector(1, 0, 0), Orientation.PositiveX);
		orientationVectors.put(new Vector(0, 1, 0), Orientation.PositiveY);
		orientationVectors.put(new Vector(0, 0, 1), Orientation.PositiveZ);
		orientationVectors.put(new Vector(-1, 0, 0), Orientation.NegativeX);
		orientationVectors.put(new Vector(0, -1, 0), Orientation.NegativeY);
		orientationVectors.put(new Vector(0, 0, -1), Orientation.NegativeZ);
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
