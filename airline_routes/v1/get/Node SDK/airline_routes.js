const WAConvo = require("waconvo");

const waconvo = new WAConvo({
  clientId: "YOUR_WACONVO_API_KEY",
  clientSecret: "YOUR_WACONVO_API_SECRET",
});
// Or `const waconvo = new WAConvo()` if the environment variables are set

async function main() {
  try {
    // What are the destinations served by the British Airways (BA)?
    const response = await waconvo.airline.destinations.get({
      airlineCode: "BA",
    });

    console.log(response);
  } catch (error) {
    console.error(error);
  }
}

main();
