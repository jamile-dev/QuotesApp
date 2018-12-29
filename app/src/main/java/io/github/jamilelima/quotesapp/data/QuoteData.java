package io.github.jamilelima.quotesapp.data;

import android.util.Log;
import com.android.volley.Request.Method;
import com.android.volley.Response;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import io.github.jamilelima.quotesapp.controller.AppController;
import io.github.jamilelima.quotesapp.model.Quote;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class QuoteData {

  private ArrayList<Quote> quoteArrayList = new ArrayList<>();

  public void getQuotes(final QuoteListAsyncResponse callBack) {
    String url = "https://bit.ly/2Slp2JU";

    JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Method.GET, url,
        new Listener<JSONArray>() {
          @Override
          public void onResponse(JSONArray response) {
            for (int i = 0; i < response.length(); i++) {
              try {
                JSONObject quoteObject = response.getJSONObject(i);
                Quote quote = new Quote();
                quote.setQuote(quoteObject.getString("quote"));
                quote.setAuthor(quoteObject.getString("name"));
                quoteArrayList.add(quote);
              } catch (JSONException e) {
                e.printStackTrace();
              }
            }
            if (callBack != null) callBack.processFinished(quoteArrayList);

          }
        }, new Response.ErrorListener() {
            @Override
              public void onErrorResponse(VolleyError error) {
                Log.d("ERROR: ", "MESSAGE: " + error);
              }
    });
    AppController.getInstance().addToRequestQueue(jsonArrayRequest);
  }
}
