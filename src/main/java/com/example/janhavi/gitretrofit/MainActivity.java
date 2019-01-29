package com.example.janhavi.gitretrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView= findViewById(R.id.list_item);

        Retrofit.Builder builder = new Retrofit.Builder();
        builder.baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create()); //serialization to and fron JSON

        Retrofit retrofit = builder.build();
        GitClient gitClient = retrofit.create(GitClient.class);
        Call<List<GitRepo>> call = gitClient.reposForUser("JanhaviDahihande");

        call.enqueue(new Callback<List<GitRepo>>() {
            @Override
            public void onResponse(Call<List<GitRepo>> call, Response<List<GitRepo>> response) {
                List<GitRepo> repos = response.body();
                listView.setAdapter(new GitRepoAdapter(MainActivity.this, repos));
            }

            @Override
            public void onFailure(Call<List<GitRepo>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Failure", Toast.LENGTH_LONG).show();
            }
        });
    }
}
