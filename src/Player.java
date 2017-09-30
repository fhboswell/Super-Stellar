import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class Player extends Sprite implements Observer {

    private int dx;
    private int dy;
    private int health = 60;

    private ArrayList bullets;
    private int playerNumber;

    int modulusx = 0;
    int modulusy = 0;

    protected Image left;
    protected Image right;
    protected Image damaged;
    protected Image standard;



    public Player(int x, int y, int d, int playerNumber) {
        super(x, y, d);
        this.playerNumber = playerNumber;

        initPlayer();
    }

    public void reset(){
        this.x =300;
        this.y = 500;
        this.direction = 0;
        health = 60;

    }
    public void arbitraryMove(){
        x = 700;
        y = 700;
    }

    private void initPlayer() {

        bullets = new ArrayList();
        loadImage("Resources/Player.png");
        getImageDimensions();
        ImageIcon ii = new ImageIcon("Resources/playerLeft.png");
        left = ii.getImage();
        ImageIcon ij = new ImageIcon("Resources/playerright.png");
        right = ij.getImage();
        ImageIcon ik = new ImageIcon("Resources/playerDamaged.png");
        damaged = ik.getImage();
        standard = image;
    }

    public int getHealth() {
        return health;
    }

    public void move() {


        //System.out.print("move");
        //System.out.print(this.text);
        if(health > 20) {
            int yy = y;
            int xx = x;

            /*
            if(dy != 0) {

                gdx = (int) (5 * (double) Math.cos(Math.toRadians(direction + 90)));
                gdy = (int) (5 * (double) Math.sin(Math.toRadians(direction + 90)));
            }
            if(dx == 1) {
                direction = direction+4;
            }
            if(dx == -1) {
                direction = direction-4;
            }
            if x
            */

            if (dx == 0 && modulusx > dx) {
                modulusx--;
            } else if (dx == 0 && modulusx < dx) {
                modulusx++;
               // System.out.println(modulusx + " " + dx);
            }
            if (dy == 0 && modulusy > dy) {
                modulusy--;
            } else if (dy == 0 && modulusy < dy) {
                modulusy++;
            }
           // System.out.println(modulusx + " " + dx);
            if (dx > 0 && modulusx < 8) {
                modulusx++;
            }
            if (dx < 0 && modulusx > -8) {
                modulusx--;
            }
            if (dy > 0 && modulusy < 8) {
                modulusy++;
            }
            if (dy < 0 && modulusy > -8) {
                modulusy--;
            }


           // System.out.println(modulusx + " " + dx);
            x += dx + modulusx;
            y += dy + modulusy;
            if (x > 565) {
                x = 565;
            }
            if (x < 25) {
                x = 25;
            }

            if (y > 560) {
                y = 560;
            }
            if (y < 300) {
                y = 300;
            }
            if(x>xx){
                image = right;
            }
            if(x<xx){
                image = left;
            }
            if(x==xx){
                image = standard;
            }
        }else{
            image = damaged;
            x+=dx;
            y+=dy;
        }

    }
    public void shunt(float xShunt, float yShunt){
        float xf = x + xShunt;
        float yf = y + yShunt;
        x = (int)xf;
        y = (int)yf;

    }

    public ArrayList getBullets() {
        return bullets;
    }
    public void fire() {
        bullets.add(new Bullet(x, y, 167));
    }


    public void update(Observable o, Object arg) {

        Events events = (Events) arg;
        if(events.type == 1) {


            KeyEvent e = (KeyEvent) events.event;
            int key = e.getKeyCode();
            if (playerNumber == 1) {


                if (key == KeyEvent.VK_LEFT) {
                    dx = 0;

                }

                if (key == KeyEvent.VK_RIGHT) {
                    dx = 0;
                }

                if (key == KeyEvent.VK_UP) {
                    dy = 0;
                }

                if (key == KeyEvent.VK_DOWN) {
                    dy = 0;
                }
            } else {


                if (key == KeyEvent.VK_A) {

                    dx = 0;
                }

                if (key == KeyEvent.VK_D) {
                    dx = 0;
                    //System.out.print("here");
                }

                if (key == KeyEvent.VK_W) {
                    dy = 0;
                }

                if (key == KeyEvent.VK_S) {
                    dy = 0;
                }
            }
        }else if(events.type == 2){

            KeyEvent e = (KeyEvent) events.event;
            //System.out.print("key");
            //System.out.print(e);
            int key = e.getKeyCode();
            if(playerNumber == 1) {

                if (key == KeyEvent.VK_SPACE) {
                    fire();
                }

                if (key == KeyEvent.VK_LEFT) {
                    dx = -1;



                }

                if (key == KeyEvent.VK_RIGHT) {
                    dx = 1;
                }

                if (key == KeyEvent.VK_UP) {
                    dy = -1;
                }

                if (key == KeyEvent.VK_DOWN) {
                    dy = 1;
                }
            }else {



                if (key == KeyEvent.VK_Q) {
                    fire();
                }

                if (key == KeyEvent.VK_A) {
                    // System.out.print("he    ");
                    dx = -1;
                }

                if (key == KeyEvent.VK_D) {
                    dx = 1;
                }

                if (key == KeyEvent.VK_W) {
                    dy = -1;
                }

                if (key == KeyEvent.VK_S) {
                    dy = 1;
                }
            }

        }else if(events.type == 3){
            health = health - 20;
        }


    }
}