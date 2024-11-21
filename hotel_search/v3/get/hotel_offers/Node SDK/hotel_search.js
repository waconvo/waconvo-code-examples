const WAConvo = require("waconvo");

const waconvo = new WAConvo({
  clientId: "YOUR_API_KEY",
  clientSecret: "YOUR_API_SECRET",
});

async function main() {
  try {
    // Get list of available offers in specific hotels by hotel ids
    const response = await waconvo.shopping.hotelOffersSearch.get({
      hotelIds: "RTPAR001",
      adults: "2",
      checkInDate: "2023-10-10",
      checkOutDate: "2023-10-12",
    });

    console.log(response);
  } catch (error) {
    console.error(error);
  }
}

main();
