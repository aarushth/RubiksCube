import java.util.ArrayList;

import RubiksCube.Move;

public class MoveParser {
	public static Move[] allMoves = new Move[18];
	static{
		allMoves[0] = Move.UP;
		allMoves[1] = Move.UPPRIME;
		allMoves[2] = Move.UPTWO;
		allMoves[3] = Move.DOWN;
		allMoves[4] = Move.DOWNPRIME;
		allMoves[5] = Move.DOWNTWO;
		allMoves[6] = Move.LEFT;
		allMoves[7] = Move.LEFTPRIME;
		allMoves[8] = Move.LEFTTWO;
		allMoves[9] = Move.RIGHT;
		allMoves[10] = Move.RIGHTPRIME;
		allMoves[11] = Move.RIGHTTWO;
		allMoves[12] = Move.BACK;
		allMoves[13] = Move.BACKPRIME;
		allMoves[14] = Move.BACKTWO;
		allMoves[15] = Move.FRONT;
		allMoves[16] = Move.FRONTPRIME;
		allMoves[17] = Move.FRONTTWO;
	}
	private Move getMove(char c, int v){
		for(int i = 0; i < allMoves.length; i++){
			if(allMoves[i].getType() == c && allMoves[i].getValue() == v){
				return allMoves[i];
			}
		}
		return Move.UP;
	}


	public ArrayList<Move> stringToMove(String s) {

		for(int i = 0; i < s.length(); i++) {
			if(!(s.charAt(i) == 'F' || s.charAt(i) == 'R' || s.charAt(i) == 'U' || s.charAt(i) == 'L' || s.charAt(i) == 'B' || s.charAt(i) == 'D' || s.charAt(i) == ' ' || s.charAt(i) == '\'' || s.charAt(i) == '2')) {
				return null;
			}
		}
		ArrayList<Move> moves = new ArrayList<Move>();
		for(int i = 0; i < s.length(); i++) {
			switch(s.charAt(i)) {
				case 'F':
					if(s.length()-1 == i) {
						moves.add(Move.FRONT);
						break;
					}else if(s.charAt(i+1) == '2'){
						moves.add(Move.FRONTTWO);
						break;
					}else if(s.charAt(i+1) == '\''){
						moves.add(Move.FRONTPRIME);
						break;
					}else{
						moves.add(Move.FRONT);
						break;
					}
				case 'R':
					if(s.length()-1 == i) {
						moves.add(Move.RIGHT);
						break;
					}else if(s.charAt(i+1) == '2'){
						moves.add(Move.RIGHTTWO);
						break;
					}else if(s.charAt(i+1) == '\''){
						moves.add(Move.RIGHTPRIME);
						break;
					}else{
						moves.add(Move.RIGHT);
						break;
					}
				case 'U':
					if(s.length()-1 == i) {
						moves.add(Move.UP);
						break;
					}else if(s.charAt(i+1) == '2'){
						moves.add(Move.UPTWO);
						break;
					}else if(s.charAt(i+1) == '\''){
						moves.add(Move.UPPRIME);
						break;
					}else{
						moves.add(Move.UP);
						break;
					}
				case 'L':
					if(s.length()-1 == i) {
						moves.add(Move.LEFT);
						break;
					}else if(s.charAt(i+1) == '2'){
						moves.add(Move.LEFTTWO);
						break;
					}else if(s.charAt(i+1) == '\''){
						moves.add(Move.LEFTPRIME);
						break;
					}else{
						moves.add(Move.LEFT);
						break;
					}
				case 'B':
					if(s.length()-1 == i) {
						moves.add(Move.BACK);
						break;
					}else if(s.charAt(i+1) == '2'){
						moves.add(Move.BACKTWO);
						break;
					}else if(s.charAt(i+1) == '\''){
						moves.add(Move.BACKPRIME);
						break;
					}else{
						moves.add(Move.BACK);
						break;
					}
				case 'D':
					if(s.length()-1 == i) {
						moves.add(Move.DOWN);
						break;
					}else if(s.charAt(i+1) == '2'){
						moves.add(Move.DOWNTWO);
						break;
					}else if(s.charAt(i+1) == '\''){
						moves.add(Move.DOWNPRIME);
						break;
					}else{
						moves.add(Move.DOWN);
						break;
					}
			}
		}
		return moves;
	}

	public void parse(ArrayList<Move> moves, Cube c, Frame f){

		for(int i = 0; i < moves.size(); i++){
			switch(moves.get(i)){
				case UP:
					c.up(f);
					break;
				case UPPRIME:
					c.upPrime(f);
					break;
				case UPTWO:
					c.upTwo(f);
					break;
				
				case DOWN:
					c.down(f);
					break;
				case DOWNPRIME:
					c.downPrime(f);
					break;
				case DOWNTWO:
					c.downTwo(f);
					break;
				
				case LEFT:
					c.left(f);
					break;
				case LEFTPRIME:
					c.leftPrime(f);
					break;
				case LEFTTWO:
					c.leftTwo(f);
					break;
				
				case RIGHT:
					c.right(f);
					break;
				case RIGHTPRIME:
					c.rightPrime(f);
					break;
				case RIGHTTWO:
					c.rightTwo(f);
					break;
					
				case BACK:
					c.back(f);
					break;
				case BACKPRIME:
					c.backPrime(f);
					break;
				case BACKTWO:
					c.backTwo(f);
					break;
					
				case FRONT:
					c.front(f);
					break;
				case FRONTPRIME:
					c.frontPrime(f);
					break;
				case FRONTTWO:
					c.frontTwo(f);
					break;
			}
		}
	}

	public String moveToString(ArrayList<Move> moves){
		StringBuffer string = new StringBuffer("");
		for(int i = 0; i < moves.size(); i++){
			string.append(moves.get(i).getType());
			switch(moves.get(i).getValue()){
				case 1:
					string.append(" ");
					break;
				case 2:
					string.append("2 ");
					break;
				case 3:
					string.append("' ");
			}
		} 
		return string.toString();
	}

}