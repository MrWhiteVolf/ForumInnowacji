package com.nosoroce_czarne.foruminnowacji.util;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.LayoutInflater;
import android.util.Log;

import com.nosoroce_czarne.foruminnowacji.R;
import com.nosoroce_czarne.foruminnowacji.model.Event;
import com.nostra13.universalimageloader.cache.memory.impl.WeakMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;

import java.util.ArrayList;
import java.util.List;


public class CustomListAdapter  extends ArrayAdapter<Event> {
    private static final String TAG = "CustomListAdapter";

    private Context context;
    private int resource;
    private int lastPosition = -1;
    private static class ViewHolder {
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


    public CustomListAdapter(Context context, int resource, List<Event> objects)
    {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView (int position, View convertView, ViewGroup parent) {
    //get the persons information
    String eventTitleString = getItem(position).getEventTitle();
    String eventTimeString = getItem(position).getEventTime();
    String eventPlaceString = getItem(position).getEventPlace();
    String imageUrl = getItem(position).getEventImageURL();
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
        Log.d("AA: ", eventTitleString+"----");

        int imageResource = context.getResources().getIdentifier(imageUrl, null, context.getPackageName());
        holder.imageURL.setImageResource(imageResource);

            //create the imageloader object

        return convertView;
    } catch (IllegalArgumentException e){
            Log.e(TAG, "getView: IllegalArgumentException: " + e.getMessage() );
            return convertView;
        }
    }
}
