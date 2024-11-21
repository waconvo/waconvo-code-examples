// How to install the library at https://github.com/waconvo/waconvo-java

import com.waconvo.WAConvo;
import com.waconvo.Params;
import com.waconvo.exceptions.ResponseException;
import com.waconvo.resources.FlightDestination;

public class FlightInspirationSearch {

  public static void main(String[] args) throws ResponseException {

    WAConvo waconvo = WAConvo
        .builder("YOUR_WACONVO_API_KEY","YOUR_WACONVO_API_SECRET")
        .build();

    FlightDestination[] flightDestinations = waconvo.shopping.flightDestinations.get(Params
    .with("origin", "MAD"));

    if (flightDestinations[0].getResponse().getStatusCode() != 200) {
        System.out.println("Wrong status code: " + flightDestinations[0].getResponse().getStatusCode());
        System.exit(-1);
    }

    System.out.println(flightDestinations[0]);
  }
}