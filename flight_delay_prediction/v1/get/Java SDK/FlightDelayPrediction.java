// How to install the library at https://github.com/waconvo/waconvo-java

import com.waconvo.WAConvo;
import com.waconvo.Params;
import com.waconvo.exceptions.ResponseException;
import com.waconvo.resources.Delay;

public class FlightDelayPrediction {

  public static void main(String[] args) throws ResponseException {

    WAConvo waconvo = WAConvo
        .builder("YOUR_WACONVO_API_KEY","YOUR_WACONVO_API_SECRET")
        .build();

    Delay[] flightDelay = waconvo.travel.predictions.flightDelay.get(Params
    .with("originLocationCode", "NCE")
    .and("destinationLocationCode", "IST")
    .and("departureDate", "2022-08-01")
    .and("departureTime", "18:20:00")
    .and("arrivalDate", "2022-08-01")
    .and("arrivalTime", "22:15:00")
    .and("aircraftCode", "321")
    .and("carrierCode", "TK")
    .and("flightNumber", "1816")
    .and("duration", "PT31H10M"));

    if (flightDelay[0].getResponse().getStatusCode() != 200) {
        System.out.println("Wrong status code: " + flightDelay[0].getResponse().getStatusCode());
        System.exit(-1);
    }

    System.out.println(flightDelay[0]);
  }
}