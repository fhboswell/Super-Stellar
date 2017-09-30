/**
 * Created by henryboswell on 7/21/17.
 */
public class Bullet extends Sprite {

    private final int BOARD_WIDTH = 60000;
    private final int BULLET_SPEED= 2;

    public Bullet(int x, int y, int d) {
        super(x, y, d);

        initBullet();
    }

    private void initBullet() {

        loadImage("Resources/laserGreen.png");
        getImageDimensions();
    }


    public void move() {

        x += BULLET_SPEED;

        if (x > BOARD_WIDTH || x < 0 || y > BOARD_WIDTH || y <0) {
            vis = false;
        }




        int gdx = (int) (10 * (double) Math.cos(Math.toRadians(direction + 90)));
        int gdy = (int) (10 * (double) Math.sin(Math.toRadians(direction + 90)));




        x += gdx;
        y += gdy;

        if(y >610){
            this.setNotVisible();
        }
    }
    public void setNotVisible(){
        vis = false;
    }
}
