package helpers;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.filmapp.R;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import models.Movie;

public class MovieAdapter extends ArrayAdapter<Movie> {

    private Context context;
    private List<Movie> movies = new ArrayList<>() ;

    public MovieAdapter(@NonNull Context context, ArrayList<Movie> movies) {
        super(context, 0 ,movies);
        this.context = context;
        this.movies = movies;
    }


    private Bitmap getBitmapfromURL(String adresse) throws IOException {
        URL url = new URL(adresse);

        URLConnection connection=url.openConnection();

        HttpsURLConnection HCon=(HttpsURLConnection)connection;

        int ResCode=HCon.getResponseCode();

        System.out.println("Responce Code is = "+ResCode);

        Bitmap b=null;
        if(ResCode== HttpURLConnection.HTTP_OK)
        {
            InputStream ins=((URLConnection)HCon).getInputStream();
            b = BitmapFactory.decodeStream(ins);
        }
        return b;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItem = convertView;

        if(listItem==null)
            listItem= LayoutInflater.from(context).inflate(R.layout.list_item,parent,false);


        Movie currentMovie = this.movies.get(position);

        ImageView image = (ImageView)listItem.findViewById(R.id.imageView_poster);
        try {
            image.setImageBitmap(this.getBitmapfromURL(currentMovie.getmImageDrawable()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        TextView name = (TextView)listItem.findViewById(R.id.textView_name);
        name.setText(currentMovie.getmName());

        TextView realease = (TextView)listItem.findViewById(R.id.textView_release);
        realease.setText(currentMovie.getmRelease());


        return listItem;
    }
}
