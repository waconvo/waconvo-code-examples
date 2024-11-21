# Install the Python library from https://pypi.org/project/waconvo
from waconvo import Client, ResponseError

waconvo = Client(
    client_id='YOUR_WACONVO_API_KEY',
    client_secret='YOUR_WACONVO_API_SECRET'
)

try:
    '''
    What were the busiest months for Madrid in 2022?
    '''
    response = waconvo.travel.analytics.air_traffic.busiest_period.get(
        cityCode='MAD', period='2017', direction='ARRIVING')
    print(response.data)
except ResponseError as error:
    raise error
