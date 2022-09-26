package com.example.retrofit.tests;

import com.example.retrofit.ApiClientHelper;
import com.example.retrofit.ApiInterface;
import com.example.retrofit.pojo.CreateUserRequest;
import com.example.retrofit.pojo.CreateUserResponse;
import com.example.retrofit.pojo.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import retrofit2.Response;

import java.io.IOException;

@SpringBootTest
public class RetrofitTests {

    ApiInterface service = ApiClientHelper.getClient().create(ApiInterface.class);

    @Test
    @DisplayName("GET - GET USER BY ID")
    void checkGetUser() throws IOException {
        Response<User> response = service.getUser("3").execute();
        User user = service.getUser("3").execute().body();

        System.out.println("User: " + user);

        System.out.println(response.body());
        Assertions.assertTrue(response.isSuccessful());
        Assertions.assertEquals(3, response.body().data().id());
        Assertions.assertEquals("Emma", response.body().data().firstName());
        Assertions.assertEquals("Wong", response.body().data().lastName());

    }

    @Test
    @DisplayName("POST - CREATE USER")
    void checkUserCreation() throws IOException {
        Response<CreateUserResponse> responseCreateUser = service.createUser(getRequestBody()).execute();
        System.out.println(getRequestBody());

        System.out.println(responseCreateUser.body());
        Assertions.assertTrue(responseCreateUser.isSuccessful());
        Assertions.assertEquals(201, responseCreateUser.code());
        Assertions.assertEquals("morpheus", responseCreateUser.body().name());
        Assertions.assertEquals("leader", responseCreateUser.body().job());
    }

    public CreateUserRequest getRequestBody() {
        CreateUserRequest requestNewUserData = new CreateUserRequest();
        requestNewUserData.job("leader");
        requestNewUserData.name("morpheus");

        return requestNewUserData;
    }
}
