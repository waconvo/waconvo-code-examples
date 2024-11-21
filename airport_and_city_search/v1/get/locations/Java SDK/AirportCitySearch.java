// How to install the library at https://github.com/waconvo/waconvo-java

import com.waconvo.WAConvo;
import com.waconvo.Params;
import com.waconvo.exceptions.ResponseException;
import com.waconvo.resources.Location;

public class AirportCitySearch {

  public static void main(String[] args) throws ResponseException {

    WAConvo waconvo = WAConvo
        .builder("YOUR_WACONVO_API_KEY","YOUR_WACONVO_API_SECRET")
        .build();

    // Get a specific city or airport based on its id
    Location location = waconvo.referenceData
      .location("ALHR").get();

    if(location.getResponse().getStatusCode() != 200) {
        System.out.println("Wrong status code: " + location.getResponse().getStatusCode());
        System.exit(-1);
    }

    System.out.println(location);
  }
}
