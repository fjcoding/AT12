import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

class Main extends JFrame {
    //attrib
<<<<<<< HEAD
    private Dot objectDots;
    private Ghost objectGhost;
    private DrawComponents drawComponents ;
 
    public Main(){
        this.drawComponents = new DrawComponents();
        this.addKeyListener(new ActionKeyPacman(drawComponents));
        this.setSize(900, 900);
        this.setVisible(true); 
    }
    public static void main(String[] args){       
        
        Main frame = new Main();
        frame.setMinimumSize(new Dimension(900, 900));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(frame.drawComponents);
        frame.pack();
        frame.setVisible(true);       
    }  
=======
    private pacman p;
    private food f;
    private ghost g;
    private ArrayList <wall> w; 
   
    public Main(){
        this.setLayout(null);
        this.setSize(900,930);
        this.setVisible(true);
        this.setBackground(Color.BLACK);
		this.setLocation(400,200);
        this.setTitle("PACMAN");
        
    }
    public void paint(Graphics g){
        wall [][] allWalls=new wall[30][30];
        for(int i=0;i<30;i++){
            for(int j=0;j<30;j++){
                if((i==0)||(i==29)||(j==0)||(j==29)){
                    allWalls[i][j]=new wall(i,j,true);
                    g.setColor(Color.ORANGE);
                    g.fillRect(allWalls[i][j].getY()*30,allWalls[i][j].getX()*30+30,30,30);
                }
                else if((i==28)&&(j==13)){
                    allWalls[i][j]=new wall(i,j,true);
                    g.setColor(Color.ORANGE);
                    g.fillRect(allWalls[i][j].getY()*30,allWalls[i][j].getX()*30+30,30,30);
                }
                else if(((i==27)&&((j>=2)&&(j<=5)))||((i==27)&&((j>=7)&&(j<=11)))||(i==27)&&(j==13)||((i==27)&&((j>=15)&&(j<=21)))||(i==27)&&(j==23)||(i==27)&&(j==25)||(i==27)&&(j==27)){
                    allWalls[i][j]=new wall(i,j,true);
                    g.setColor(Color.ORANGE);
                    g.fillRect(allWalls[i][j].getY()*30,allWalls[i][j].getX()*30+30,30,30);
                }
                else if(((i==26)&&(j==13))||((i==26)&&((j>=20)&&(j<=21)))||(i==26)&&(j==23)||(i==26)&&(j==25)||(i==26)&&(j==27)){
                    allWalls[i][j]=new wall(i,j,true);
                    g.setColor(Color.ORANGE);
                    g.fillRect(allWalls[i][j].getY()*30,allWalls[i][j].getX()*30+30,30,30);
                }
                else if(((i==25)&&(j==2))||((i==25)&&(j==4))||((i==25)&&(j==6))||((i==25)&&(j==8))||((i==25)&&(j==10))||((i==25)&&((j>=12)&&(j<=13)))||((i==25)&&((j>=16)&&(j<=18)))){
                    allWalls[i][j]=new wall(i,j,true);
                    g.setColor(Color.ORANGE);
                    g.fillRect(allWalls[i][j].getY()*30,allWalls[i][j].getX()*30+30,30,30);
                }
                else if(((i==24)&&(j==2))||((i==24)&&(j==4))||((i==24)&&(j==6))||((i==24)&&(j==8))||((i==24)&&(j==10))||((i==25)&&((j>=12)&&(j<=13)))||((i==25)&&((j>=16)&&(j<=18)))){
                    allWalls[i][j]=new wall(i,j,true);
                    g.setColor(Color.ORANGE);
                    g.fillRect(allWalls[i][j].getY()*30,allWalls[i][j].getX()*30+30,30,30);
                }
                
            }    
        }
    }
    void Update(Graphics g)
	{
        paint(g);
        
	}
    public static void main(String[] args){
 
        
        Main m = new Main(); 
    }
// Method to create wall objects around 
    public void createWallAround(){
       
        
        wall aroundUpWalls=new wall(0,0,true);
        aroundUpWalls.x=0;
        aroundUpWalls.y=0;
      
    }


    

>>>>>>> mirko here the change
}
