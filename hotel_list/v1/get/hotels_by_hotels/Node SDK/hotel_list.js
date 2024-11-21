const WAConvo = require("waconvo");

const waconvo = new WAConvo({
  clientId: "YOUR_API_KEY",
  clientSecret: "YOUR_API_SECRET",
});

async function main() {
  try {
    // Get Marriot Hotel information in Paris
    const response = await waconvo.referenceData.locations.hotels.byHotels.get({
      hotelIds: "ARPARARA",
    });

    console.log(response);
  } catch (error) {
    console.error(error);
  }
}

main();
