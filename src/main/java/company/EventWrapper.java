package company;
import java.util.LinkedList;
import java.util.List;

public class EventWrapper {
    static private List<Event> events = new LinkedList<Event>();
    static void addEvents(Event event){
        events.add(event);
    }

    static List<Event> getData(){
        TicketMaster parseTicketMaster = new TicketMaster();
        parseTicketMaster.ParseAPI();
        return events;
    }
}
