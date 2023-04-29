import java.util.ArrayList;

import RubiksCube.Move;

public class BetterSolver {

    private int cornerPosition;
    private int cornerOrientation;
    private long edgePositionTop;
    private long edgePositionBottom;
    private long edgeOrientation;
    
    public ArrayList<Move> solve(int cp, int co, long ep1, long ep2, long eo){
        cornerPosition = cp;
        cornerOrientation = co;
        edgePositionTop = ep1;
        edgePositionBottom = ep2;
        edgeOrientation = eo;
        print();
        up();
        up();
        up();
        up();

        print();
        return null;
    }

    private void up(){
        cornerPosition = (((cornerPosition/10000)%10)*10000000)+((cornerPosition/100000)*10000)+(cornerPosition%10000);
        cornerOrientation = (((cornerOrientation/10000)%10)*10000000)+((cornerOrientation/100000)*10000)+(cornerOrientation%10000);
        edgePositionTop = (((edgePositionTop/10000)%100)*10000000000l)+((edgePositionTop/1000000)*10000)+(edgePositionTop%10000);
        edgeOrientation = (((edgeOrientation/100000000)%10)*100000000000l)+((edgeOrientation/1000000000)*10000000000l)+(edgeOrientation%100000000);
        return;
    }
    

    private void print(){
        System.out.println(cornerPosition);
        System.out.println(cornerOrientation);
        System.out.println(edgePositionTop);
        System.out.println(edgePositionBottom);
        System.out.println(edgeOrientation);
        
    }
}
