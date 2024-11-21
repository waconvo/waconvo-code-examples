// How to install the library at https://github.com/waconvo/waconvo-java

import com.waconvo.WAConvo;
import com.waconvo.Params;
import com.waconvo.exceptions.ResponseException;
import com.waconvo.resources.Period;

public class FlightBusiestPeriod {

  public static void main(String[] args) throws ResponseException {

    WAConvo waconvo = WAConvo
        .builder("YOUR_WACONVO_API_KEY","YOUR_WACONVO_API_SECRET")
        .build();

    // Flight Busiest Traveling Period
    Period[] busiestPeriods = waconvo.travel.analytics.airTraffic.busiestPeriod.get(Params
      .with("cityCode", "MAD")
      .and("period", "2017")
      .and("direction", BusiestPeriod.ARRIVING));

    if(busiestPeriods[0].getResponse().getStatusCode() != 200) {
        System.out.println("Wrong status code: " + (busiestPeriods[0].getResponse().getStatusCode());
        System.exit(-1);
    }
    System.out.println((busiestPeriods[0]);
  }
}
