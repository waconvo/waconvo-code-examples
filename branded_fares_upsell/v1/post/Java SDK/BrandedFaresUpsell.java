// How to install the library at https://github.com/waconvo/waconvo-java

import com.waconvo.WAConvo;
import com.waconvo.Params;
import com.waconvo.exceptions.ResponseException;
import com.waconvo.resources.FlightOfferSearch;

public class BrandedFaresUpsell {

  public static void main(String[] args) throws ResponseException {

        WAConvo waconvo = WAConvo
            .builder("YOUR_WACONVO_API_KEY","YOUR_WACONVO_API_SECRET")
            .build();

        FlightOfferSearch[] flightOffersSearches = waconvo.shopping.flightOffersSearch.get(
            Params.with("originLocationCode", "SYD")
                    .and("destinationLocationCode", "BKK")
                    .and("departureDate", "2023-11-01")
                    .and("returnDate", "2023-11-08")
                    .and("adults", 1)
                    .and("max", 2));

        FlightOfferSearch[] upsellFlightOffers = waconvo.shopping.flightOffers.upselling.post(flightOffersSearches[0]);

        if (upsellFlightOffers[0].getResponse().getStatusCode() != 200) {
            System.out.println("Wrong status code: " + upsellFlightOffers[0].getResponse().getStatusCode());
            System.exit(-1);
        }

        System.out.println(upsellFlightOffers[0]);
    }
}