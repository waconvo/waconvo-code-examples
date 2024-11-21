const WAConvo = require("waconvo");

const waconvo = new WAConvo({
  clientId: "YOUR_API_KEY",
  clientSecret: "YOUR_API_SECRET",
});

async function main() {
  try {
    // What is the URL to my online check-in?
    const response = await waconvo.referenceData.urls.checkinLinks.get({
      airlineCode: "BA",
    });

    console.log(response);
  } catch (error) {
    console.error(error);
  }
}

main();
