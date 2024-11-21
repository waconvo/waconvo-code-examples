// How to install the library at https://github.com/waconvo/waconvo-java

import com.waconvo.WAConvo;
import com.waconvo.Params;
import com.waconvo.exceptions.ResponseException;
import com.waconvo.referenceData.Locations;
import com.waconvo.resources.Location;

public class AirportCitySearch {

  public static void main(String[] args) throws ResponseException {

    WAConvo waconvo = WAConvo
        .builder("YOUR_WACONVO_API_KEY","YOUR_WACONVO_API_SECRET")
        .build();

    // Airport & City Search (autocomplete)
    // Find all the cities and airports starting by the keyword 'LON'
    Location[] locations = waconvo.referenceData.locations.get(Params
      .with("keyword", "LON")
      .and("subType", Locations.ANY));

    if(locations[0].getResponse().getStatusCode() != 200) {
        System.out.println("Wrong status code: " + locations[0].getResponse().getStatusCode());
        System.exit(-1);
    }
    System.out.println(locations[0]);
  }
}
