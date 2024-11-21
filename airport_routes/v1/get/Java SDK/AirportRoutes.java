// How to install the library at https://github.com/waconvo/waconvo-java

import com.waconvo.WAConvo;
import com.waconvo.Params;
import com.waconvo.exceptions.ResponseException;
import com.waconvo.resources.Destination;

public class AirportRoutes {

  public static void main(String[] args) throws ResponseException {
    WAConvo waconvo = WAConvo
      .builder("YOUR_WACONVO_API_KEY", "YOUR_WACONVO_API_SECRET")
      .build();

    Destination[] directDestinations = waconvo.airport.directDestinations.get(
      Params.with("departureAirportCode", "MAD"));

    if (directDestinations[0].getResponse().getStatusCode() != 200) {
      System.out.println("Wrong status code: " + directDestinations[0].getResponse().getStatusCode());
      System.exit(-1);
    }

    System.out.println(directDestinations[0]);
  }
}