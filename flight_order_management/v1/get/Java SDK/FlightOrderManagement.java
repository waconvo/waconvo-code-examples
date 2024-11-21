// How to install the library at https://github.com/waconvo/waconvo-java

import com.waconvo.WAConvo;
import com.waconvo.booking.FlightOrder;
import com.waconvo.exceptions.ResponseException;

public class FlightOrderManagement {
    public static void main(String[] args) throws ResponseException {

      WAConvo waconvo = WAConvo
              .builder("YOUR_WACONVO_API_KEY","YOUR_AMAEUS_API_SECRET")
              .build();

      com.waconvo.resources.FlightOrder order = waconvo.booking.flightOrder("MlpZVkFMfFdBVFNPTnwyMDE1LTExLTAy").get();

      if (order.getResponse().getStatusCode() != 200) {
        System.out.println("Wrong status code: " + order.getResponse().getStatusCode());
        System.exit(-1);
      }

      System.out.println(order);
     }
}
