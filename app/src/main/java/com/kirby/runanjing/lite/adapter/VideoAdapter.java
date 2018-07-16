package com.kirby.runanjing.lite.adapter;


import android.content.*;
import android.support.v7.widget.*;
import android.view.*;
import android.widget.*;
import com.bumptech.glide.*;
import com.kirby.runanjing.lite.*;
import com.kirby.runanjing.lite.activity.*;
import com.kirby.runanjing.lite.bean.*;
import java.util.*;

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.ViewHolder>
{
    private Context mContext;
    private List<Video> mVideoList;
    static class ViewHolder extends RecyclerView.ViewHolder
	{
        LinearLayout LinearLayout;
		CardView cardView;
		ImageView videoImage;
		TextView videoName;
        public ViewHolder(View view)
		{
            super(view);
			LinearLayout = (LinearLayout)view.findViewById(R.id.LinearLayout);
            cardView = (CardView) view.findViewById(R.id.cardview);
			videoImage = (ImageView) view.findViewById(R.id.video_image);
            videoName = (TextView) view.findViewById(R.id.video_text);
        }
    }

    public VideoAdapter(List<Video> videolist)
	{
        mVideoList = videolist;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
	{
        if (mContext == null)
		{
            mContext = parent.getContext();
        }
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_video, parent, false);
		final ViewHolder holder=new ViewHolder(view);
		holder.LinearLayout.setOnClickListener(new View.OnClickListener(){
				@Override
				public void onClick(View v)
				{
					int position=holder.getAdapterPosition();
					Video video=mVideoList.get(position);
					Intent in = new Intent();        
					in.setAction("android.intent.action.VIEW");    
					in.putExtra("url",video.getAv());   
					mContext.startActivity(in); 
				}
			}
		);
		return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position)
	{
        Video vi = mVideoList.get(position);
        holder.videoName.setText(vi.getName());
        Glide
			.with(mContext)
			.load(vi.getImageUrl())
			.placeholder(R.drawable.ic_download)
			.error(R.drawable.ic_close_circle_outline)
			.into(holder.videoImage);
	}

    @Override
    public int getItemCount()
	{
        return mVideoList.size();
    }
}
