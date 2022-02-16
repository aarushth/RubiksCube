public class MoveParser {

	public void parse(String s, Cube c) {
		for(int i = 0; i < s.length(); i++) {
			if(!(s.charAt(i) == 'F' || s.charAt(i) == 'R' || s.charAt(i) == 'U' || s.charAt(i) == 'L' || s.charAt(i) == 'B' || s.charAt(i) == 'D' || s.charAt(i) == ' ' || s.charAt(i) == '\'' || s.charAt(i) == '2')) {
				return;
			}
		}
		for(int i = 0; i < s.length(); i++) {
			switch(s.charAt(i)) {
				case 'F':
					if(s.length() -1 == i) {
						c.front();
					}else {
						switch(s.charAt(i+1)) {
							case ' ':
								c.front();
								break;
							case '2':
								c.frontTwo();
								break;
							case '\'':
								c.frontPrime();
								break;
						}
					}
					break;
				case 'R':
					if(s.length() -1 == i) {
						c.right();
					}else {
						switch(s.charAt(i+1)) {
							case ' ':
								c.right();
								break;
							case '2':
								c.rightTwo();
								break;
							case '\'':
								c.rightPrime();
								break;
						}
					}
					break;
				case 'U':
					if(s.length() -1 == i) {
						c.up();
					}else {
						switch(s.charAt(i+1)) {
							case ' ':
								c.up();
								break;
							case '2':
								c.upTwo();
								break;
							case '\'':
								c.upPrime();
								break;
						}
					}
					break;
				case 'L':
					if(s.length() -1 == i) {
						c.left();
					}else {
						switch(s.charAt(i+1)) {
							case ' ':
								c.left();
								break;
							case '2':
								c.leftTwo();
								break;
							case '\'':
								c.leftPrime();
								break;
						}
					}
					break;
				case 'B':
					if(s.length() -1 == i) {
						c.back();
					}else {
						switch(s.charAt(i+1)) {
							case ' ':
								c.back();
								break;
							case '2':
								c.backTwo();
								break;
							case '\'':
								c.backPrime();
								break;
						}
					}
					break;
				case 'D':
					if(s.length() -1 == i) {
						c.down();
					}else {
						switch(s.charAt(i+1)) {
							case ' ':
								c.down();
								break;
							case '2':
								c.downTwo();
								break;
							case '\'':
								c.downPrime();
								break;
						}
					}
					break;
			}
		}
	}
}