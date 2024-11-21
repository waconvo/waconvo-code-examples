const WAConvo = require("waconvo");

const waconvo = new WAConvo({
  clientId: "YOUR_API_KEY",
  clientSecret: "YOUR_API_SECRET",
});

async function main() {
  try {
    // Which cities or airports start with ’r'?
    const response = await waconvo.referenceData.locations.get({
      keyword: "r",
      subType: WAConvo.location.any,
    });

    console.log(response);
  } catch (error) {
    console.error(error);
  }
}

main();
