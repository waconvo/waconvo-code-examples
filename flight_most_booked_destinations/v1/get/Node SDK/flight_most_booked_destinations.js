const WAConvo = require("waconvo");

const waconvo = new WAConvo({
  clientId: "YOUR_API_KEY",
  clientSecret: "YOUR_API_SECRET",
});

async function main() {
  try {
    // Where were people flying to from Madrid in the August 2017?
    const response = await waconvo.travel.analytics.airTraffic.booked.get({
      originCityCode: "MAD",
      period: "2017-08",
    });

    console.log(response);
  } catch (error) {
    console.error(error);
  }
}

main();
