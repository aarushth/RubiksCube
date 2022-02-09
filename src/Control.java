import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Control implements Frame.EventListener{
	private MoveParser parser = new MoveParser();
	private Buffer buffer = new Buffer();
	private Frame frame = new Frame(this);
	private Cube cube;
	@Override
	public void onPaintEvent(Graphics g) {
		buffer.printStateFrame(cube.getCube(), g);
	}
	public Control(Cube c) {
		cube = c;
		frame.updateFrame();
	}
	@Override
	public void onKeyEvent(String move) {
		parser.parse(move, cube);
		frame.updateFrame();
	}

}
