package io.github.jamilelima.quotesapp;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import io.github.jamilelima.quotesapp.data.QuoteViewPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

  private QuoteViewPagerAdapter quoteViewPagerAdapter;
  private ViewPager viewPager;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    quoteViewPagerAdapter = new QuoteViewPagerAdapter(getSupportFragmentManager(), getFragments());
    viewPager = findViewById(R.id.viewPager);
    viewPager.setAdapter(quoteViewPagerAdapter);
  }

  private List<Fragment> getFragments() {
    List<Fragment> fragmentList = new ArrayList<>();

    for(int i = 0; i < 5; i++) {
      QuoteFragment quoteFragment = QuoteFragment.newInstance("Programmers are the best", "Jamile Lima");
      fragmentList.add(quoteFragment);
    }
    return fragmentList;
  }
}
