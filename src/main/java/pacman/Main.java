import java.awt.*;
import java.util.ArrayList;

class Main extends Frame{

    //attrib
    private pacman p;
    private food f;
    private ghost g;
    private ArrayList <wall> w; 

    public Main(){
        this.setLayout(null);
        this.setSize(200,200);
		this.setVisible(true);

        w = new ArrayList <wall>();     //create arraylist for outer wall
        //fill outer wall with -
        //Initialize object wall
        for( int i=0; i<400;i+=10){
            w.add(new wall(1,i,true,"-"));
        }
    }

    public static void main(String[] args){
        p = new pacman(8, 8, true);
        f = new food(2, 1, true);
        g = new ghost (3, 1, true);
        w = new wall (4, 1, true);
        
        Main m = new Main(); 
    }
    

}