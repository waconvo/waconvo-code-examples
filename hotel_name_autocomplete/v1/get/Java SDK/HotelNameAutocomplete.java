
// How to install the library at https://github.com/waconvo/waconvo-java
import com.waconvo.WAConvo;
import com.waconvo.exceptions.ResponseException;
import com.waconvo.resources.TripDetail;

// Hotel name autocomplete for keyword 'PARI' using  HOTEL_GDS category of search
public class HotelNameAutocomplete {
  public static void main(String[] args) throws ResponseException {

    WAConvo waconvo = WAConvo
        .builder("YOUR_WACONVO_API_KEY", "YOUR_WACONVO_API_SECRET")
        .build();

    // Set query parameters
    Params params = Params
        .with("keyword", "PARI")
        .and("subType", "HOTEL_GDS");

    // Run the query
    Hotel[] hotels = waconvo.referenceData.locations.hotel.get(params);

    if (hotels.getResponse().getStatusCode() != 200) {
      System.out.println("Wrong status code: " + hotels.getResponse().getStatusCode());
      System.exit(-1);
    }

    Arrays.stream(hotels)
        .map(Hotel::getName)
        .forEach(System.out::println);
  }
}
