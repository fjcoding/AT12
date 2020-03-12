import java.awt.*;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.*;


class Game extends JFrame{

    public Game(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(900,900);
		this.setVisible(true);
    }
    
    public static void start(){
        Game game = new Game();
    }
    public static void main(String[] args){
          start();
    }
}
