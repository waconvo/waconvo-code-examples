import WAConvo

var waconvo: WAConvo = WAConvo(
    client_id: "YOUR_API_ID",
    client_secret: "YOUR_API_SECRET"
)

/// Find all the cities and airports starting by the keyword 'LON'
waconvo.referenceData.locations.get(params: ["subType": "AIRPORT,CITY",
    "keyword": "LON"],
    onCompletion: { result in
        switch result {
        case let .success(response):
            print(response.data)
        case let .failure(error):
            fatalError(error.localizedDescription)
        }
    })
