// How to install the library at https://github.com/waconvo/waconvo-java

import com.waconvo.WAConvo;
import com.waconvo.exceptions.ResponseException;
import com.waconvo.resources.City;

public class CitySearch {

  public static void main(String[] args) throws ResponseException {
    WAConvo waconvo = WAConvo
      .builder("YOUR_WACONVO_API_KEY", "YOUR_WACONVO_API_SECRET")
      .build();

    City[] cities = waconvo.referenceData.locations.cities.get(
      Params.with("keyword","PARIS")
    );

    if (cities[0].getResponse().getStatusCode() != 200) {
      System.out.println("Wrong status code: " + cities[0].getResponse().getStatusCode());
      System.exit(-1);
    }

    System.out.println(cities[0]);
  }
}
