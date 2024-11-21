// How to install the library at https://github.com/waconvo/waconvo-java

import com.waconvo.WAConvo;
import com.waconvo.Params;
import com.waconvo.exceptions.ResponseException;
import com.waconvo.resources.Location;

public class AirportNearest {

  public static void main(String[] args) throws ResponseException {

    WAConvo waconvo = WAConvo
        .builder("YOUR_API_ID","YOUR_API_SECRET")
        .build();

    // Airport Nearest Relevant (for London)
    Location[] locations = waconvo.referenceData.locations.airports.get(Params
      .with("latitude", 49.0000)
      .and("longitude", 2.55));

    if(locations[0].getResponse().getStatusCode() != 200) {
        System.out.println("Wrong status code: " + locations[0].getResponse().getStatusCode());
        System.exit(-1);
    }
    System.out.println(locations[0]);
  }
}
