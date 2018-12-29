package io.github.jamilelima.quotesapp.data;

import io.github.jamilelima.quotesapp.model.Quote;
import java.util.ArrayList;

public interface QuoteListAsyncResponse {
  void processFinished(ArrayList<Quote> quotes);
}
