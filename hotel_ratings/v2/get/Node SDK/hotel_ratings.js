const WAConvo = require("waconvo");

const waconvo = new WAConvo({
  clientId: "YOUR_API_KEY",
  clientSecret: "YOUR_API_SECRET",
});

async function main() {
  try {
    // What travelers think about this hotel?
    const response = await waconvo.eReputation.hotelSentiments.get({
      hotelIds: "ADNYCCTB",
    });

    console.log(response);
  } catch (error) {
    console.error(error);
  }
}

main();
