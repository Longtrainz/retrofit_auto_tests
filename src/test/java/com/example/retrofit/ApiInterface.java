package com.example.retrofit;

import com.example.retrofit.pojo.CreateUserRequest;
import com.example.retrofit.pojo.CreateUserResponse;
import com.example.retrofit.pojo.User;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiInterface {
    @GET("users/{id}")
    Call<User> getUser(@Path("id") String id);

    @POST("users")
    Call<CreateUserResponse> createUser(@Body CreateUserRequest body);
}
