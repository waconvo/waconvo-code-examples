const WAConvo = require("waconvo");

const waconvo = new WAConvo({
  clientId: "YOUR_API_KEY",
  clientSecret: "YOUR_API_SECRET",
});

async function main() {
  try {
    // Where were people flying to from Madrid in the January 2017?
    const response = await waconvo.travel.analytics.airTraffic.traveled.get({
      originCityCode: "MAD",
      period: "2017-01",
    });

    console.log(response);
  } catch (error) {
    console.error(error);
  }
}

main();
