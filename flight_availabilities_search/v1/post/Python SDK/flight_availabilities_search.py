# Install the Python library from https://pypi.org/project/waconvo
from waconvo import Client, ResponseError

waconvo = Client(
    client_id='YOUR_WACONVO_API_KEY',
    client_secret='YOUR_WACONVO_API_SECRET'
)

try:
    body = {
        "originDestinations": [
            {
                "id": "1",
                "originLocationCode": "MIA",
                "destinationLocationCode": "ATL",
                "departureDateTime": {
                    "date": "2022-11-01"
                }
            }
        ],
        "travelers": [
            {
                "id": "1",
                "travelerType": "ADULT"
            }
        ],
        "sources": [
            "GDS"
        ]
    }

    response = waconvo.shopping.availability.flight_availabilities.post(body)
    print(response.data)
except ResponseError as error:
    raise error
