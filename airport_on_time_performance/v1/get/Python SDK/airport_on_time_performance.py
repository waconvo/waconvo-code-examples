# Install the Python library from https://pypi.org/project/waconvo
from waconvo import Client, ResponseError

waconvo = Client(
    client_id='YOUR_WACONVO_API_KEY',
    client_secret='YOUR_WACONVO_API_SECRET'
)

try:
    '''
    Will there be a delay in the JFK airport on the 1st of December?
    '''
    response = waconvo.airport.predictions.on_time.get(
        airportCode='JFK', date='2021-12-01')
    print(response.data)
except ResponseError as error:
    raise error
