package company;

import java.io.IOException;
import java.util.Scanner;

import static company.EventWrapper.addEvents;

public class Instructor {

    private static EventWrapper eventWrapper;

    public static void createData() throws IOException {
        Scanner userInput = new Scanner(System.in);
        String id = null;
        String name = null;
        String description = null;
        String localDate = null;
        String localTime = null;
        String postalCode = null;
        String cityName = null;
        String provinceName = null;
        String countryName = null;
        String address = null;
        String venue = null;
        String genre = null;

        company.Event eventObj = new Event();

        for (int i = 0; i < 12; i++) {
            if (i == 0) {
                System.out.println("Enter Event Id: ");
                id = userInput.nextLine();
                eventObj.setId(id);
            }
            if (i == 1) {
                System.out.println("Enter Event Name: ");
                name = userInput.nextLine();
                eventObj.setName(name);
            }
            if (i == 2) {
                System.out.println("Enter Event Description: ");
                description = userInput.nextLine();
                eventObj.setDescription(description);
            }
            if (i == 3) {
                System.out.println("Enter Event Date: ");
                localDate = userInput.nextLine();
                eventObj.setLocalDate(localDate);
            }
            if (i == 4) {
                System.out.println("Enter Event Time: ");
                localTime = userInput.nextLine();
                eventObj.setLocalTime(localTime);
            }
            if (i == 5) {
                System.out.println("Enter Event PostalCode: ");
                postalCode = userInput.nextLine();
                eventObj.setPostalCode(postalCode);
            }
            if (i == 6) {
                System.out.println("Enter Event City: ");
                cityName = userInput.nextLine();
                eventObj.setCityName(cityName);
            }
            if (i == 7) {
                System.out.println("Enter Event Province: ");
                provinceName = userInput.nextLine();
                eventObj.setProvinceName(provinceName);
            }
            if (i == 8) {
                System.out.println("Enter Event Country: ");
                countryName = userInput.nextLine();
                eventObj.setCountryName(countryName);
            }
            if (i == 9) {
                System.out.println("Enter Event Address: ");
                address = userInput.nextLine();
                eventObj.setAddress(address);
            }
            if (i == 10) {
                System.out.println("Enter Event Venue: ");
                venue = userInput.nextLine();
                eventObj.setVenue(venue);
            }
            if (i == 11) {
                System.out.println("Enter Event Genre: ");
                genre = userInput.nextLine();
                eventObj.setGenre(genre);
            }
        }

        addEvents(eventObj);
    }
}
