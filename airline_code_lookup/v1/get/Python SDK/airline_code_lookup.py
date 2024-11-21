# Install the Python library from https://pypi.org/project/waconvo
from waconvo import Client, ResponseError

waconvo = Client(
    client_id='YOUR_WACONVO_API_KEY',
    client_secret='YOUR_WACONVO_API_SECRET'
)

try:
    '''
    What's the airline name for the IATA code BA?
    '''
    response = waconvo.reference_data.airlines.get(airlineCodes='BA')
    print(response.data)
except ResponseError as error:
    raise error
