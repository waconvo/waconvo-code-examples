const WAConvo = require("waconvo");

const waconvo = new WAConvo({
  clientId: "YOUR_API_KEY",
  clientSecret: "YOUR_API_SECRET",
});

async function main() {
  try {
    // Will there be a delay in the JFK airport on the 1st of September?
    const response = await waconvo.airport.predictions.onTime.get({
      airportCode: "JFK",
      date: "2022-09-01",
    });

    console.log(response);
  } catch (error) {
    console.error(error);
  }
}

main();
