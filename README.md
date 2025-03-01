# Rubiks Cube Solver
#### Video Demo:  https://youtu.be/vWYQajlpFrM
#### Description: A rubiks cube solver built in Java. Open up the Main class to edit the initial scramble, and then run it. A window will open up with a 2d net of a rubiks cube. press R, U, L, D, B, or F to twist the right, up, left, down, back or front face clockwise. Hold shift to twist anti-clockwise. Press enter to solve the cube. The calculated solution will be printed to the standard output. It uses the beginners method to solve the cube. The Cube is represented in the Cube class which has pieces represented by a Piece object. The Piece class is extended by the Corner, Edge and Center classes which have 3, 2 and 1 Face objects respectively. Each Face object has a Color enum and an Orientation enum, which is used by the Solver class to solve the cube. The Buffer class is used to draw the Cube onto an instance of the Panel class which is a canvas which gets displayed on the JFrame made by the Frame class. The Move Parser is used to convert moves in a string to an Array of Move enums and back, so that the scramble can be executed by the cube, and then the solution can be printed to standard output. The Control Class handles all of the main objects, instantiating the Frame, Buffer, MoveParser and Solver and handles passing relevent data between them.
