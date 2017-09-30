
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 *
 */
public class EventAdaptor extends KeyAdapter {
    private Events events;

    public EventAdaptor(){

    }
    public EventAdaptor(Events es){
        this.events = es;
    }

    public void keyPressed(KeyEvent e) {
        events.setDown(e);
    }
    public void keyReleased(KeyEvent e){
        events.setUp(e);
    }

}