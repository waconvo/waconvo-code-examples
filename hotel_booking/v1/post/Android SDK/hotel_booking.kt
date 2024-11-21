// How to install the library at https://github.com/waconvo/waconvo-android

import com.waconvo.android.WAConvo
import com.waconvo.android.ApiResult
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import android.util.Log;

val job = SupervisorJob()
val scope = CoroutineScope(Dispatchers.Main + job)

val waconvo = WAConvo.Builder(context)
    .setClientId("REPLACE_BY_YOUR_API_KEY")
    .setClientSecret("REPLACE_BY_YOUR_API_SECRET")
    .build()

val body = "{" +
                            "  \"data\": {" +
                            "    \"offerId\": \"8MXZ1TKO5T\"," +
                            "    \"guests\": [" +
                            "      {" +
                            "        \"id\": 1," +
                            "        \"name\": {" +
                            "          \"title\": \"MR\"," +
                            "          \"firstName\": \"BOB\"," +
                            "          \"lastName\": \"SMITH\"" +
                            "        }," +
                            "        \"contact\": {" +
                            "          \"phone\": \"+33679278416\"," +
                            "          \"email\": \"bob.smith@email.com\"" +
                            "        }" +
                            "      }" +
                            "    ]," +
                            "    \"payments\": [" +
                            "      {" +
                            "        \"id\": 1," +
                            "        \"method\": \"creditCard\"," +
                            "        \"card\": {" +
                            "          \"vendorCode\": \"VI\"," +
                            "          \"cardNumber\": \"4151289722471370\"," +
                            "          \"expiryDate\": \"2022-08\"" +
                            "        }" +
                            "      }" +
                            "    ]," +
                            "    \"rooms\": [" +
                            "      {" +
                            "        \"guestIds\": [" +
                            "          1" +
                            "        ]," +
                            "        \"paymentId\": 1," +
                            "        \"specialRequest\": \"I will arrive at midnight\"" +
                            "      }\n" +
                            "    ]" +
                            "  }" +
                            "}"    

scope.launch {
  when (val booking = waconvo.booking.hotelBooking.post(body)) {
    is ApiResult.Success -> {
      Log.d("Result", "${result.data}")
    }
    is ApiResult.Error -> {
      // Handle your error
    }
  }
}
