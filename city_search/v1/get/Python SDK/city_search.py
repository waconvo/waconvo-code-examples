# Install the Python library from https://pypi.org/project/waconvo
from waconvo import Client, ResponseError

waconvo = Client(
    client_id='YOUR_WACONVO_API_KEY',
    client_secret='YOUR_WACONVO_API_SECRET'
)

try:
    '''
    What are the cities matched with keyword 'Paris' ?
    '''
    response = waconvo.reference_data.locations.cities.get(keyword='Paris')
    print(response.data)
except ResponseError as error:
    raise error
