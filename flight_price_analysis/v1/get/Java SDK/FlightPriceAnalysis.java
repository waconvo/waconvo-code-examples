// How to install the library at https://github.com/waconvo/waconvo-java

import com.waconvo.WAConvo;
import com.waconvo.Params;
import com.waconvo.exceptions.ResponseException;
import com.waconvo.resources.ItineraryPriceMetric;

public class FlightPriceAnalysis {

  public static void main(String[] args) throws ResponseException {

    WAConvo waconvo = WAConvo
        .builder("YOUR_API_ID","YOUR_API_SECRET")
        .build();

    // What's the flight price analysis from MAD to CDG
    ItineraryPriceMetric[] metrics = waconvo.analytics.itineraryPriceMetrics.get(Params
        .with("originIataCode", "MAD")
        .and("destinationIataCode", "CDG")
        .and("departureDate", "2022-03-21"));

    if (metrics[0].getResponse().getStatusCode() != 200) {
        System.out.println("Wrong status code: " + metrics[0].getResponse().getStatusCode());
        System.exit(-1);
    }

    System.out.println(metrics[0]);
  }
}