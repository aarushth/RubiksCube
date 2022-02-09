import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;

public class Frame extends JFrame{
	public interface EventListener{
		public void onPaintEvent(Graphics g);
		public void onKeyEvent(String move);
	}
	
	private Canvas c;
	private EventListener listener;
	private boolean isEnterPressed = false;
	
	
	public Frame(EventListener e) {
		setBounds(1, 1, 989, 750);
		listener = e;
		setTitle("Rubiks Cube");
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setFocusable(true);
		c = new Canvas() {
			public void paint (Graphics g){
				g.fillRect(0, 0, WIDTH, HEIGHT);
				listener.onPaintEvent(g);
			}
		};

		add(c);

		
		addKeyListener(new KeyListener());
	}
	private class KeyListener extends KeyAdapter{
		
		@Override
		public void keyPressed(KeyEvent event) {
			int keyCode = event.getKeyCode();
			String move = "-";
			if(keyCode == event.VK_U) {
				move = "U ";
			}else if( keyCode == event.VK_D){
				move = "D ";
			}else if(keyCode == event.VK_L){
				move = "L ";
			}else if(keyCode == event.VK_R){
				move = "R ";
			}else if(keyCode == event.VK_B){
				move = "B ";
			}else if(keyCode == event.VK_F){
				move = "F ";
			}
			
			listener.onKeyEvent(move);
			
		}
	}

	public void updateFrame() {
		c.repaint();
	}
}
