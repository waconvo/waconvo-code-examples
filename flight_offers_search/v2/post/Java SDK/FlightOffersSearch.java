// How to install the library at https://github.com/waconvo/waconvo-java

import com.waconvo.WAConvo;
import com.waconvo.exceptions.ResponseException;
import com.waconvo.resources.FlightOfferSearch;

public class FlightOffersSearch {

  public static void main(String[] args) throws ResponseException {

    WAConvo waconvo = WAConvo
        .builder("YOUR_WACONVO_API_KEY","YOUR_WACONVO_API_SECRET")
        .build();

    String body = "{\"currencyCode\":\"USD\",\"originDestinations\":[{\"id\":\"1\",\"originLocationCode\":\"RIO\",\"destinationLocationCode\":\"MAD\",\"departureDateTimeRange\":{\"date\":\"2022-08-01\",\"time\":\"10:00:00\"}},{\"id\":\"2\",\"originLocationCode\":\"MAD\",\"destinationLocationCode\":\"RIO\",\"departureDateTimeRange\":{\"date\":\"2022-08-05\",\"time\":\"17:00:00\"}}],\"travelers\":[{\"id\":\"1\",\"travelerType\":\"ADULT\",\"fareOptions\":[\"STANDARD\"]},{\"id\":\"2\",\"travelerType\":\"CHILD\",\"fareOptions\":[\"STANDARD\"]}],\"sources\":[\"GDS\"],\"searchCriteria\":{\"maxFlightOffers\":2,\"flightFilters\":{\"cabinRestrictions\":[{\"cabin\":\"BUSINESS\",\"coverage\":\"MOST_SEGMENTS\",\"originDestinationIds\":[\"1\"]}],\"carrierRestrictions\":{\"excludedCarrierCodes\":[\"AA\",\"TP\",\"AZ\"]}}}}";

    FlightOfferSearch[] flightOffersSearches = waconvo.shopping.flightOffersSearch.post(body);

    if (flightOffersSearches[0].getResponse().getStatusCode() != 200) {
        System.out.println("Wrong status code: " + flightOffersSearches[0].getResponse().getStatusCode());
        System.exit(-1);
    }

    System.out.println(flightOffersSearches[0]);
  }
}