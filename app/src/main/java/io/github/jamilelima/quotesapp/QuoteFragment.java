package io.github.jamilelima.quotesapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class QuoteFragment extends Fragment {

  public QuoteFragment() {
    // Required empty public constructor
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    View quoteView = inflater.inflate(R.layout.fragment_quote, container, false);


    return quoteView;
  }

}
