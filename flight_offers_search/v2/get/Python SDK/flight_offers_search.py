# Install the Python library from https://pypi.org/project/waconvo
from waconvo import Client, ResponseError

waconvo = Client(
    client_id='YOUR_WACONVO_API_KEY',
    client_secret='YOUR_WACONVO_API_SECRET'
)

try:
    '''
    Find the cheapest flights from SYD to BKK
    '''
    response = waconvo.shopping.flight_offers_search.get(
        originLocationCode='SYD', destinationLocationCode='BKK', departureDate='2022-07-01', adults=1)
    print(response.data)
except ResponseError as error:
    raise error
