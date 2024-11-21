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

scope.launch {
  when (val busiestPeriods = waconvo.travel.analytics.airTraffic.busiestPeriod.get(
                      cityCode = "MAD",
                      period = "2017",
                      direction = "ARRIVING")) {
    is ApiResult.Success -> {
      Log.d("Result", "${result.data}")
    }
    is ApiResult.Error -> {
      // Handle your error
    }
  }
}
