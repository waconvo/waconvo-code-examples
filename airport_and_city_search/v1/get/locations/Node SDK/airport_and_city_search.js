const WAConvo = require("waconvo");

const waconvo = new WAConvo({
  clientId: "YOUR_API_KEY",
  clientSecret: "YOUR_API_KEY",
});

async function main() {
  try {
    // Retrieve information about the LHR airport?
    const response = await waconvo.referenceData.location("ALHR").get();

    console.log(response);
  } catch (error) {
    console.error(error);
  }
}

main();
