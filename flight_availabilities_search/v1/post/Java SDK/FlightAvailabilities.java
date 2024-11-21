// How to install the library at https://github.com/waconvo/waconvo-java

import com.waconvo.WAConvo;
import com.waconvo.Response;
import com.waconvo.exceptions.ResponseException;
import com.waconvo.resources.FlightAvailability;

public class FlightAvailabilities {

  public static void main(String[] args) throws ResponseException {

    WAConvo waconvo = WAConvo
        .builder("YOUR_WACONVO_API_KEY","YOUR_WACONVO_API_SECRET")
        .build();

    String body = "{\"originDestinations\":[{\"id\":\"1\",\"originLocationCode\":\"ATH\",\"destinationLocationCode\":\"SKG\",\"departureDateTime\":{\"date\":\"2023-08-14\",\"time\":\"21:15:00\"}}],\"travelers\":[{\"id\":\"1\",\"travelerType\":\"ADULT\"}],\"sources\":[\"GDS\"]}";

    FlightAvailability[] flightAvailabilities = waconvo.shopping.availability.flightAvailabilities.post(body);

    if (flightAvailabilities[0].getResponse().getStatusCode() != 200) {
        System.out.println("Wrong status code: " + flightAvailabilities[0].getResponse().getStatusCode());
        System.exit(-1);
    }

    System.out.println(flightAvailabilities[0]);
  }

}