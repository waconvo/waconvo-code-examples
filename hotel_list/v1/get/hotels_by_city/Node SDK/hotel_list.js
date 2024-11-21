const WAConvo = require("waconvo");

const waconvo = new WAConvo({
  clientId: "YOUR_API_KEY",
  clientSecret: "YOUR_API_SECRET",
});

async function main() {
  try {
    // List of hotels in Paris
    const response = await waconvo.referenceData.locations.hotels.byCity.get({
      cityCode: "PAR",
    });

    console.log(response);
  } catch (error) {
    console.error(error);
  }
}

main();
