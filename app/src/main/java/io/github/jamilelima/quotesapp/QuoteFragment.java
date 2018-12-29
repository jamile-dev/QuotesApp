package io.github.jamilelima.quotesapp;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class QuoteFragment extends Fragment {

  public QuoteFragment() {
    // Required empty public constructor
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    View quoteView = inflater.inflate(R.layout.fragment_quote, container, false);
    TextView quoteText = quoteView.findViewById(R.id.quoteText);
    TextView quoteAuthorName = quoteView.findViewById(R.id.authorName);
    CardView cardView = quoteView.findViewById(R.id.cardContainer);

    if (getArguments() != null) {
      String quote = getArguments().getString("quote");
      String author = getArguments().getString("author");
      quoteText.setText(quote);
      quoteAuthorName.setText(" - " + author);
    } else {
      cardView.setVisibility(View.GONE);
      quoteAuthorName.setText(R.string.error_message);
    }

    return quoteView;
  }

  public static QuoteFragment newInstance(String quote, String author) {
    QuoteFragment fragment = new QuoteFragment();
    Bundle bundle = new Bundle();
    bundle.putString("quote", quote);
    bundle.putString("author", author);
    fragment.setArguments(bundle);
    return fragment;
  }
}
