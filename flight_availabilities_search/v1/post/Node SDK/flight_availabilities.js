const WAConvo = require("waconvo");

const waconvo = new WAConvo({
  clientId: "YOUR_API_KEY",
  clientSecret: "YOUR_API_SECRET",
});

async function main() {
  try {
    const response =
      await waconvo.shopping.availability.flightAvailabilities.post({
        originDestinations: [
          {
            id: "1",
            originLocationCode: "MIA",
            destinationLocationCode: "ATL",
            departureDateTime: {
              date: "2022-11-01",
            },
          },
        ],
        travelers: [
          {
            id: "1",
            travelerType: "ADULT",
          },
        ],
        sources: ["GDS"],
      });
    console.log(response);
  } catch (error) {
    console.error(error);
  }
}

main();
