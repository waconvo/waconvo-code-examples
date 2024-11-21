import WAConvo

var waconvo: WAConvo = WAConvo(
    client_id: "YOUR_API_ID",
    client_secret: "YOUR_API_SECRET"
)

// Get a specific city or airport based on its id
waconvo.referenceData.location(locationId: "CMUC").get(onCompletion: { result in
        switch result {
        case let .success(response):
            print(response.data)
        case let .failure(error):
            fatalError(error.localizedDescription)
        }
    })
