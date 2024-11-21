import WAConvo

var waconvo: WAConvo = WAConvo(
    client_id: "YOUR_API_ID",
    client_secret: "YOUR_API_SECRET"
)

// Flight Busiest Traveling Period
waconvo.travel.analytics.airTraffic.busiestPeriod.get(params: ["cityCode": "MAD",
    "period": "2017",
    "direction": "ARRIVING"],
    onCompletion: { result in
        switch result {
        case let .success(response):
            print(response.data)
        case let .failure(error):
            fatalError(error.localizedDescription)
        }
    })
