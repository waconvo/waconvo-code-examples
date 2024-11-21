// How to install the library at https://github.com/waconvo/waconvo-java

import com.waconvo.WAConvo;
import com.waconvo.Params;
import com.waconvo.exceptions.ResponseException;
import com.waconvo.resources.CheckinLink;

public class FlightCheckinLinks {

  public static void main(String[] args) throws ResponseException {

    WAConvo waconvo = WAConvo
        .builder("YOUR_WACONVO_API_KEY","YOUR_WACONVO_API_SECRET")
        .build();

    CheckinLink[] checkinLinks = waconvo.referenceData.urls.checkinLinks.get(Params
      .with("airlineCode", "BA"));

    if(checkinLinks[0].getResponse().getStatusCode() != 200) {
        System.out.println("Wrong status code: " + (checkinLinks[0].getResponse().getStatusCode()));
        System.exit(-1);
    }

    System.out.println((checkinLinks[0]));
  }
}
