const WAConvo = require("waconvo");

const waconvo = new WAConvo({
  clientId: "YOUR_API_KEY",
  clientSecret: "YOUR_API_SECRET",
});

async function main() {
  try {
    const flightOffersResponse = await waconvo.shopping.flightOffersSearch.get({
      originLocationCode: "SYD",
      destinationLocationCode: "BKK",
      departureDate: "2022-08-01",
      adults: "2",
    });
    const response = await waconvo.shopping.flightOffers.prediction.post(
      flightOffersResponse
    );
    console.log(response.data);
  } catch (error) {
    console.error(error);
  }
}

main();
