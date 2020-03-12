
import java.awt.*;
import java.awt.FlowLayout;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.*;

class Game extends JFrame{

    private JPanel panel = new JPanel();
    
    public Game(){

        Container window = this.getContentPane();
        window.setLayout(new FlowLayout());
        panel.setBackground(Color.BLUE);
        panel.setVisible(true);
        panel.setSize(500,500);
        window.add(panel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(900,900);
        this.setVisible(true);
        this.setBackground(Color.GREEN);
        createMonsters();
    }
    public void createMonsters(){
        Thread monsterThread = new Thread(new Monster(100,50,true,panel),"monster 1");
        monsterThread.start();
    }
    public static void startGame(){
        Game game = new Game();
    }
    public static void main(String[] args){
        startGame();
    }
}
