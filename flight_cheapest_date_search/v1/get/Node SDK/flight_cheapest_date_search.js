const WAConvo = require("waconvo");

const waconvo = new WAConvo({
  clientId: "YOUR_API_KEY",
  clientSecret: "YOUR_API_SECRET",
});

async function main() {
  try {
    // Find cheapest dates from Madrid to Munich
    const response = await waconvo.shopping.flightDates.get({
      origin: "MAD",
      destination: "MUC",
    });

    console.log(response);
  } catch (error) {
    console.error(error);
  }
}

main();
