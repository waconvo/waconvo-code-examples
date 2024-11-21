# Install the Python library from https://pypi.org/project/waconvo
from waconvo import Client, ResponseError

waconvo = Client(
    client_id='YOUR_WACONVO_API_KEY',
    client_secret='YOUR_WACONVO_API_SECRET'
)

try:
    # Get list of available offers in specific hotels by hotel ids
    hotels_by_city = waconvo.shopping.hotel_offers_search.get(
        hotelIds='RTPAR001', adults='2', checkInDate='2023-10-01', checkOutDate='2023-10-04')
except ResponseError as error:
    raise error
