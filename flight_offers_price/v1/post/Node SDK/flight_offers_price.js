const WAConvo = require("waconvo");

const waconvo = new WAConvo({
  clientId: "YOUR_API_KEY",
  clientSecret: "YOUR_API_SECRET",
});

async function main() {
  try {
    // Confirm availability and price from MAD to ATH in summer 2024
    const flightOffersResponse = await waconvo.shopping.flightOffersSearch.get({
      originLocationCode: "MAD",
      destinationLocationCode: "ATH",
      departureDate: "2024-07-01",
      adults: "1",
    });

    const response = await waconvo.shopping.flightOffers.pricing.post(
      {
        data: {
          type: "flight-offers-pricing",
          flightOffers: [flightOffersResponse.data[0]],
        },
      },
      { include: "credit-card-fees,detailed-fare-rules" }
    );
    console.log(response);
  } catch (error) {
    console.error(error);
  }
}

main();
