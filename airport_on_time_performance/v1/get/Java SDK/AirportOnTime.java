// How to install the library at https://github.com/waconvo/waconvo-java

import com.waconvo.WAConvo;
import com.waconvo.Params;
import com.waconvo.exceptions.ResponseException;
import com.waconvo.resources.OnTime;

public class AirportOnTime {

  public static void main(String[] args) throws ResponseException {

    WAConvo waconvo = WAConvo
        .builder("YOUR_WACONVO_API_KEY","YOUR_WACONVO_API_SECRET")
        .build();

    OnTime onTime = waconvo.airport.predictions.onTime.get(Params
        .with("airportCode", "JFK")
        .and("date", "2022-09-01"));

    if(onTime.getResponse().getStatusCode() != 200) {
        System.out.println("Wrong status code: " + onTime.getResponse().getStatusCode());
        System.exit(-1);
    }
    System.out.println(onTime);
  }
}