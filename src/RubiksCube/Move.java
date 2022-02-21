package RubiksCube;

public enum Move{
    UP('U', 1), 
    UPTWO('U', 2),
    UPPRIME('U', 3),
    DOWN('D', 1),
    DOWNTWO('D', 2),
    DOWNPRIME('D', 3),
    LEFT('L', 1),
    LEFTTWO('L', 2),
    LEFTPRIME('L', 3),
    RIGHT('R', 1),
    RIGHTTWO('R', 2),
    RIGHTPRIME('R', 3),
    BACK('B', 1),
    BACKTWO('B', 2),
    BACKPRIME('B', 3),
    FRONT('F', 1),
    FRONTTWO('F', 2),
    FRONTPRIME('F', 3);

    private char type;
    private int value;
    Move(char t, int v){
        type = t;
        value = v;
    }

    public char getType(){
        return type;
    }
    public int getValue(){
        return value;
    }

}