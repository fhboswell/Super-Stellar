import java.awt.event.KeyEvent;
import java.util.Observable;


public class Events extends Observable{
    int type;

    Object event;

    public void setUp(KeyEvent e) {
        type = 1; // let's assume this means key input.
        //Should use CONSTANT value for this when you program
        event = e;
        setChanged();
        // trigger notification
        notifyObservers(this);
    }
    public void setDown(KeyEvent e) {
        type = 2; // let's assume this means key input.
        //Should use CONSTANT value for this when you program
        event = e;
        setChanged();
        // trigger notification
        notifyObservers(this);
    }

    public void setValue(int hitType) {
        type = 3;
        event = hitType;
        setChanged();
        // trigger notification
        notifyObservers(this);
    }

    public int getType(){
        return this.type;
    }

    public Object getEvent(){
        return this.event;
    }

}