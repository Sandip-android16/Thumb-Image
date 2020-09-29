package com.example.thumby_images;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    ImageView iv_youtube_thumnail,iv_play;
    String videoId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        try
        {
            videoId=extractYoutubeId("https://www.youtube.com/watch?v=bodYRp2aGqg");

            Log.e("VideoId is->","" + videoId);

            String img_url="http://img.youtube.com/vi/"+videoId+"/0.jpg"; // this is link which will give u thumnail image of that video

            // picasso jar file download image for u and set image in imagview

            Log.e("aaaa",img_url);
            Picasso.get()
                    .load(img_url)
                    .placeholder(R.drawable.ic_launcher_background)
                    .into(iv_youtube_thumnail);

        }
        catch (MalformedURLException e)
        {
            e.printStackTrace();
        }

    }
    public void init()
    {
        iv_youtube_thumnail=(ImageView)findViewById(R.id.img_thumnail);
        iv_play=(ImageView)findViewById(R.id.iv_play_pause);
    }

    // extract youtube video id and return that id
    // ex--> "http://www.youtube.com/watch?v=t7UxjpUaL3Y"
    // videoid is-->t7UxjpUaL3Y


    public String extractYoutubeId(String url) throws MalformedURLException {
        String query = new URL(url).getQuery();
        String[] param = query.split("&");
        String id = null;
        for (String row : param) {
            String[] param1 = row.split("=");
            if (param1[0].equals("v")) {
                id = param1[1];
            }
        }
        return id;
    }

}