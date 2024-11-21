# Install the Python library from https://pypi.org/project/waconvo
from ast import keyword
from waconvo import Client, ResponseError

waconvo = Client(
    client_id='YOUR_WACONVO_API_KEY',
    client_secret='YOUR_WACONVO_API_SECRET'
)

try:
    '''
    Hotel name autocomplete for keyword 'PARI' using HOTEL_GDS category of search
    '''
    response = waconvo.reference_data.locations.hotel.get(keyword='PARI', subType=[Hotel.HOTEL_GDS])
    print(response.data)
except ResponseError as error:
    raise error
