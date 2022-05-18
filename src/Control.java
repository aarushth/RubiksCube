import java.awt.Graphics;
import java.util.ArrayList;

import RubiksCube.Move;

public class Control implements Frame.EventListener{
	private MoveParser parser = new MoveParser();
	private Buffer buffer = new Buffer();
	private Frame frame = new Frame(this);
	private Solver solver = new Solver();
	private Cube cube;
	
	public Control(Cube c, String s) {
		cube = c;
		parser.parse(parser.stringToMove(s), cube, frame);
	}
	@Override
	public void onPaintEvent(Graphics g) {
		buffer.printStateFrame(cube.getCube(), g);
	}
	@Override
	public void onKeyEvent(String move) {
		parser.parse(parser.stringToMove(move), cube, frame);
	}
	@Override
	public void onEnterEvent() {
		Thread thread = new Thread(){
			public void run(){
				ArrayList<Move> solution = solver.solveCube(cube, frame);
				solution = parser.compress(solution);
				buffer.displaySolution(parser.moveToString(solution));
				frame.updateFrame();
			}
		};
		thread.start();
	}

}