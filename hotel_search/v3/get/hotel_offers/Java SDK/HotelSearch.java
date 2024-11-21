// How to install the library at https://github.com/waconvo/waconvo-java

import com.waconvo.WAConvo;
import com.waconvo.Params;
import com.waconvo.exceptions.ResponseException;
import com.waconvo.resources.HotelOfferSearch;

public class HotelSearch {

  public static void main(String[] args) throws ResponseException {
    WAConvo waconvo = WAConvo
      .builder("YOUR_WACONVO_API_KEY", "YOUR_WACONVO_API_SECRET")
      .build();

    HotelOfferSearch[] offers = waconvo.shopping.hotelOffersSearch.get(
      Params.with("hotelIds", "RTPAR001")
        .and("adults", 2)
    );

    if (offers[0].getResponse().getStatusCode() != 200) {
      System.out.println("Wrong status code: " + offers[0].getResponse().getStatusCode());
      System.exit(-1);
    }

    System.out.println(offers[0]);
  }
}