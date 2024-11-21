# Install the Python library from https://pypi.org/project/waconvo
from waconvo import Client, ResponseError

waconvo = Client(
    client_id='YOUR_WACONVO_API_KEY',
    client_secret='YOUR_WACONVO_API_SECRET'
)

try:
    '''
    What travelers think about this hotel?
    '''
    response = waconvo.e_reputation.hotel_sentiments.get(hotelIds = 'ADNYCCTB')
    print(response.data)
except ResponseError as error:
    raise error
