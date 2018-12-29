package io.github.jamilelima.quotesapp;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import io.github.jamilelima.quotesapp.data.QuoteData;
import io.github.jamilelima.quotesapp.data.QuoteListAsyncResponse;
import io.github.jamilelima.quotesapp.data.QuoteViewPagerAdapter;

import io.github.jamilelima.quotesapp.model.Quote;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

  private QuoteViewPagerAdapter quoteViewPagerAdapter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    quoteViewPagerAdapter = new QuoteViewPagerAdapter(getSupportFragmentManager(), getFragments());
    ViewPager viewPager = findViewById(R.id.viewPager);
    viewPager.setAdapter(quoteViewPagerAdapter);
  }

  private List<Fragment> getFragments() {
    final List<Fragment> fragmentList = new ArrayList<>();

    new QuoteData().getQuotes(new QuoteListAsyncResponse() {
      @Override
      public void processFinished(ArrayList<Quote> quotes) {
        for(int i = 0; i < quotes.size(); i++) {
          String quote = quotes.get(i).getQuote();
          String authorName = quotes.get(i).getAuthor();
          QuoteFragment quoteFragment = QuoteFragment.newInstance(quote, authorName);
          fragmentList.add(quoteFragment);
        }
        quoteViewPagerAdapter.notifyDataSetChanged(); // Say to adapter: Hey the data changed!!!
      }
    });
    return fragmentList;
  }
}
