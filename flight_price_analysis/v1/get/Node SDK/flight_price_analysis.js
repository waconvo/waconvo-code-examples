const WAConvo = require("waconvo");

const waconvo = new WAConvo({
  clientId: "YOUR_API_KEY",
  clientSecret: "YOUR_API_SECRET",
});

async function main() {
  try {
    // Am I getting a good deal on this flight?
    const response = await waconvo.analytics.itineraryPriceMetrics.get({
      originIataCode: "MAD",
      destinationIataCode: "CDG",
      departureDate: "2022-01-13",
    });

    console.log(response);
  } catch (error) {
    console.error(error);
  }
}

main();
