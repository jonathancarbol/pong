package pong.event;


import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;

/*
     Service to send events **from model** to GUI
     GUI must know if there has been a collision in the model etc.

     NOTE: Events **from GUI** to model handled by JavaFX events and keyboard listeners etc.

     *** Nothing to do here ****

 */
public final class EventService {

    // Store all incoming events
    private static final List<Event> events = new ArrayList<>();
    private static boolean debug = false;

    // Add an event to be sent to GUI
    public static void add(Event evt) {
        events.add(evt);
        if (debug) {             // Useful for tracing
            out.println(events);
        }
    }

    // Remove and return event. Called at frame rate speed in GUI
    public static Event remove() {
        if (events.size() > 0) {
            return events.remove(0);
        } else {
            return null;
        }
    }

}
