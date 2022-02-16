import java.util.ArrayList;

import java.util.Iterator;

import RubiksCube.*;

public class Solver {
	public String solveCube(Cube c){
		StringBuffer solution = new StringBuffer("");
		Cube clone = new Cube();
		clone.setCube(c.getCube());
		solution.append(solveCross(clone));
		
		
		
		
		
		
		return solution.toString();
	}
	
	
	
	private String solveCross(Cube c) {
		StringBuffer solution = new StringBuffer("");
		while(!c.crossSolved()) {
			Edge e = c.getCrossPiece();
			Color crossColor = Color.YELLOW;
			Color notCrossColor = e.getNotThisColor(crossColor);			
			if(e.isColorFacingDirection(crossColor, Orientation.PositiveZ)) {
				while(!e.isColorFacingDirection(notCrossColor, notCrossColor.getOrientation())) {
					solution.append(c.up());
				}
				solution.append(c.turnAroundOrientation(notCrossColor.getOrientation()) + c.turnAroundOrientation(notCrossColor.getOrientation()));
			}else if(e.isColorFacingDirection(notCrossColor, Orientation.NegativeZ)) {
				while(!e.isColorFacingDirection(crossColor, notCrossColor.getOrientation())) {
					solution.append(c.up());
				}
				solution.append(c.turnAroundOrientation(e.getOrientationOfColor(crossColor)) + c.down() + c.turnAroundOrientation(e.getOrientationOfColor(notCrossColor)) + c.downPrime());
			}else if(!(e.isColorFacingDirection(crossColor, Orientation.NegativeZ) || e.isColorFacingDirection(notCrossColor, Orientation.NegativeZ))) {
				while(!(e.isColorFacingDirection(crossColor, Orientation.PositiveZ) || e.isColorFacingDirection(notCrossColor, Orientation.PositiveZ))) {
					solution.append(c.turnAroundOrientation(e.getOrientationOfColor(crossColor)));
				}
				solution.append(c.up());
			}
		}
		return solution.toString();
	}
}
