// How to install the library at https://github.com/waconvo/waconvo-java

import com.waconvo.WAConvo;
import com.waconvo.Params;
import com.waconvo.exceptions.ResponseException;
import com.waconvo.resources.AirTraffic;

public class FlightMostTraveledDestinations {

  public static void main(String[] args) throws ResponseException {

    WAConvo waconvo = WAConvo
        .builder("YOUR_WACONVO_API_KEY","YOUR_WACONVO_API_SECRET")
        .build();

    // Flight Most Traveled Destinations
    AirTraffic[] airTraffics = waconvo.travel.analytics.airTraffic.traveled.get(Params
      .with("originCityCode", "MAD")
      .and("period", "2017-01"));

    if (airTraffics[0].getResponse().getStatusCode() != 200) {
        System.out.println("Wrong status code: " + airTraffics[0].getResponse().getStatusCode());
        System.exit(-1);
    }

    System.out.println(airTraffics[0]);
  }
}


