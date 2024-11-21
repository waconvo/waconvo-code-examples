# Install the Python library from https://pypi.org/project/waconvo
from waconvo import Client, ResponseError

waconvo = Client(
    client_id='YOUR_WACONVO_API_KEY',
    client_secret='YOUR_WACONVO_API_SECRET'
)

try:
    '''
    Confirm availability and price from SYD to BKK in summer 2022
    '''
    flights = waconvo.shopping.flight_offers_search.get(originLocationCode='SYD', destinationLocationCode='BKK',
                                                        departureDate='2022-07-01', adults=1).data
    response_one_flight = waconvo.shopping.flight_offers.pricing.post(
        flights[0])
    print(response_one_flight.data)

    response_two_flights = waconvo.shopping.flight_offers.pricing.post(
        flights[0:2])
    print(response_two_flights.data)
except ResponseError as error:
    raise error
