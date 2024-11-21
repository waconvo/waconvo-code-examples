# Install the Python library from https://pypi.org/project/waconvo
from waconvo import Client, ResponseError

waconvo = Client(
    client_id='YOUR_WACONVO_API_KEY',
    client_secret='YOUR_WACONVO_API_SECRET'
)

try:
    '''
    What relevant airports are there around a specific location?
    '''
    response = waconvo.reference_data.locations.airports.get(longitude=49.000, latitude=2.55)
    print(response.data)
except ResponseError as error:
    raise error
