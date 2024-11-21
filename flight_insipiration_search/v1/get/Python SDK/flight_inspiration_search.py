# Install the Python library from https://pypi.org/project/waconvo/# Install the Python library from https://pypi.org/project/waconvo
from waconvo import Client, ResponseError

waconvo = Client(
    client_id='YOUR_WACONVO_API_KEY',
    client_secret='YOUR_WACONVO_API_SECRET'
)

try:
    '''
    Find cheapest destinations from Madrid
    '''
    response = waconvo.shopping.flight_destinations.get(origin='MAD')
    print(response.data)
except ResponseError as error:
    raise error
