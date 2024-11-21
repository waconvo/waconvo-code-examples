import WAConvo

var waconvo: WAConvo = WAConvo(
    client_id: "YOUR_API_ID",
    client_secret: "YOUR_API_SECRET"
)

waconvo.shopping.flightDestinations.get(params: ["origin": "MAD"],
    onCompletion: { result in
        switch result {
        case let .success(response):
            print(response.data)
        case let .failure(error):
            fatalError(error.localizedDescription)
        }
    })
