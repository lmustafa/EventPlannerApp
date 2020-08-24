package company;
import org.json.JSONObject;
import org.json.JSONArray;

import java.awt.*;
//import java.awt.Event;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class TicketMaster implements Data{

    private static HttpURLConnection connection;
    private StringBuffer responseContent = new StringBuffer();

    @Override
    public void ParseAPI() {

        BufferedReader reader;
        String line;

        try {
            URL url = new URL("https://app.ticketmaster.com/discovery/v2/events?apikey=Hs3XjORs8LvOMQGeGmGL1m5aC934G5KS&locale=*&countryCode=CA");
            //URL url = new URL("https://app.ticketmaster.com/discovery/v2/events?apikey=Hs3XjORs8LvOMQGeGmGL1m5aC934G5KS&locale=*&size=2&page=1&city=Toronto&countryCode=CA&stateCode=ON");
            connection = (HttpURLConnection) url.openConnection();

            //Request Setup
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(500);
            connection.setReadTimeout(500);

            int status = connection.getResponseCode();
            //System.out.println(status);

            if(status > 299) {
                reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
                while((line = reader.readLine()) != null) {
                    responseContent.append(line);
                }
                reader.close();
            }
            else {
                reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                while((line = reader.readLine()) != null) {
                    responseContent.append(line);
                }
                reader.close();
            }
            getData();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            connection.disconnect(); // need to close the connection
        }

    }

    @Override
    public void getData() {
        getDataString(responseContent.toString());
    }

    public void getDataString(String responseBody) {

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

        JSONObject obj = new JSONObject(responseBody);
        JSONObject events = obj.getJSONObject("_embedded");
        //System.out.println(events);
        JSONArray arr = events.getJSONArray("events");
        //System.out.println(arr);
        EventWrapper eventWrapper = new EventWrapper();

        for (int i = 0; i < arr.length(); ++i) {

            // CREATE NEW EVENT OBJECT
            Event event = new Event();
            JSONObject rec = arr.getJSONObject(i);

            //GET LOCAL_DATE AND LOCAL_TIME
            JSONObject date = rec.getJSONObject("dates");
            JSONObject start = date.getJSONObject("start");
            localDate = start.getString("localDate");
            localTime = start.getString("localTime");

            //GET EVENT_NAME
            name = rec.getString("name");
            id   = rec.getString("id");

            //GET DESCRIPTION
            //description = rec.getString("pleaseNote");
            description = rec.optString("pleasaeNote");

            /* GET:
             * city name
             * province name
             * country name
             * address (line1)
             * venue name
             * */
            JSONObject embedded = rec.getJSONObject("_embedded");
            JSONArray venues = embedded.getJSONArray("venues");
            for(int j = 0; j < venues.length(); j++) {
                JSONObject venueObjects = venues.getJSONObject(j);
                JSONObject addressName = venueObjects.getJSONObject("address");
                JSONObject city = venueObjects.getJSONObject("city");
                JSONObject province = venueObjects.getJSONObject("state");
                JSONObject country = venueObjects.getJSONObject("country");

                address = addressName.getString("line1");
                cityName = city.getString("name");
                provinceName = province.getString("name");
                countryName = country.getString("name");
                postalCode = venueObjects.getString("postalCode"); //its own object
                venue = venueObjects.getString("name");
            }

            //GET GENRE
            JSONArray classifications = rec.getJSONArray("classifications");
            for(int k = 0; k < classifications.length(); k++) {
                JSONObject for_genre = classifications.getJSONObject(k);
                JSONObject genre_object = for_genre.getJSONObject("genre");
                genre = genre_object.getString("name");
                //System.out.println(genre_name);

            }

            event.setId(id);
            event.setName(name);
            event.setDescription(description);
            event.setLocalDate(localDate);
            event.setLocalTime(localTime);
            event.setPostalCode(postalCode);
            event.setCityName(cityName);
            event.setProvinceName(provinceName);
            event.setCountryName(countryName);
            event.setAddress(address);
            event.setVenue(venue);
            event.setGenre(genre);
            eventWrapper.addEvents(event);
        }
    }

}