# Install the Python library from https://pypi.org/project/waconvo
from waconvo import Client, ResponseError

waconvo = Client(
    client_id='YOUR_WACONVO_API_KEY',
    client_secret='YOUR_WACONVO_API_SECRET'
)

try:
    '''
    Find the probability of the flight MAD to NYC to be chosen
    '''
    body = waconvo.shopping.flight_offers_search.get(originLocationCode='MAD',
                                                     destinationLocationCode='NYC',
                                                     departureDate='2022-11-01',
                                                     returnDate='2022-11-09',
                                                     adults=1).result
    response = waconvo.shopping.flight_offers.prediction.post(body)
    print(response.data)
except ResponseError as error:
    raise error
