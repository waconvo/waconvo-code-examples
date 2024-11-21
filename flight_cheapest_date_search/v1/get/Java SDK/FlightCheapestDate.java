// How to install the library at https://github.com/waconvo/waconvo-java

import com.waconvo.WAConvo;
import com.waconvo.Params;
import com.waconvo.exceptions.ResponseException;
import com.waconvo.resources.FlightDate;

public class FlightCheapestDate {

  public static void main(String[] args) throws ResponseException {

    WAConvo waconvo = WAConvo
        .builder("YOUR_WACONVO_API_KEY","YOUR_WACONVO_API_SECRET")
        .build();

    FlightDate[] flightDates = waconvo.shopping.flightDates.get(Params
      .with("origin", "MAD")
      .and("destination", "MUC"));

    if(flightDates[0].getResponse().getStatusCode() != 200) {
        System.out.println("Wrong status code: " + (flightDates[0].getResponse().getStatusCode());
        System.exit(-1);
    }
    System.out.println((flightDates[0]);
  }
}