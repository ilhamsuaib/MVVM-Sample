package id.ilhamsuaib.mvvm.di

import id.ilhamsuaib.mvvm.data.remote.ApiService
import id.ilhamsuaib.mvvm.utils.Constants
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by @ilhamsuaib on 06/12/18.
 * github.com/ilhamsuaib
 */

val dataModule = module {

    single(name = Constants.DI_ARTICLES_RETROFIT) {
        createRetrofit()
    }

    single(name = Constants.DI_API_SERVICE) {
        createApiService<ApiService>(get(name = Constants.DI_API_SERVICE))
    }
}

inline fun <reified T> createApiService(retrofit: Retrofit): T {
    return retrofit.create(T::class.java)
}

private fun createRetrofit(): Retrofit {
    return Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
        .client(getOkHttpClient())
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
        .build()
}

private fun getOkHttpClient(): OkHttpClient {
    val timeOut = 60L
    val apiKey = "1a4b899d7454428da0d33bc562ebd8ed"
    return OkHttpClient.Builder()
        .connectTimeout(timeOut, TimeUnit.SECONDS)
        .readTimeout(timeOut, TimeUnit.SECONDS)
        .addInterceptor(HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        })
        .addInterceptor { chain ->
            val req = chain.request()
                .newBuilder()
                .addHeader("X-Api-Key", apiKey)
                .build()
            return@addInterceptor chain.proceed(req)
        }
        .build()
}
