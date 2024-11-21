const WAConvo = require("waconvo");

const waconvo = new WAConvo({
  clientId: "YOUR_API_KEY",
  clientSecret: "YOUR_API_SECRET",
});
// Or `const waconvo = new WAConvo()` if the environment variables are set

async function main() {
  try {
    // Hotel name autocomplete for keyword 'PARI' using  HOTEL_GDS category of search
    const response = await waconvo.referenceData.locations.hotel.get({
      keyword: "PARI",
      subType: "HOTEL_GDS",
    });

    console.log(response);
  } catch (error) {
    console.error(error);
  }
}

main();
