// How to install the library at https://github.com/waconvo/waconvo-java

import com.waconvo.WAConvo;
import com.waconvo.Params;
import com.waconvo.exceptions.ResponseException;
import com.waconvo.resources.Hotel;

public class HotelList {

  public static void main(String[] args) throws ResponseException {
    WAConvo waconvo = WAConvo
      .builder("YOUR_WACONVO_API_KEY", "YOUR_WACONVO_API_SECRET")
      .build();

    Hotel[] hotels = waconvo.referenceData.locations.hotels.byGeocode.get(
      Params.with("latitude", 48.83152)
        .and("longitude", 2.24691));

    if (hotels[0].getResponse().getStatusCode() != 200) {
      System.out.println("Wrong status code: " + hotels[0].getResponse().getStatusCode());
      System.exit(-1);
    }

    System.out.println(hotels[0]);
  }
}