package com.nosoroce_czarne.foruminnowacji;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.LayoutInflater;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.util.Log;


import com.nostra13.universalimageloader.cache.memory.impl.WeakMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;


public class CustomListAdapter  extends ArrayAdapter<Event> {
    private static final String TAG = "CustomListAdapter";

    private Context context;
    private int resource;
    private int lastPosition = -1;
    private static class ViewHolder
    {
        ImageView imageURL;
        TextView eventTitle;
        TextView eventPlace;
        TextView eventTime;
    }

    /**
     *Default constructor for CustomListAdapter
     * @param context
     * @param resource
     * @param objects
     */


    public CustomListAdapter(Context context, int resource, ArrayList<Event> objects)
    {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
    }
    @NonNull
    @Override
    public View getView (int position, View convertView, ViewGroup parent)
    {
        setupImageLoader();
    //get the persons information
    String eventTitleString = getItem(position).getEventTitle();
    String eventTimeString = getItem(position).getEventTime();
    String eventPlaceString = getItem(position).getEventPlace();
    String imageUrl = getItem(position).getEventImageURL();
    //String eventTitleString = "DUPA";
    //String eventPlaceString = "DUPA";
    //String eventTimeString = "DUPA";
    //String imageUrl = "@drawable/hehe";
        try{
        //create the view result for showing the animation
        final View result;

        //ViewHolder object
        ViewHolder holder;

        if(convertView == null){
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(resource, parent, false);
            holder= new ViewHolder();
            holder.eventTitle = (TextView) convertView.findViewById(R.id.activity_title);
            holder.imageURL = (ImageView) convertView.findViewById(R.id.activity_img);
            holder.eventPlace = (TextView) convertView.findViewById(R.id.activity_place);
            holder.eventTime = (TextView) convertView.findViewById(R.id.activity_time);

            result = convertView;

            convertView.setTag(holder);
        }
        else{
            holder = (ViewHolder) convertView.getTag();
            result = convertView;
        }


//        Animation animation = AnimationUtils.loadAnimation(context,
//                (position > lastPosition) ? R.anim.load_down_anim : R.anim.load_up_anim);
//        result.startAnimation(animation);
//        lastPosition = position;

        holder.eventTitle.setText(eventTitleString);
        holder.eventPlace.setText(eventPlaceString);
        holder.eventTime.setText(eventTimeString);

        //create the imageloader object
        ImageLoader imageLoader = ImageLoader.getInstance();

        int defaultImage = context.getResources().getIdentifier("@drawable/image_failed",null,context.getPackageName());

        //create display options
        DisplayImageOptions options = new DisplayImageOptions.Builder().cacheInMemory(true)
                .cacheOnDisc(true).resetViewBeforeLoading(true)
                .showImageForEmptyUri(defaultImage)
                .showImageOnFail(defaultImage)
                .showImageOnLoading(defaultImage).build();

        //download and display image from url
        imageLoader.displayImage(imageUrl, holder.imageURL, options);

        return convertView;
    }catch (IllegalArgumentException e){
        Log.e(TAG, "getView: IllegalArgumentException: " + e.getMessage() );
        return convertView;
    }

}

    private void setupImageLoader(){
        // UNIVERSAL IMAGE LOADER SETUP
        DisplayImageOptions defaultOptions = new DisplayImageOptions.Builder()
                .cacheOnDisc(true).cacheInMemory(true)
                .imageScaleType(ImageScaleType.EXACTLY)
                .displayer(new FadeInBitmapDisplayer(300)).build();

        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(
                context)
                .defaultDisplayImageOptions(defaultOptions)
                .memoryCache(new WeakMemoryCache())
                .discCacheSize(100 * 1024 * 1024).build();

        ImageLoader.getInstance().init(config);
        // END - UNIVERSAL IMAGE LOADER SETUP
    }
}
