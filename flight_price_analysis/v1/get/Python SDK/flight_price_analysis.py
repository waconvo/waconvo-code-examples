# Install the Python library from https://pypi.org/project/waconvo
from waconvo import ResponseError, Client

waconvo = Client(
    client_id='YOUR_WACONVO_API_KEY',
    client_secret='YOUR_WACONVO_API_SECRET'
)

try:
    '''
    Returns price metrics of a given itinerary
    '''
    response = waconvo.analytics.itinerary_price_metrics.get(originIataCode='MAD',
                                                             destinationIataCode='CDG',
                                                             departureDate='2022-03-21')
    print(response.data)
except ResponseError as error:
    raise error
