// How to install the library at https://github.com/waconvo/waconvo-java

import com.waconvo.WAConvo;
import com.waconvo.Params;
import com.waconvo.exceptions.ResponseException;
import com.waconvo.resources.FlightOfferSearch;
import com.google.gson.JsonObject;

public class FlightChoicePrediction {

  public static void main(String[] args) throws ResponseException {

    WAConvo waconvo = WAConvo
        .builder("YOUR_WACONVO_API_KEY","YOUR_WACONVO_API_SECRET")
        .build();

    FlightOfferSearch[] flightOffers = waconvo.shopping.flightOffersSearch.get(
                  Params.with("originLocationCode", "MAD")
                          .and("destinationLocationCode", "NYC")
                          .and("departureDate", "2022-11-01")
                          .and("returnDate", "2022-11-09")
                          .and("adults", 1));

    JsonObject body = flightOffers[0].getResponse().getResult();
    FlightOfferSearch[] flightOffersPrediction = waconvo.shopping.flightOffers.prediction.post(body);

    if (flightOffersPrediction[0].getResponse().getStatusCode() != 200) {
        System.out.println("Wrong status code: " + flightOffersPrediction[0].getResponse().getStatusCode());
        System.exit(-1);
    }

    System.out.println(flightOffersPrediction[0]);
  }
}