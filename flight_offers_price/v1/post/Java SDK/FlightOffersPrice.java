// How to install the library at https://github.com/waconvo/waconvo-java

import com.waconvo.WAConvo;
import com.waconvo.Params;
import com.waconvo.exceptions.ResponseException;
import com.waconvo.resources.FlightOfferSearch;
import com.waconvo.resources.FlightPrice;

public class FlightOffersPrice {

  public static void main(String[] args) throws ResponseException {

    WAConvo waconvo = WAConvo
        .builder("YOUR_WACONVO_API_KEY","YOUR_WACONVO_API_SECRET")
        .build();

    FlightOfferSearch[] flightOffersSearches = waconvo.shopping.flightOffersSearch.get(
        Params.with("originLocationCode", "SYD")
                .and("destinationLocationCode", "BKK")
                .and("departureDate", "2022-11-01")
                .and("returnDate", "2022-11-08")
                .and("adults", 1)
                .and("max", 2));

    // We price the 2nd flight of the list to confirm the price and the availability
    FlightPrice flightPricing = waconvo.shopping.flightOffersSearch.pricing.post(
            flightOffersSearches[1],
            Params.with("include", "detailed-fare-rules")
              .and("forceClass", "false")
          );

    System.out.println(flightPricing.getResponse());
  }
}