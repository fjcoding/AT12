import javax.swing.*;
import java.awt.*;

class Monster extends position implements Runnable{

    private JPanel panel;
    private boolean eatable;

    public Monster (int x, int y,boolean exist, JPanel panel){
         super(x,y,exist);
        this.eatable = false;
        this.panel = panel;
    }
    public boolean getExist(){
         return exist;
    }
    public void setX(int x){
         super.x = x;
    }
    public void setY(int y){
         super.y = y;
    }
    public boolean setExist(boolean exist){
        super.exist = exist;
        return true;
    }
    public void moveUp(){
        super.y--;
    }
    public void moveDown(){
        super.y++;
    }
    public void moveLeft(){
         super.x--;
    }
    public void moveRight(){
         super.x++;
    }
    public boolean isPosibleMoveDown(){
        return true;
    }
    public boolean isPosibleMoveRight(){
        return true;
    }
    public boolean isPosibleMoveUp(){
        return true;
    }
    public boolean isPosibleMoveLeft(){
        return true;
    }
    public void paintMonster(){
        Graphics paper = panel.getGraphics();
        paint(paper);
    }
    public void paint(Graphics g){
        ImageIcon ghost = new ImageIcon("images/ghost.png");
        Image ghostImg = ghost.getImage();
        g.drawImage(ghostImg,x,y,50,50,null);
    }
    public void delay(){
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void searchRoute(){
        if(isPosibleMoveDown()){
            moveDown();
        }
        else{
            if(isPosibleMoveRight()){
                moveRight();
            }
            else{
                if(isPosibleMoveUp()){
                    moveUp();
                }	
                else{
                    moveLeft();
                }
            }
        }
    }
    @Override
    public void run(){
        while(exist){
            paintMonster();
            searchRoute();
            delay();
            panel.repaint();
            //panel.removeAll();
            System.out.println("hola");
        }
    }
    public void stopRun(){
        exist = false;
    }
}