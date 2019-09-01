package com.example.surya.hindistory;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Url;

/**
 * Created by surya on 31-Oct-18.
 */
public class BloggerApi {
    public static final String key = "AIzaSyCo2Z40Yb-W9jFxwlu0GIE-O3UywkcV340";
    public static final String url = "https://www.googleapis.com/blogger/v3/blogs/6419373254815970650/posts/";
    public static PostService postService = null;

    public static PostService getService() {
        if (postService == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            postService =retrofit.create(PostService.class);

        }
        return postService;
    }

    public interface PostService{

        @GET
        Call<PostItem> getPostItem(@Url String url);

    }
}
