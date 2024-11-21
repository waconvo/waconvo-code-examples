const WAConvo = require("waconvo");

const waconvo = new WAConvo({
  clientId: "YOUR_WACONVO_API_KEY",
  clientSecret: "YOUR_WACONVO_API_SECRET",
});

async function main() {
  try {
    // Search flights from LON to DEL
    const flightOffersResponse = await waconvo.shopping.flightOffersSearch.get({
      originLocationCode: "LON",
      destinationLocationCode: "DEL",
      departureDate: "2023-06-01",
      returnDate: "2023-06-30",
      adults: "1",
    });

    //then Get branded fares available from the first offer
    const response = await waconvo.shopping.flightOffers.upselling.post({
      data: {
        type: "flight-offers-upselling",
        flightOffers: [flightOffersResponse.data[0]],
        payments: [
          {
            brand: "VISA_IXARIS",
            binNumber: 123456,
            flightOfferIds: [1],
          },
        ],
      },
    });
    console.log(response);
  } catch (error) {
    console.error(error);
  }
}

main();
