import WAConvo

var waconvo: WAConvo = WAConvo(
    client_id: "YOUR_API_ID",
    client_secret: "YOUR_API_SECRET"
)

waconvo.analytics.itineraryPriceMetrics.get(params: ["originIataCode": "MAD",
    "destinationIataCode": "CDG",
    "departureDate": "2022-01-15"],
    onCompletion: { result in
        switch result {
        case let .success(response):
            print(response.data)
        case let .failure(error):
            fatalError(error.localizedDescription)
        }
    })
