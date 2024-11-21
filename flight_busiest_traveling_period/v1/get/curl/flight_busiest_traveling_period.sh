# Authentication: $WACONVO_CLIENT_ID & $WACONVO_CLIENT_SECRET can be defined
# in your environmental variables or directly in your script
ACCESS_TOKEN=$(curl -H "Content-Type: application/x-www-form-urlencoded" \
https://test.api.waconvo.com/v1/security/oauth2/token \
-d "grant_type=client_credentials&client_id=$WACONVO_CLIENT_ID&client_secret=$WACONVO_CLIENT_SECRET" \
| grep access_token | sed 's/"access_token": "\(.*\)"\,/\1/' | tr -d '[:space:]')

curl -X GET "https://test.api.waconvo.com/v1/travel/analytics/air-traffic/traveled?originCityCode=MAD&period=2017-01&direction=ARRIVING" -H "Authorization: Bearer $ACCESS_TOKEN" -k