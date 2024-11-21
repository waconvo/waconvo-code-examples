// How to install the library at https://github.com/waconvo/waconvo-java

import com.waconvo.WAConvo;
import com.waconvo.exceptions.ResponseException;
import com.waconvo.resources.HotelOfferSearch;

public class HotelSearch {

  public static void main(String[] args) throws ResponseException {
    WAConvo waconvo = WAConvo
      .builder("YOUR_WACONVO_API_KEY", "YOUR_WACONVO_API_SECRET")
      .build();

    HotelOfferSearch offer = waconvo.shopping.hotelOfferSearch(
        "0W7UU1NT9B")
      .get();

    if (offer.getResponse().getStatusCode() != 200) {
      System.out.println("Wrong status code: " + offer.getResponse().getStatusCode());
      System.exit(-1);
    }

    System.out.println(offer);
  }
}