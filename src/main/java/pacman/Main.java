import java.awt.*;
import java.util.ArrayList;

class Main extends Frame{

	//attrib
    private Pacman objectPacman;
    private Dots objectDots;
    private Ghost objectGhost;
 
	public Main(){
		this.setLayout(null);
		this.setSize(200,200);
		this.setVisible(true);
    }

    public static void main(String[] args){     
        Main m = new Main();      
    }
    
}
