import WAConvo

var waconvo: WAConvo = WAConvo(
    client_id: "YOUR_API_ID",
    client_secret: "YOUR_API_SECRET"
)

// Flight Most Booked Destinations
waconvo.travel.analytics.airTraffic.booked.get(params: ["originCityCode": "MAD",
                                                        "period": "2017-08"],
    onCompletion: { result in
        switch result {
        case let .success(response):
            print(response.data)
        case let .failure(error):
            fatalError(error.localizedDescription)
        }
    })
