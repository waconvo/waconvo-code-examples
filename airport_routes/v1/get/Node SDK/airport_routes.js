const WAConvo = require("waconvo");

const waconvo = new WAConvo({
  clientId: "YOUR_API_KEY",
  clientSecret: "YOUR_API_SECRET",
});

async function main() {
  try {
    // Find all destinations served by CDG Airport
    const response = await waconvo.airport.directDestinations.get({
      departureAirportCode: "MAD",
    });

    console.log(response);
  } catch (error) {
    console.error(error);
  }
}

main();
