import RubiksCube.*;
public class Cube {
	private Piece[][][] cube = new Piece[3][3][3];
	private Face white = new Face(Color.WHITE, Orientation.PositiveZ);
	private Face yellow = new Face(Color.YELLOW, Orientation.NegativeZ);
	private Face green = new Face(Color.GREEN, Orientation.NegativeY);
	private Face blue = new Face(Color.BLUE, Orientation.PositiveY);
	private Face red = new Face(Color.RED, Orientation.PositiveX);
	private Face orange = new Face(Color.ORANGE, Orientation.NegativeX);
	
	public Piece[][][] getCube(){
		return cube;
	}
	private Face whichXFace(int i) {
		if(i < 0 ) {
			return orange;
		}else if(i > 0) {
			return red;
		}else {
			return null;
		}
	}
	private Face whichYFace(int i) {
		if(i < 0) {
			return green;
		}else if(i > 0) {
			return blue;
		}else {
			return null;
		}
	}
	private Face whichZFace(int i) {
		if(i < 0 ) {
			return yellow;
		}else if(i > 0) {
			return white;
		}else {
			return null;
		}
	}
	public Cube() {
		for (int i = -1; i < 2; i++) {
			for (int j = -1; j < 2; j++) {
				for(int k = -1; k < 2; k++) {
					switch(Math.abs(i) + Math.abs(j) + Math.abs(k)) {
					case 3:
						cube[i+1][j+1][k+1] = new Corner(whichXFace(i), whichYFace(j), whichZFace(k));
						break;
					case 2:
						cube[i+1][j+1][k+1] = new Edge(whichXFace(i), whichYFace(j), whichZFace(k));
						break;
					case 1:
						cube[i+1][j+1][k+1] = new Center(whichXFace(i), whichYFace(j), whichZFace(k));
						break;
					case 0:
						cube[i+1][j+1][k+1] = null;
					}
				}
			}
		}
	}
	public void up() {
		
	}
}
