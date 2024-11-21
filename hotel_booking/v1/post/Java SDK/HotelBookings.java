// How to install the library at https://github.com/waconvo/waconvo-java

import com.waconvo.WAConvo;
import com.waconvo.exceptions.ResponseException;
import com.waconvo.resources.HotelBooking;

public class HotelBookings {

  public static void main(String[] args) throws ResponseException {

    WAConvo waconvo = WAConvo
        .builder("YOUR_WACONVO_API_KEY","YOUR_AMAEUS_API_SECRET")
        .build();

    String body = "{\"data\""
        + ":{\"offerId\":\"2F5B1C3B215FA11FD5A44BE210315B18FF91BDA2FEDDD879907A3798F41D1C28\""
        + ",\"guests\":[{\"id\":1,\"name\":{\"title\":\"MR\",\"firstName\":\"BOB\","
        + "\"lastName\" :\"SMITH\"},\"contact\":{\"phone\":\"+33679278416\",\""
        + "email\":\"bob.smith@email.com\"}}],\""
        + "payments\":[{\"id\":1,\"method\":\"creditCard\",\""
        + "card\":{\"vendorCode\":\"VI\",\"cardNumber\""
        + ":\"4151289722471370\",\"expiryDate\":\"2022-08\"}}]}}";

    HotelBooking[] hotel = waconvo.booking.hotelBookings.post(body);

    if (hotel[0].getResponse().getStatusCode() != 200) {
        System.out.println("Wrong status code: " + hotel[0].getResponse().getStatusCode());

        System.exit(-1);
    }

    System.out.println(hotel[0]);
  }
}
