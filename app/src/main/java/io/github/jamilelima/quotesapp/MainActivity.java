package io.github.jamilelima.quotesapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import io.github.jamilelima.quotesapp.data.QuoteData;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    new QuoteData().getQuotes();
  }
}
