import RubiksCube.*;
public class Cube implements Cloneable{

	public Object clone()throws CloneNotSupportedException{  
		return super.clone();  
	}  
	private Piece[][][] cube = new Piece[3][3][3];
	public Piece[][][] getCube(){
		return cube;
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
						cube[i+1][j+1][k+1] = new Corner(whichXFace(i), whichYFace(j), whichZFace(k), new Point(i+1, j+1, k+1));
						break;
					case 2:
						cube[i+1][j+1][k+1] = new Edge(whichXFace(i), whichYFace(j), whichZFace(k), new Point(i+1, j+1, k+1));
						break;
					case 1:
						cube[i+1][j+1][k+1] = new Center(whichXFace(i), whichYFace(j), whichZFace(k), new Point(i+1, j+1, k+1));
						break;
					case 0:
						cube[i+1][j+1][k+1] = null;
					}
				}
			}
		}
	}
	private void pause(Frame f){
		long start = System.currentTimeMillis();
		while(start >= System.currentTimeMillis() - 10);
		f.updateFrame();
	}
	private void upPriv() {
		Piece[][][] temp = getCubeCopy();
		for(int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				cube[i][j][2].rotate(Orientation.PositiveZ);
			}
		}
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				cube[i][j][2] = temp[2-j][i][2];
				cube[i][j][2].setPos(new Point(i, j, 2));
			}
		}
	}
	public Move up(Frame f){
		upPriv();
		pause(f);
		return Move.UP;
	}
	public Move upPrime(Frame f) {
		upPriv();
		upPriv();
		upPriv();
		pause(f);
		return Move.UPPRIME;
	}
	public Move upTwo(Frame f) {
		upPriv();
		upPriv();
		pause(f);
		return Move.UPTWO;
	}
	
	private void downPriv() {
		Piece[][][] temp = getCubeCopy();
		for(int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				cube[i][j][0].rotate(Orientation.NegativeZ);
			}
		}
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				cube[i][j][0] = temp[j][2-i][0];
				cube[i][j][2].setPos(new Point(i, j, 0));
			}
		}
	}
	public Move down(Frame f){
		downPriv();
		pause(f);
		return Move.DOWN;
	}
	public Move downPrime(Frame f) {
		downPriv();
		downPriv();
		downPriv();
		pause(f);
		return Move.DOWNPRIME;
	}
	public Move downTwo(Frame f) {
		downPriv();
		downPriv();
		pause(f);
		return Move.DOWNTWO;
	}
	
	private void rightPriv() {
		Piece[][][] temp = getCubeCopy();
		for(int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				cube[2][i][j].rotate(Orientation.PositiveX);
			}
		}
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				cube[2][i][j] = temp[2][2-j][i];
				cube[2][i][j].setPos(new Point(2, i, j));
			}
		}
	}
	public Move right(Frame f){
		rightPriv();
		pause(f);
		return Move.RIGHT;
	}
	public Move rightPrime(Frame f) {
		rightPriv();
		rightPriv();
		rightPriv();
		pause(f);
		return Move.RIGHTPRIME;
	}
	public Move rightTwo(Frame f) {
		rightPriv();
		rightPriv();
		pause(f);
		return Move.RIGHTTWO;
	}
	
	private void leftPriv() {

		Piece[][][] temp = getCubeCopy();
		for(int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				cube[0][i][j].rotate(Orientation.NegativeX);
			}
		}
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				cube[0][i][j] = temp[0][j][2-i];
				cube[0][i][j].setPos(new Point(0, i, j));
			}
		}
	}
	public Move left(Frame f){
		leftPriv();
		pause(f);
		return Move.LEFT;
	}
	public Move leftPrime(Frame f) {
		leftPriv();
		leftPriv();
		leftPriv();
		pause(f);
		return Move.LEFTPRIME;
	}
	public Move leftTwo(Frame f) {
		leftPriv();
		leftPriv();
		pause(f);
		return Move.LEFTTWO;
	}

	private void backPriv() {
		Piece[][][] temp = getCubeCopy();
		for(int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				cube[i][2][j].rotate(Orientation.PositiveY);
			}
		}
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				cube[i][2][j] = temp[j][2][2-i];
				cube[i][2][j].setPos(new Point(i, 2, j));
			}
		}
	}
	public Move back(Frame f){
		backPriv();
		pause(f);
		return Move.BACK;
	}
	public Move backPrime(Frame f) {
		backPriv();
		backPriv();
		backPriv();
		pause(f);
		return Move.BACKPRIME;
	}
	public Move backTwo(Frame f) {
		backPriv();
		backPriv();
		pause(f);
		return Move.BACKTWO;
	}
	
	private void frontPriv() {
		Piece[][][] temp = getCubeCopy();
		for(int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				cube[i][0][j].rotate(Orientation.NegativeY);
			}
		}
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				cube[i][0][j] = temp[2-j][0][i];
				cube[i][0][j].setPos(new Point(i, 0, j));
			}
		}
	}
	public Move front(Frame f){
		frontPriv();
		pause(f);
		return Move.FRONT;
	}
	public Move frontPrime(Frame f) {
		frontPriv();
		frontPriv();
		frontPriv();
		pause(f);
		return Move.FRONTPRIME;
	}
	public Move frontTwo(Frame f) {
		frontPriv();
		frontPriv();
		pause(f);
		return Move.FRONTTWO;
	}
	
	
	public Move turnAroundOrientation(Orientation o, Frame f) {
		switch(o) {
		case PositiveX:
			return right(f);
		case NegativeX:
			return left(f);
		case PositiveY:
			return back(f);
		case NegativeY:
			return front(f);
		case PositiveZ:
			return up(f);
		case NegativeZ:
			return down(f);
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
	public boolean bottomCornersSolved(){
		for(int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if(cube[i][j][0].isCorner()) {
					if(!cube[i][j][0].isSolved()) {
						return false;
					}
				} 
			}
		}
		return true;
	}
	public Corner getBottomCornerPiece(){
		for(int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				for(int k = 0; k < 3; k++) {
					if(cube[i][j][k] != null) {
						if(cube[i][j][k].isCorner() && cube[i][j][k].hasFace(Color.YELLOW) && !(cube[i][j][k].isSolved())) {
							return (Corner) cube[i][j][k];
						} 
					}
				}
			}
		}
		return null;
	}
	public boolean secondLayerSolved(){
		for(int i = 0; i < 3; i++ ){
			for(int j = 0; j < 3; j++){
				if(cube[i][j][1] != null && !cube[i][j][1].isSolved()){
					return false;
				}
			}
		}
		return true;
	}
	public Edge getSecondLayerPiece(){
		for(int i = 0; i < 3; i++ ){
			for(int j = 0; j < 3; j++){
				for(int k = 1; k < 3; k++){
					if(cube[i][j][k] != null && cube[i][j][k].isEdge() && !cube[i][j][k].isSolved() && !cube[i][j][k].hasFace(Color.WHITE)){
						return (Edge) cube[i][j][k];
					}
				}
			}
		}
		return null;
	}
	public boolean topCrossSolved(){
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				if(cube[i][j][2].isEdge() && !cube[i][j][2].isColorFacingDirection(Color.WHITE, Orientation.PositiveZ)){
					return false;
				}
			}
		}
		return true;
	}
	public boolean noTopCross(){
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				if(cube[i][j][2].isEdge() && cube[i][j][2].isColorFacingDirection(Color.WHITE, Orientation.PositiveZ)){
					return false;
				}
			}
		}
		return true;
	}
	public boolean barTopCross(){
		if((cube[1][0][2].isColorFacingDirection(Color.WHITE, Orientation.PositiveZ) && cube[1][2][2].isColorFacingDirection(Color.WHITE, Orientation.PositiveZ))||(cube[0][1][2].isColorFacingDirection(Color.WHITE, Orientation.PositiveZ) && cube[2][1][2].isColorFacingDirection(Color.WHITE, Orientation.PositiveZ))){
			return true;
		}
		return false;
	}
	public boolean barTopCrossAligned(){
		if(cube[0][1][2].isColorFacingDirection(Color.WHITE, Orientation.PositiveZ) && cube[2][1][2].isColorFacingDirection(Color.WHITE, Orientation.PositiveZ)){
			return true;
		}
		return false;
	}
	public boolean OLLcomplete(){
		for(int i = 0; i < 3; i+=2){
			for(int j = 0; j < 3; j+=2){
				if(!cube[i][j][2].isColorFacingDirection(Color.WHITE, Orientation.PositiveZ)){
					return false;
				}
			}
		}
		return true;
	}
	public int OLLCorners(){
		int ans = 0;
		for(int i = 0; i < 3; i+=2){
			for(int j = 0; j < 3; j+=2){
				if(cube[i][j][2].isColorFacingDirection(Color.WHITE, Orientation.PositiveZ)){
					ans++;
				}
			}
		}
		return ans;
	}
	public Piece getPiece(int x, int y, int z){
		return cube[x][y][z];
	}
	public boolean topCornersSolved(){
		for(int i = 0; i < 3; i+=2) {
			for(int j = 0; j < 3; j+=2) {
				if(!cube[i][j][2].isSolved()) {
					return false;
				}
			}
		}
		return true;
	}
}
