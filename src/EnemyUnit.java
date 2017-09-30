/**
 * Created by henryboswell on 7/22/17.
 */
public class EnemyUnit extends Sprite {

    private int speed;
    private int start = 0;
    private int shootFrequency = 10;

    public EnemyUnit(int x, int y , int s, int shootFrequency, int start) {
        super(x, y, 0);
        this.speed = s;
        this.shootFrequency = shootFrequency;
        this.start = start;

        initMapUnit();
    }

    private void initMapUnit() {

        loadImage("Resources/enemyship.png");
        getImageDimensions();

    }
    public int getSpeed(){
        return speed;
    }
    public int shoot(int count){
        if(count%shootFrequency == 0){
            return 1;
        }else{
            return 0;
        }
    }




}
