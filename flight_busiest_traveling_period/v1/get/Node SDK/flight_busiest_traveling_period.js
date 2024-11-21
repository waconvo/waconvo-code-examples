const WAConvo = require("waconvo");

const waconvo = new WAConvo({
  clientId: "YOUR_API_KEY",
  clientSecret: "YOUR_API_SECRET",
});

async function main() {
  try {
    // What were the busiest months for Madrid in 2017?
    const response =
      await waconvo.travel.analytics.airTraffic.busiestPeriod.get({
        cityCode: "MAD",
        period: "2017",
        direction: WAConvo.direction.arriving,
      });

    console.log(response);
  } catch (error) {
    console.error(error);
  }
}

main();
