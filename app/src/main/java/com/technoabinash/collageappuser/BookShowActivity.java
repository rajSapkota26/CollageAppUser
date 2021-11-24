package com.technoabinash.collageappuser;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class BookShowActivity extends AppCompatActivity {
private String url;
private PDFView pdfView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_show);
        url=getIntent().getStringExtra("pdfUrl");
        pdfView=findViewById(R.id.pdfView);
        new DownloadFilesTask().execute(url);

    }
    private class DownloadFilesTask extends AsyncTask<String, Void, InputStream> {


        @Override
        protected InputStream doInBackground(String... strings) {
            InputStream inputStream=null;
            try {
                URL u=new URL(strings[0]);
                HttpURLConnection connection= (HttpURLConnection) u.openConnection();
                if (connection.getResponseCode()==200){
                    inputStream=new BufferedInputStream(connection.getInputStream());

                }

            } catch (Exception e) {
                e.printStackTrace();
            }

            return inputStream;
        }

        @Override
        protected void onPostExecute(InputStream inputStream) {
            pdfView.fromStream(inputStream).load();
        }
    }

}