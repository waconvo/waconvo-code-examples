import WAConvo

var waconvo: WAConvo = WAConvo(
    client_id: "YOUR_API_ID",
    client_secret: "YOUR_API_SECRET"
)

waconvo.travel.predictions.flightDelay.get(data: ["originLocationCode": "NCE",
    "destinationLocationCode": "IST",
    "departureDate": "2022-05-01",
    "departureTime": "18:20:00",
    "arrivalDate": "2022-05-01",
    "arrivalTime": "22:15:00",
    "aircraftCode": "321",
    "carrierCode": "TK",
    "flightNumber": "1816",
    "duration": "PT31H10M"],
    onCompletion: { result in
        switch result {
        case let .success(response):
            print(response.data)
        case let .failure(error):
            fatalError(error.localizedDescription)
        }
    })

