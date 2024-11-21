import WAConvo

var waconvo: WAConvo = WAConvo(
    client_id: "YOUR_API_ID",
    client_secret: "YOUR_API_SECRET"
)

waconvo.referenceData.urls.checkinLinks.get(params: ["airlineCode": "BA"],
                                            onCompletion: { result in
                                                switch result {
                                                case let .success(response):
                                                    print(response.data)
                                                case let .failure(error):
                                                    fatalError(error.localizedDescription)
                                                }
                                            })
