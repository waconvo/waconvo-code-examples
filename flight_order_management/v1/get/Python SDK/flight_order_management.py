# Install the Python library from https://pypi.org/project/waconvo
from waconvo import ResponseError, Client

waconvo = Client(
    client_id='YOUR_WACONVO_API_KEY',
    client_secret='YOUR_WACONVO_API_SECRET'
)

try:
    '''
    # Retrieve the flight order based on it's id
    '''
    response = waconvo.booking.flight_order('MlpZVkFMfFdBVFNPTnwyMDE1LTExLTAy').get()
    print(response.data)
except ResponseError as error:
    raise error
