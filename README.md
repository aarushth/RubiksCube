# Rubiks Cube Solver
#### Video Demo:  https://youtu.be/vWYQajlpFrM
#### Description: I have built a rubiks cube solver in Java. Open up the Main class to edit the initial scramble, and then run it. A window will open up with a 2d net of a rubiks cube. Press R, U, L, D, B, or F to move the right, up, left, down, back or front face clockwise, according to standard cube notation. Hold shift to twist execute an anti-clockwise move. Press enter to begin solving the cube. The calculated solution will be printed to the standard output. It uses the beginners method to solve the cube, in which first the yellow cross is solved, followed by the yellow corners. Once the first layer is complete, it will execute an algorithm to insert the edges in the second layer, meaning the ones without white or yellow faces. Then it solves the white cross using two algorithms. The first one orients all of the white edge pieces to have the white side up. Then the second one put the white edge pieces into the correct spots. Then the white corners are solved using another two algorithms. The first one puts them into the correct spot, but not necessarily the right orientation. The second algorithm finally solves the cube by rotating the corners to be oriented correctly. The Cube is represented by a 3D array of Piece objects in in the Cube class. The cube class also has methods to rotate each face of the cube correctly. The Piece class is extended by the Corner, Edge and Center classes which have 3, 2 and 1 Face objects respectively. Each Face object has a Color enum and an Orientation enum, which contains a Vector Object, and a name. Each Piece object also has a Point object to know its position, and a rotation method to rotate each Face to the correct orientation based on the move being executed. These are all used by the Solver class to solve the cube, which is broken up into the steps of the beginner’s method mentioned earlier. The Solver outputs an ArrayList of Move enums which can be interpreted by the Cube class to execute the correct moves. The Buffer class is used to draw the Cube onto an instance of the Panel class which is an extension of the JPanel class. The Panel is a canvas which is seen on the Window rendered by the Frame class which is an extension of the JFrame class. The MoveParser class is used to convert moves in a string to an Array of Move enums and back, so that the scramble can be executed by the cube, and then the solution can be printed to standard output. The Control Class handles all of the main objects, instantiating the Cube, Frame, Buffer, MoveParser and Solver and handles passing relevent data between them.
