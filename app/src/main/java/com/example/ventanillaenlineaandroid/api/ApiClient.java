// ApiClient.java
package com.example.ventanillaenlineaandroid.api;

import com.example.ventanillaenlineaandroid.HttpResponse;
import com.example.ventanillaenlineaandroid.LogIn;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.POST;

public class ApiClient {

    public interface Service {
        @POST("validar-usuario")
        Call<HttpResponse> login(@Body LogIn login);
    }

    private final Retrofit retrofit;
    private Service service;
    private static final ApiClient apiClient = new ApiClient();

    public static ApiClient getInstance(){
        return apiClient;
    }

    private ApiClient(){
        // Configurar el interceptor de logging
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(logging)
                .build();

        retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2:8080/VentanillaEnLinea/ServiciosNode/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
    }

    public Service getService(){
        if(service == null) {
            service = retrofit.create(Service.class);
        }
        return service;
    }
}
