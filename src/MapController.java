import java.util.ArrayList;
import java.util.ListIterator;

/**
 * Created by henryboswell on 7/22/17.
 */
public class MapController {

    private ArrayList<MapUnit> map = new ArrayList<MapUnit>();


    public MapController() {


        initMap();
    }

    private void initMap() {

        generateBorder();
        genMap1();

    }

    private void generateBorder() {

        // MapUnit newUnit = new MapUnit(100,100);
        for (int i = 0; i < 28; i++) {
            this.addUnit(new MapUnit(i * 32, 0));
        }
        for (int i = 0; i < 28; i++) {
            this.addUnit(new MapUnit(i * 32, 895));
        }
        for (int i = 0; i < 28; i++) {
            this.addUnit(new MapUnit(0, i * 32));
        }
        for (int i = 0; i < 29; i++) {
            this.addUnit(new MapUnit(895, (i * 32)));
        }
    }
    public void genMap1(){

        for (int i = 0; i < 16; i++) {
            this.addUnit(new MapUnit(i * 32 + (6*32), 200));
        }
        for (int i = 0; i < 16; i++) {
            this.addUnit(new MapUnit(i * 32 + (6*32), 690));
        }

    }

    public ListIterator<MapUnit> getMap(){
        return map.listIterator();
    }
    public void addUnit(MapUnit unit){

        map.add(unit);

    }



}
