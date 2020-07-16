import java.util.ArrayList;
import java.util.Random;

public class Ghost extends Position {
    private boolean eatable;
    private ListWalls lWall = new ListWalls();
    private ArrayList<Position> walls = lWall.getWalls();
    private String direccion;
    private String noPDir;
    private String irDir;
    private String ruta;
    private boolean atascado = false;
    final static private int WALK_DISTANCE = 30;
    final static private int NUM_POSIBLE_RUTES = 4;
    final static private int DOWN = 0;
    final static private int UP = 1;
    final static private int LEFT = 2;
    final static private int RIGHT = 3;

    public Ghost(int x, int y, boolean exist) {
        super(x, y, exist);
        this.eatable = false;
    }

    public Ghost(int x, int y, boolean exist, final ArrayList<Position> walls) {
        super(x, y, exist);
        this.eatable = false;
        this.walls = walls;
    }

    public boolean getExist() {
        return exist;
    }

    public void setX(int x) {
        super.x = x;
    }

    public void setY(int y) {
        super.y = y;
    }

    public int getX() {
        return super.x;
    }

    public int getY() {
        return super.y;
    }

    public boolean setExist(boolean exist) {
        super.exist = exist;
        return true;
    }

    public boolean isEatable() {
        return this.eatable;
    }

    public void changeEatable() {
        this.eatable = true;
    }

    public void die() {
        this.exist = false;
    }

    public boolean existPacmanEatable(Pacman pacman) {
        if (pacman.exist == true && pacman.getX() == this.x && pacman.getY() == this.getY()) {
            return true;
        }
        return false;
    }

    public void eatPacman(Pacman pacman) {
        pacman.die();
        this.exist = false;
    }

    public void moveUp() {
        super.y -= WALK_DISTANCE;
    }

    public void moveDown() {
        super.y += WALK_DISTANCE;
    }

    public void moveLeft() {
        super.x -= WALK_DISTANCE;
    }

    public void moveRight() {
        super.x += WALK_DISTANCE;
    }

    public boolean isPosibleMoveDown(final ArrayList<Position> walls) {
        for (Position wall : walls) {
            if (wall.getX() == this.x && wall.getY() == this.y + WALK_DISTANCE) {
                return false;
            }
        }
        return true;
    }

    public boolean isPosibleMoveUp(final ArrayList<Position> walls) {
        for (Position wall : walls) {
            if (wall.getX() == this.x && wall.getY() == this.y - WALK_DISTANCE) {
                return false;
            }
        }
        return true;
    }

    public boolean isPosibleMoveLeft(final ArrayList<Position> walls) {
        for (Position wall : walls) {
            if (wall.getX() == this.x - WALK_DISTANCE && wall.getY() == this.y) {
                return false;
            }
        }
        return true;
    }

    public boolean isPosibleMoveRight(final ArrayList<Position> walls) {
        for (Position wall : walls) {
            if (wall.getX() == this.x + WALK_DISTANCE && wall.getY() == this.y) {
                return false;
            }
        }
        return true;
    }

    public void searchRoute(Pacman pacman) {
        int nextMove = new Random().nextInt(NUM_POSIBLE_RUTES);

        switch (nextMove) {
        case DOWN:
            if (isPosibleMoveDown(walls)) {
                moveDown();
                if (existPacmanEatable(pacman)) {
                    eatPacman(pacman);
                }
            }
            break;
        case UP:
            if (isPosibleMoveUp(walls)) {
                moveUp();
                if (existPacmanEatable(pacman)) {
                    eatPacman(pacman);
                }
            }
            break;
        case LEFT:
            if (isPosibleMoveLeft(walls)) {
                moveLeft();
                if (existPacmanEatable(pacman)) {
                    eatPacman(pacman);
                }
            }
            break;
        case RIGHT:
            if (isPosibleMoveRight(walls)) {
                moveRight();
                if (existPacmanEatable(pacman)) {
                    eatPacman(pacman);
                }
            }
            break;
        default:
            break;
        }
    }

    public void searchRoute() {
        int nextMove = new Random().nextInt(NUM_POSIBLE_RUTES);

        switch (nextMove) {
        case DOWN:
            if (isPosibleMoveDown(walls)) {
                moveDown();
            }
            break;
        case UP:
            if (isPosibleMoveUp(walls)) {
                moveUp();
            }
            break;
        case LEFT:
            if (isPosibleMoveLeft(walls)) {
                moveLeft();
            }
            break;
        case RIGHT:
            if (isPosibleMoveRight(walls)) {
                moveRight();
            }
            break;
        default:
            break;
        }
    }

    //modificaion recorrido de los fantasmas..................................................
    public String getDirecctionX() {
        if (isPosibleMoveRight(walls)) {
            direccion = "right";
        } else {
            if (isPosibleMoveLeft(walls)) {
                direccion = "left";
            }
        }
        return direccion;
    }
    public String getDirecctionY() {
        if (isPosibleMoveUp(walls)) {
            direccion = "up";
        } else {
            if (isPosibleMoveDown(walls)) {
                direccion = "down";
            }
        }
        return direccion;
    }

    public void atascado() {
        switch (direccion) {
        case "down":
            if (isPosibleMoveDown(walls)) {
                if (irDir == getDirecctionX()) {
                    direccion =  irDir;
                    atascado = false;
                }else{
                    direccion = "down";
                }
            }else{
                direccion = getDirecctionX();
            }
            break;
        case "up":
            if (isPosibleMoveUp(walls)) {
                if (irDir == getDirecctionX()) {
                    direccion =  irDir;
                    atascado = false;
                }else{
                    direccion = "up";
                }
            }else{
                direccion = getDirecctionX();
            }
            break;
        case "left":
            if (isPosibleMoveLeft(walls)) {
                if (irDir == getDirecctionY()) {
                    direccion =  irDir;
                    atascado = false;
                }else{
                    direccion = "left";
                }
            }else{
                direccion = getDirecctionY();
            }
            break;
        case "right":
            if (isPosibleMoveRight(walls)) {
                if (irDir == getDirecctionY()) {
                    direccion =  irDir;
                    atascado = false;
                }else{
                    direccion = "right";
                }
            }else{
                direccion = getDirecctionY();
            }
            break;
        }
        
    }

    public String changeDireccionGhostX(Pacman pacman) {
        if (pacman.getX() > this.getX()) {
            return  direccion = "right";
        }else{
            if (pacman.getX() < this.getX()){
                return direccion = "left";
            }else
            if (isPosibleMove(changeDireccionGhostY(pacman))) {
                direccion = changeDireccionGhostY(pacman);
            } else {
                atascado = true;
                irDir = changeDireccionGhostY(pacman);
                //atascado();
            }
        }
        return direccion;
    }
    
    public String changeDireccionGhostY(Pacman pacman) {
        if (pacman.getY() < this.getY()){
            direccion = "up";
        }else{
            if (pacman.getY() > this.getY()){
                direccion = "down";
            }else{
                System.out.println( " change Y X"+changeDireccionGhostX(pacman));
                if (isPosibleMove(changeDireccionGhostX(pacman))) {
                    direccion = changeDireccionGhostX(pacman);
                } else {
                    atascado = true;
                    irDir = changeDireccionGhostX(pacman);
                    //atascado();
                    
                }
            }
        }
        return direccion;
    }

    public boolean isPosibleMove(String sigtDir) {
       boolean result = false;
        switch (sigtDir) {
            case "down":
                result = isPosibleMoveDown(walls);
                break;
            case "up":
                result = isPosibleMoveUp(walls);
                break;
            case "left":
                result = isPosibleMoveLeft(walls);
                break;
            case "right":
                result = isPosibleMoveRight(walls);
                break;
        }
        return result;
    }
    public String ruta(Pacman pacman){
        if (atascado) {
            atascado();

        }else{
            String sigDX = changeDireccionGhostX(pacman);
            String sigDY = changeDireccionGhostY(pacman);
            if(isPosibleMove(sigDX)){
                direccion = sigDX;
            }else{
                if(isPosibleMove(sigDY))
                    direccion = sigDY;
                else
                    atascado = true;
                /*  sigtDXA = changeDireccionGhostX(pacman);
                    sigtDYA = changeDireccionGhostX(pacman); */


            }
        }
        
        return direccion;
    }
    
    public void searchRouteGhost(Pacman pacman) {
        /* System.out.println("ruta"+ruta);

        if (ruta.equals("x")) {
            direccion = changeDireccionGhostX(pacman);
        } else {
            direccion = changeDireccionGhostY(pacman);
        } */
        direccion = ruta(pacman);

        switch (direccion) {
        case "down":
            if (isPosibleMoveDown(walls)) {
                moveDown();
                System.out.println("si se pudo"+ direccion);
                if (existPacmanEatable(pacman)) 
                    eatPacman(pacman);
            }else 
                System.out.println("No se pudo "+ direccion);
            break;
        case "up":
            if (isPosibleMoveUp(walls)) {
                moveUp();
                System.out.println("si se pudo"+ direccion);
                if (existPacmanEatable(pacman)) 
                    eatPacman(pacman);
            }else 
            System.out.println("No se pudo "+ direccion);
            break;
        case "left":
            if (isPosibleMoveLeft(walls)) {
                moveLeft();
                System.out.println("si se pudo"+ direccion);
                if (existPacmanEatable(pacman)) 
                    eatPacman(pacman);
            }else 
            System.out.println("No se pudo "+ direccion);
            break;
        case "right":
            if (isPosibleMoveRight(walls)) {
                moveRight();
                System.out.println("si se pudo"+ direccion);
                if (existPacmanEatable(pacman)) 
                    eatPacman(pacman);
            }else 
            System.out.println("No se pudo "+ direccion);
            break;
        }

        
    }
}