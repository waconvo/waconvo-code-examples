# Install the Python library from https://pypi.org/project/waconvo
from waconvo import Client, ResponseError

waconvo = Client(
    client_id='YOUR_WACONVO_API_KEY',
    client_secret='YOUR_WACONVO_API_SECRET'
)

try:
    '''
    Find cheapest dates from Madrid to Munich
    '''
    response = waconvo.shopping.flight_dates.get(origin='MAD', destination='MUC')
    print(response.data)
except ResponseError as error:
    raise error
