// How to install the library at https://github.com/waconvo/waconvo-java

import com.waconvo.WAConvo;
import com.waconvo.Params;
import com.waconvo.exceptions.ResponseException;
import com.waconvo.resources.FlightOfferSearch;
import com.waconvo.resources.FlightPrice;
import com.waconvo.resources.FlightOrder;
import com.waconvo.resources.FlightOrder.Traveler;
import com.waconvo.resources.FlightOrder.Document.DocumentType;
import com.waconvo.resources.FlightOrder.Phone.DeviceType;
import com.waconvo.resources.FlightOrder.Name;
import com.waconvo.resources.FlightOrder.Phone;
import com.waconvo.resources.FlightOrder.Contact;
import com.waconvo.resources.FlightOrder.Document;

public class FlightSearch {

  public static void main(String[] args) throws ResponseException {

    WAConvo waconvo = WAConvo
            .builder("YOUR_WACONVO_API_KEY","YOUR_WACONVO_API_SECRET")
            .build();

    Traveler traveler = new Traveler();

    traveler.setId("1");
    traveler.setDateOfBirth("2000-04-14");
    traveler.setName(new Name("JORGE", "GONZALES"));

    Phone[] phone = new Phone[1];
    phone[0] = new Phone();
    phone[0].setCountryCallingCode("33");
    phone[0].setNumber("675426222");
    phone[0].setDeviceType(DeviceType.MOBILE);

    Contact contact = new Contact();
    contact.setPhones(phone);
    traveler.setContact(contact);

    Document[] document = new Document[1];
    document[0] = new Document();
    document[0].setDocumentType(DocumentType.PASSPORT);
    document[0].setNumber("480080076");
    document[0].setExpiryDate("2023-10-11");
    document[0].setIssuanceCountry("ES");
    document[0].setNationality("ES");
    document[0].setHolder(true);
    traveler.setDocuments(document);

    Traveler[] travelerArray = new Traveler[1];
    travelerArray[0] = traveler;
    System.out.println(travelerArray[0]);

    FlightOfferSearch[] flightOffersSearches = waconvo.shopping.flightOffersSearch.get(
            Params.with("originLocationCode", "MAD")
                    .and("destinationLocationCode", "ATH")
                    .and("departureDate", "2023-08-01")
                    .and("returnDate", "2023-08-08")
                    .and("adults", 1)
                    .and("max", 3));

    // We price the 2nd flight of the list to confirm the price and the availability
    FlightPrice flightPricing = waconvo.shopping.flightOffersSearch.pricing.post(
            flightOffersSearches[0]);

    // We book the flight previously priced
    FlightOrder order = waconvo.booking.flightOrders.post(flightPricing, travelerArray);
    System.out.println(order.getResponse());

    // Return CO2 Emission of the previously booked flight
    int weight = order.getFlightOffers()[0].getItineraries(
    )[0].getSegments()[0].getCo2Emissions()[0].getWeight();
    String unit = order.getFlightOffers()[0].getItineraries(
    )[0].getSegments()[0].getCo2Emissions()[0].getWeightUnit();

  }
}