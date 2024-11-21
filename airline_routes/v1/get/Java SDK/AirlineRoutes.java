
// How to install the library at https://github.com/waconvo/waconvo-java
import com.waconvo.WAConvo;
import com.waconvo.exceptions.ResponseException;
import com.waconvo.resources.Destination;

// What are the destinations served by the British Airways (BA)?
public class AirlineRoutes {
  public static void main(String[] args) throws ResponseException {

    WAConvo waconvo = WAConvo
        .builder("YOUR_WACONVO_API_KEY", "YOUR_WACONVO_API_SECRET")
        .build();

    // Set query parameters
    Params params = Params
        .with("airlineCode", "BA");

    // Run the query
    Destination[] destinations = waconvo.airline.destinations.get(params);

    if (destinations[0].getResponse().getStatusCode() != 200) {
      System.out.println("Wrong status code: " + destinations[0].getResponse().getStatusCode());
      System.exit(-1);
    }

    System.out.println(destinations[0]);
  }
}
