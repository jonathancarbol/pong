package pong.event;

/*
       Events passed from model to GUI

       *** Nothing to do here ***
 */
public class Event {

    // Enumeration of events
    public enum Type {
        BALL_HIT_PADDLE,
        BALL_HIT_WALL_CEILING,
        NEW_BALL
    }

    public final Event.Type type;
    public final Object data;  // Possible send some data to GUI

    public Event(Event.Type type, Object data) {
        this.type = type;
        this.data = data;
    }

    public Event(Event.Type type) {
        this.type = type;
        this.data = null;
    }

    @Override
    public String toString() {
        return type.toString();
    }
}