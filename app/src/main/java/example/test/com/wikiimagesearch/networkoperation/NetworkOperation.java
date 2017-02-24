package example.test.com.wikiimagesearch.networkoperation;

import android.os.AsyncTask;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

/**
 * Created by root on 23/2/17.
 */
public class NetworkOperation {
    private static OkHttpClient client = new OkHttpClient();

    /**
     * send the get request got the result in the string form
     * @param url
     * @param onOperationComplete
     */
    public static void doGetRequest(final String url , final OnOperationComplete onOperationComplete){
        new AsyncTask<Void , String, String>(){

            @Override
            protected String doInBackground(Void... params) {
                Request request = new Request.Builder()
                        .url(url)
                        .build();
                Response response = null;
                try {
                    response = client.newCall(request).execute();
                    return response.body().string();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onPostExecute(String s) {
                onOperationComplete.onOperationComplete(s);
                super.onPostExecute(s);
            }
        }.execute();
    }
}
