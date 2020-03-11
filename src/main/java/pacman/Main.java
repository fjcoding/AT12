import java.awt.*;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.*;


class Main extends Frame{

    //attrib
    //private pacman p;
    //private food f;
    //private ghost g;
    //private ArrayList <wall> w; 

    public Main(){
        this.setLayout(null);
        this.setSize(900,900);
		this.setVisible(true);
        //JPanel panel = new JPanel();
        //panel.setPreferredSize(new Dimension(900,900));
        ///panel.setBackground(Color.BLACK);
        //
        //JLabel label = new JLabel(ghost);
        //panel.add(label);
       // w = new ArrayList <wall>();     //create arraylist for outer wall
        //fill outer wall with -
        //Initialize object wall
        
    }
    public void paint(Graphics g,int x, int y){
        //g.setColor(Color.RED);
        ImageIcon ghost = new ImageIcon("images/ghost.jpg");
        Image ghostImg = ghost.getImage();
        g.drawImage(ghostImg,0,0,50,50,null);
        
    }
    public static void main(String[] args){
        //p = new pacman(8, 8, true);
        //f = new food(2, 1, true);
        //g = new ghost (3, 1, true);
        //w = new wall (4, 1, true);
        ghost ghost1 = new ghost(1,1,true);
        Thread ghostThread = new Thread(ghost1);
        ghostThread.start();
        //Graphics g = new Graphics();
        paint(ghost1.getX(), ghost1.getY());
         
        Main m = new Main(); 
        
    }

}
