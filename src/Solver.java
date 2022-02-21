import java.util.ArrayList;
import java.util.HashMap;

import RubiksCube.*;

public class Solver {

	private static HashMap<Color, Orientation> orientationOfColor = new HashMap<Color, Orientation>();
	static{
		orientationOfColor.put(Color.RED, Orientation.PositiveX);
		orientationOfColor.put(Color.ORANGE, Orientation.NegativeX);
		orientationOfColor.put(Color.BLUE, Orientation.PositiveY);
		orientationOfColor.put(Color.GREEN, Orientation.NegativeY);
		orientationOfColor.put(Color.WHITE, Orientation.PositiveZ);
		orientationOfColor.put(Color.YELLOW, Orientation.NegativeZ);
	}


	public ArrayList<Move> solveCube(Cube c, Frame f){
		ArrayList<Move> solution = new ArrayList<Move>();
		solution.addAll(solveCross(c, f));
		solution.addAll(solveBottomCorners(c, f));
		return solution;
	}
	
	private ArrayList<Move> specialMove(Cube c, Corner corner, Frame f){
		ArrayList <Face> tempOrientations = corner.getFaces();
		ArrayList <Face> finalOrientations = new ArrayList<Face>();
		ArrayList<Move> solution = new ArrayList<Move>();
		for(int i = 0; i < tempOrientations.size(); i++){
			if(!(tempOrientations.get(i).getOrientation() == Orientation.PositiveZ || tempOrientations.get(i).getOrientation() == Orientation.NegativeZ)){
				finalOrientations.add(tempOrientations.get(i));
			}
		}
		Orientation o1 = finalOrientations.get(0).getOrientation();
		Orientation o2 = finalOrientations.get(1).getOrientation();
		if((o1 == Orientation.PositiveX && o2 == Orientation.NegativeY) || (o1 == Orientation.NegativeY && o2 == Orientation.PositiveX)){
			solution.add(c.right(f)); 
			solution.add(c.up(f));
			solution.add(c.rightPrime(f));
			solution.add(c.upPrime(f));
		}else if((o1 == Orientation.PositiveX && o2 == Orientation.PositiveY) || (o1 == Orientation.PositiveY && o2 == Orientation.PositiveX)){
			solution.add(c.back(f)); 
			solution.add(c.up(f));
			solution.add(c.backPrime(f));
			solution.add(c.upPrime(f));
		}else if((o1 == Orientation.NegativeX && o2 == Orientation.PositiveY) || (o1 == Orientation.PositiveY && o2 == Orientation.NegativeX)){
			solution.add(c.left(f)); 
			solution.add(c.up(f));
			solution.add(c.leftPrime(f));
			solution.add(c.upPrime(f));
		}else if((o1 == Orientation.NegativeX && o2 == Orientation.NegativeY) || (o1 == Orientation.NegativeY && o2 == Orientation.NegativeX)){
			solution.add(c.front(f)); 
			solution.add(c.up(f));
			solution.add(c.frontPrime(f));
			solution.add(c.upPrime(f));
		}
		return solution;
	}
	
	private ArrayList<Move> solveCross(Cube c, Frame f) {
		ArrayList<Move> solution = new ArrayList<Move>();
		while(!c.crossSolved()) {
			Edge e = c.getCrossPiece();
			Color crossColor = Color.YELLOW;
			Color notCrossColor = e.getNotThisColor(crossColor);
			while(!e.isSolved()){
				if(!(e.isColorFacingDirection(crossColor, Orientation.PositiveZ) || e.isColorFacingDirection(notCrossColor, Orientation.PositiveZ))) {
					int i = 0;
					Orientation o1 = e.getOrientationOfColor(crossColor);
					Orientation o2 = e.getOrientationOfColor(notCrossColor);
					while(!(e.isColorFacingDirection(crossColor, Orientation.PositiveZ) || e.isColorFacingDirection(notCrossColor, Orientation.PositiveZ))) {
						if(i < 4){
							solution.add(c.turnAroundOrientation(o1, f));
						}else{
							solution.add(c.turnAroundOrientation(o2, f));
						}
						i++;
					}
					solution.add(c.up(f));
					while(i%4 != 0){
						if(i < 4){
							solution.add(c.turnAroundOrientation(o1, f));
						}else{
							solution.add(c.turnAroundOrientation(o2, f));
						}
						i++;
					}
				}else if(e.isColorFacingDirection(crossColor, Orientation.PositiveZ)) {
					while(!e.isColorFacingDirection(notCrossColor, orientationOfColor.get(notCrossColor))) {
						solution.add(c.up(f));
					}
					solution.add(c.turnAroundOrientation(orientationOfColor.get(notCrossColor), f)); 
					solution.add(c.turnAroundOrientation(orientationOfColor.get(notCrossColor), f));
				}else if(e.isColorFacingDirection(notCrossColor, Orientation.PositiveZ)) {
					while(!e.isColorFacingDirection(crossColor, orientationOfColor.get(notCrossColor))) {
						solution.add(c.up(f));
					}
					solution.add(c.turnAroundOrientation(e.getOrientationOfColor(crossColor), f));
					solution.add(c.down(f));
					solution.add(c.turnAroundOrientation(e.getOrientationOfColor(notCrossColor), f));
					solution.add(c.turnAroundOrientation(e.getOrientationOfColor(notCrossColor), f));
					solution.add(c.turnAroundOrientation(e.getOrientationOfColor(notCrossColor), f));
					solution.add(c.downPrime(f));
				}
			}
		}
		return solution;
	}
	
	private ArrayList<Move> solveBottomCorners(Cube c, Frame f){
		ArrayList<Move> solution = new ArrayList<Move>();
		while(!c.bottomCornersSolved()){
			Corner corner = c.getBottomCornerPiece();
			if(corner.getPos().getZ() == 2){
				while(!(corner.getPos().getX() == corner.getSolvedPos().getX() && corner.getPos().getY() == corner.getSolvedPos().getY())){
					solution.add(c.up(f));
				}
				while(!corner.isSolved()){
					solution.addAll(specialMove(c, corner, f));
				}
			}else if(corner.getPos().getZ() == 0){
				solution.add(c.up(f));
				solution.addAll(specialMove(c, corner, f));
			}
		}
		return solution;
	}	
}