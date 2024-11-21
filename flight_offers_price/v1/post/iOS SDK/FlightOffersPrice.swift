import WAConvo
import Foundation
import SwiftyJSON

var waconvo: WAConvo = WAConvo(
    client_id: "YOUR_API_ID",
    client_secret: "YOUR_API_SECRET"
)

// Build the body from the first flight offer returned by
// Flight Offers Search API response array
let jsonString: String = """
{
   'data': {
    'type': 'flight-offers-pricing',
    'flightOffers': \(flightOffersSearchResponse.data[0])
}
"""

let dataFromString = jsonString.data(using: .utf8, allowLossyConversion: false)

do {
    let body: JSON = try JSON(data: dataFromString!)

    waconvo.shopping.flightOffers.pricing.post(body: body,
    onCompletion: { result in
        switch result {
        case let .success(response):
            print(response.data)
        case let .failure(error):
            fatalError(error.localizedDescription)
        }
    })
} catch _ as NSError {
    assertionFailure("JSON not valid")
}
