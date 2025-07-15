🧩 Rubik's Cube Solver (Java)

📹 Video Demo: Watch on YouTube
📖 Description

This project is a Rubik's Cube Solver built in Java, utilizing the beginner's method to solve the cube step-by-step. It features a simple interactive GUI for manual twisting and automatic solving of the cube.
🧠 How It Works

    Edit the Scramble:
    Open the Main class and modify the scramble manually.

    Run the Program:
    Running the program opens a GUI window showing a 2D net of a Rubik's Cube.

    Controls:

        Press R, U, L, D, B, or F to turn the corresponding face clockwise.

        Hold Shift while pressing a key to turn a face counterclockwise.

        Press Enter to begin solving the cube.

    Output:

        The solution steps are printed to standard output.

        Moves follow standard Rubik's Cube notation.

🧮 Solving Algorithm (Beginner’s Method)

    Yellow Cross – Align yellow edges on top.

    Yellow Corners – Complete the first (yellow) layer.

    Second Layer Edges – Insert non-yellow, non-white edges correctly.

    White Cross –

        First, orient the white edges to have white on top.

        Then, place them in correct positions.

    White Corners –

        Position corners correctly.

        Finally, orient corners to complete the cube.

🧱 Code Architecture

    Cube

        Represents the Rubik’s Cube as a 3D array of Piece objects.

        Contains methods for rotating each face.
    Piece (Abstract)

        Extended by:

            Corner – 3 Faces

            Edge – 2 Faces

            Center – 1 Face

        Contains a Point for position and rotation logic.
    Face

        Contains:

            Color (enum)

            Orientation (enum with Vector and name)
    Solver

        Implements the beginner's method step-by-step.

        Returns a list of Move enums used to solve the cube.
    MoveParser

        Converts between string-based moves and Move enums.

        Used for scrambles and outputting solutions.
    Control

        Coordinates the application by instantiating and linking:

            Cube

            Frame

            Buffer

            MoveParser

            Solver
    Buffer

        Handles drawing the cube onto the GUI.
    Panel (extends JPanel)

        Custom canvas for rendering the cube.
    Frame (extends JFrame)

        Main application window.

🚀 Getting Started

    Clone or download the repository.

    Open the project in your favorite Java IDE.

    Modify the scramble in Main.java if desired.

    Run the Main class.

