/**
 * Created by henryboswell on 7/22/17.
 */
public class MapUnit extends Sprite {

    public MapUnit(int x, int y) {
        super(x, y, 0);

        initMapUnit();
    }

    private void initMapUnit() {

        loadImage("Resources/Wall2.png");
        getImageDimensions();
    }



}
