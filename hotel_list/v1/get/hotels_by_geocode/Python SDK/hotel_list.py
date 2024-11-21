# Install the Python library from https://pypi.org/project/waconvo
from waconvo import ResponseError, Client

waconvo = Client(
    client_id='YOUR_WACONVO_API_KEY',
    client_secret='YOUR_WACONVO_API_SECRET'
)

try:
    '''
    Get list of hotels by a geocode
    '''
    response = waconvo.reference_data.locations.hotels.by_geocode.get(longitude=2.160873,latitude=41.397158)

    print(response.data)
except ResponseError as error:
    raise error