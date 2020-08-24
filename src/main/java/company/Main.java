package company;
import java.util.Map;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.io.IOException;


public class Main {

    public static void main(String[] args) {

        Instructor  instructor = new Instructor();
        EventWrapper eventWrapper = new EventWrapper();
        List<Event> events = eventWrapper.getData();

        String options = "List of options:" + "\n" +
                "1 - View All Events" + "\n" +
                "2 - View Analysis" + "\n"  +
                "3 - Create an Event" + "\n" +
                "4 - View all Events" + "\n"  +
                "Type \'quit' to quit." + "\n";

        String line = "--------------------------" + "\n";

        String optionSection = line + options + line;

        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println(optionSection);
        System.out.print("Enter: ");
        //String userInput = myObj.nextLine();
        String userInput = "quit";
        if(myObj.hasNextLine()){
           userInput  = myObj.nextLine();
        }

        while(!userInput.equalsIgnoreCase("quit")) {

            if(userInput.equalsIgnoreCase("1")) {
                viewData(events); //shows all the events in the List
            }

            else if(userInput.equalsIgnoreCase("2")) {
                showAnalysis(events);
            }
            else if(userInput.equalsIgnoreCase("3")) {
                try{
                    instructor.createData();
                    /*^^^^^^^*/
                }
                catch(IOException ex){
                    System.out.println (ex.toString());
                }
            }
            else if(userInput.equalsIgnoreCase("4")) {
                viewEvents(events);
            }
            else {
                System.out.println("Unrecognized command - try again.");
            }
            System.out.println(optionSection);
            System.out.print("Enter: ");
            userInput = myObj.nextLine();
        }

    }

    public static void viewData(List<Event> events) {
        System.out.println("All Events in Canada: ");
        for(Event e : events) {
            System.out.println(e);
        }

    }

    public static void viewAllData(List<Event> events) {
        System.out.println("All data:");
        for(Event e : events) {
            System.out.println(e);
        }
    }

    public static void showAnalysis(List<Event> events) {
        List<Event> torontoEvents = new LinkedList<Event>();
        System.out.println("Choose an option, or enter 'quit: ");
        System.out.println("-------------------------------------------------");
        System.out.println("All Events in Toronto");
        System.out.println("-------------------------------------------------");

        for(Event e : events) {
            if(e.getCityName().equalsIgnoreCase("Toronto")) {
                torontoEvents.add(e);
            }
        }

        for(Event e : torontoEvents) {
            System.out.println(e);
        }
        System.out.println("-------------------------------------------------");

        //Analysis 2: Number of sport-related events in Canada
        HashMap <String, Integer> typesOfSports = new HashMap<>();
        typesOfSports.put("Basketball", 0);
        typesOfSports.put("Soccer", 0);
        typesOfSports.put("Baseball",0);
        typesOfSports.put("Hockey",0);

        System.out.println("-------------------------------------------------");
        System.out.println("Number of Upcoming Sports Games in Canada");
        System.out.println("-------------------------------------------------");
        int number = 0;
        for(Event e : events) {
            String genre = e.getGenre();
            if(typesOfSports.get(genre) != null) {
                typesOfSports.put(genre, typesOfSports.get(genre) + 1);
            }
        }

        for (Map.Entry str : typesOfSports.entrySet()) {
            String key = (String)str.getKey();

            int value = ((int)str.getValue());

            System.out.println(key + " : " + value);
        }
        System.out.println("-------------------------------------------------");
    }

    public static void viewEvents(List<Event> events) {
        for(Event e : events) {
            System.out.println(e);
        }
    }

}