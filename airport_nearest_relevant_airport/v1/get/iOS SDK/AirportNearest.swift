import WAConvo

var waconvo: WAConvo = WAConvo(
    client_id: "YOUR_API_ID",
    client_secret: "YOUR_API_SECRET"
)

// Airport Nearest Relevant (for London)
waconvo.referenceData.locations.airports.get(params: ["longitude": "49.0000",
    "latitude": "2.55"],
    onCompletion: { result in
        switch result {
        case let .success(response):
            print(response.data)
        case let .failure(error):
            fatalError(error.localizedDescription)
        }
    })
