import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Random;


/**
 * Created by henryboswell on 7/22/17.
 */
public class EnemyBulletController {

    private ArrayList<Bullet> Bullets = new ArrayList<Bullet>();
    private int frequency;
    private int count = 0;


    public EnemyBulletController() {

    }




    public void moveBullets(){

        ListIterator<Bullet> units = Bullets.listIterator();
        while(units.hasNext()){
            Bullet unit = units.next();

            unit.move();
            if(unit.isVisible()){
                units.remove();
            }




        }

    }




    public ListIterator<Bullet> getBullet(){
        return Bullets.listIterator();
    }
    public void addUnit(Bullet unit){

        Bullets.add(unit);

    }



}
