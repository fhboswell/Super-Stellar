import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Random;


/**
 * Created by henryboswell on 7/22/17.
 */
public class EnemyController {

    private ArrayList<EnemyUnit> Enemy = new ArrayList<EnemyUnit>();
    private int frequency;
    private int count = 0;


    public EnemyController(int frequency) {
        this.frequency = frequency;





        initEnemy();
    }


    public void increaseFrequency(){
        frequency--;
    }
    public void setFrequency(int f){
        frequency = f;
    }

    private void initEnemy() {

        //generateBorder();
        genEnemy1(10);

    }
    public int getCount(){
        return count;
    }


    public void moveEnemys(){

        ListIterator<EnemyUnit> units = Enemy.listIterator();
        while(units.hasNext()){
            EnemyUnit unit = units.next();

            unit.y = unit.y + unit.getSpeed();
            if(unit.y >610){
                unit.setVisible(false);
            }
            if(unit.isVisible() && unit.y > 610){
                units.remove();
            }



        }
    }

    public void genEnemy1(int shootFrequency){

        count++;
        if(count % frequency == 0){

            Random rand = new Random();

            int  n = rand.nextInt(580) + 20;
            this.addUnit(new EnemyUnit(n, -70, 3, count, shootFrequency));
        }

    }

    public ListIterator<EnemyUnit> getEnemy(){
        return Enemy.listIterator();
    }
    public void addUnit(EnemyUnit unit){

        Enemy.add(unit);

    }



}
