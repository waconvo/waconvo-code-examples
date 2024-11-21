// How to install the library at https://github.com/waconvo/waconvo-java

import com.waconvo.WAConvo;
import com.waconvo.Params;
import com.waconvo.exceptions.ResponseException;
import com.waconvo.resources.HotelSentiment;

public class HotelRatings {

  public static void main(String[] args) throws ResponseException {

    WAConvo waconvo = WAConvo
        .builder("YOUR_WACONVO_API_KEY","YOUR_AMAEUS_API_SECRET")
        .build();

    // Hotel Ratings / Sentiments
    HotelSentiment[] hotelSentiments = waconvo.ereputation.hotelSentiments.get(Params.with("hotelIds", "ADNYCCTB"));

    if (hotelSentiments[0].getResponse().getStatusCode() != 200) {
        System.out.println("Wrong status code: " + hotelSentiments[0].getResponse().getStatusCode());
        System.exit(-1);
    }

    System.out.println(hotelSentiments[0]);
  }
}
