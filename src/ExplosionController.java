import java.util.ArrayList;
import java.util.ListIterator;

/**
 * Created by henryboswell on 7/25/17.
 */
public class ExplosionController {

    private ArrayList<Explosion> explosions = new ArrayList<Explosion>();

    public ExplosionController() {


        InitExplosionController();
    }

    private void InitExplosionController() {



    }
    public boolean isEmpty(){
        return explosions.isEmpty();
    }


    public ListIterator<Explosion> getExplosions(){
        return explosions.listIterator();
    }
    public void addUnit(Explosion unit){

        explosions.add(unit);

    }
    public void remove(Explosion unit){

        explosions.remove(unit);

    }

}
