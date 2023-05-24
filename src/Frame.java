import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.event.InputEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Frame extends JFrame{
	public interface EventListener{
		public void onPaintEvent(Graphics g);
		public void onKeyEvent(String move);
		public void onEnterEvent();
	}
	
	private Canvas c;
	public EventListener listener;
	private JLabel solution = new JLabel("solution");
	
	
	public Frame(EventListener e) {
		setBounds(1, 1, 989, 750);
		listener = e;
		setTitle("Rubiks Cube");
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setFocusable(true);
		c = new Canvas() {
			public void paint(Graphics g){
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
			int shift = event.getModifiersEx();
			String move = " ";
			if(keyCode == KeyEvent.VK_ENTER) {
				listener.onEnterEvent();
			}
			if(keyCode == KeyEvent.VK_U) {
				move = "U";
			}else if(keyCode == KeyEvent.VK_D){
				move = "D";
			}else if(keyCode == KeyEvent.VK_L){
				move = "L";
			}else if(keyCode == KeyEvent.VK_R){
				move = "R";
			}else if(keyCode == KeyEvent.VK_B){
				move = "B";
			}else if(keyCode == KeyEvent.VK_F){
				move = "F";
			}
			if((shift & InputEvent.SHIFT_DOWN_MASK) != 0) {
				move = move + "'";
			}
			listener.onKeyEvent(move);
			
		}
		
	}
	public void updateFrame() {
		c.repaint();
	}

}