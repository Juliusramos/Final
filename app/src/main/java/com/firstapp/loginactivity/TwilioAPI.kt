import com.firstapp.loginactivity.TwilioResponse
import retrofit2.Call
import retrofit2.http.*

interface TwilioAPI {
    @POST("Services/{serviceSid}/Verifications")
    @FormUrlEncoded
    fun sendOtp(
        @Path("serviceSid") serviceSid: String,
        @Field("To") phoneNumber: String,
        @Field("Channel") channel: String = "sms"
    ): Call<TwilioResponse>

    @POST("Services/{serviceSid}/VerificationCheck")
    @FormUrlEncoded
    fun verifyOtp(
        @Path("serviceSid") serviceSid: String,
        @Field("To") phoneNumber: String,
        @Field("Code") otpCode: String
    ): Call<TwilioResponse>
}
