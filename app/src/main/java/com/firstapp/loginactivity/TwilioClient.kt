import okhttp3.Credentials
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object TwilioClient {
    private const val BASE_URL = "https://verify.twilio.com/v2/"  // FIXED
    private const val ACCOUNT_SID = "ACefcdc33e340d379556d47eeeefbaaa7e"
    private const val AUTH_TOKEN = "226fd6daf9a5c6a8d7d4720c6a48c3c9"

    private val client = OkHttpClient.Builder()
        .addInterceptor { chain ->
            val request = chain.request().newBuilder()
                .header("Authorization", Credentials.basic(ACCOUNT_SID, AUTH_TOKEN))
                .build()
            chain.proceed(request)
        }
        .addInterceptor(HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        })
        .build()

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()

    val api: TwilioAPI = retrofit.create(TwilioAPI::class.java)
}
