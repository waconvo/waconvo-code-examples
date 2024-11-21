# Install the Python library from https://pypi.org/project/waconvo
from waconvo import Client, ResponseError

waconvo = Client(
    client_id='YOUR_WACONVO_API_KEY',
    client_secret='YOUR_WACONVO_API_SECRET'
)

try:
    '''
    What are the destinations served by MAD airport?
    '''
    response = waconvo.airport.direct_destinations.get(departureAirportCode='MAD')
    print(response.data)
except ResponseError as error:
    raise error
