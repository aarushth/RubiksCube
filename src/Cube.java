import RubiksCube.*;
public class Cube {
	private Piece[][][] cube = new Piece[3][3][3];
	public Piece[][][] getCube(){
		return cube;
	}
	public void setCube(Piece[][][] c) {
		cube = c;
	}
	private Piece[][][] getCubeCopy(){
		Piece[][][] cubeCopy = new Piece[3][3][3];
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				for(int k = 0; k < 3; k++) {
					cubeCopy[i][j][k] = cube[i][j][k];
				}
			}
		}
		return cubeCopy;
	}
	private Face whichXFace(int i) {
		if(i < 0 ) {
			return new Face(Color.ORANGE, Orientation.NegativeX);
		}else if(i > 0) {
			return new Face(Color.RED, Orientation.PositiveX);
		}else {
			return null;
		}
	}
	private Face whichYFace(int i) {
		if(i < 0) {
			return new Face(Color.GREEN, Orientation.NegativeY);
		}else if(i > 0) {
			return new Face(Color.BLUE, Orientation.PositiveY);
		}else {
			return null;
		}
	}
	private Face whichZFace(int i) {
		if(i < 0 ) {
			return new Face(Color.YELLOW, Orientation.NegativeZ);
		}else if(i > 0) {
			return new Face(Color.WHITE, Orientation.PositiveZ);
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
	public String up() {
		Piece[][][] temp = getCubeCopy();
		for(int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				cube[i][j][2].rotate(Orientation.PositiveZ);
			}
		}
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				cube[i][j][2] = temp[2-j][i][2];
			}
		}
		return "U ";
	}
	public String down() {
		Piece[][][] temp = getCubeCopy();
		for(int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				cube[i][j][0].rotate(Orientation.NegativeZ);
			}
		}
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				cube[i][j][0] = temp[j][2-i][0];
			}
		}
		return "D ";
	}
	public String right() {
		Piece[][][] temp = getCubeCopy();
		for(int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				cube[2][i][j].rotate(Orientation.PositiveX);
			}
		}
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				cube[2][i][j] = temp[2][2-j][i];
			}
		}
		return "R ";
	}
	public String left() {
		Piece[][][] temp = getCubeCopy();
		for(int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				cube[0][i][j].rotate(Orientation.NegativeX);
			}
		}
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				cube[0][i][j] = temp[0][j][2-i];
			}
		}
		return "L ";
	}
	
	public String back() {
		Piece[][][] temp = getCubeCopy();
		for(int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				cube[i][2][j].rotate(Orientation.PositiveY);
			}
		}
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				cube[i][2][j] = temp[j][2][2-i];
			}
		}
		return "B ";
	}
	public String front() {
		Piece[][][] temp = getCubeCopy();
		for(int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				cube[i][0][j].rotate(Orientation.NegativeY);
			}
		}
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				cube[i][0][j] = temp[2-j][0][i];
			}
		}
		return "F ";
	}
	public String upPrime() {
		up();
		up();
		up();
		return "U' ";
	}
	public String downPrime() {
		down();
		down();
		down();
		return "D' ";
	}
	public String leftPrime() {
		left();
		left();
		left();
		return "L' ";
	}
	public String rightPrime() {
		right();
		right();
		right();
		return "R' ";
	}
	public String backPrime() {
		back();
		back();
		back();
		return "B' ";
	}
	public String frontPrime() {
		front();
		front();
		front();
		return "F' ";
	}
	public String upTwo() {
		up();
		up();
		return "U2 ";
	}
	public String downTwo() {
		down();
		down();
		return "D2 ";
	}
	public String leftTwo() {
		left();
		left();
		return "L2 ";
	}
	public String rightTwo() {
		right();
		right();
		return "R2 ";
	}
	public String backTwo() {
		back();
		back();
		return "B2 ";
	}
	public String frontTwo() {
		front();
		front();
		return "F2 ";
	}
	public String turnAroundOrientation(Orientation o) {
		switch(o) {
		case PositiveX:
			return right();
		case NegativeX:
			return left();
		case PositiveY:
			return back();
		case NegativeY:
			return front();
		case PositiveZ:
			return up();
		case NegativeZ:
			return down();
		}
		return null;
	}
	public boolean crossSolved() {
		for(int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if(cube[i][j][0].isEdge()) {
					if(!cube[i][j][0].isSolved()) {
						return false;
					}
				} 
			}
		}
		return true;
	}
	public Edge getCrossPiece() {
		for(int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				for(int k = 0; k < 3; k++) {
					if(cube[i][j][k] != null) {
						if(cube[i][j][k].isEdge() && cube[i][j][k].hasFace(Color.YELLOW) && !(cube[i][j][k].isSolved())) {
							return (Edge) cube[i][j][k];
						} 
					}
				}
			}
		}
		return null;
	}


}
