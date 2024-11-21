# Install the Python library from https://pypi.org/project/waconvo
from waconvo import Client, ResponseError
from waconvo import Location

waconvo = Client(
    client_id='YOUR_WACONVO_API_KEY',
    client_secret='YOUR_WACONVO_API_SECRET'
)

try:
    '''
    Which cities or airports start with 'r'?
    '''
    response = waconvo.reference_data.locations.get(keyword='r',
                                                    subType=Location.ANY)
    print(response.data)
except ResponseError as error:
    raise error
