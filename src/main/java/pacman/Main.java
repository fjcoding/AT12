import java.awt.*;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

class Main extends JFrame{

    //attrib
    private pacman p;
    private food f;
    private ghost g;
    private ArrayList <wall> w; 

    public Main(){
        this.setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(900,900);


        ImageIcon imageIcon = new ImageIcon("pacmanIcon.png");
        JButton buttonPacman= new JButton();
        buttonPacman.setBounds(50, 50, 30, 30);
        buttonPacman.setIcon(imageIcon);

        add(buttonPacman);


        this.setVisible(true);
        
        
    }

    public static void main(String[] args){
        //p = new pacman(8, 8, true);
        //f = new food(2, 1, true);
        //g = new ghost (3, 1, true);
        //w = new wall (4, 1, true);
        
        Main m = new Main(); 
    }
    

}
