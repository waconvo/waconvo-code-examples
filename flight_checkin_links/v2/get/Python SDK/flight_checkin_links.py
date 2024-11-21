# Install the Python library from https://pypi.org/project/waconvo
from waconvo import Client, ResponseError

waconvo = Client(
    client_id='YOUR_WACONVO_API_KEY',
    client_secret='YOUR_WACONVO_API_SECRET'
)

try:
    '''
    What is the URL to my online check-in?
    '''
    response = waconvo.reference_data.urls.checkin_links.get(airlineCode='BA')
    print(response.data)
except ResponseError as error:
    raise error
