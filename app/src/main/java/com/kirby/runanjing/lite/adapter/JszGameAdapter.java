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

public class JszGameAdapter extends RecyclerView.Adapter<JszGameAdapter.ViewHolder>
{

	private List<Console> mJszGameList;
	private Context mContext;
	static class ViewHolder extends RecyclerView.ViewHolder
	{
        LinearLayout LinearLayout;
		CardView cardView;
        ImageView gameImage;
        TextView gameName;
        public ViewHolder(View view)
		{
            super(view);
			LinearLayout = (LinearLayout)view.findViewById(R.id.LinearLayout);
            cardView = (CardView) view.findViewById(R.id.cardview);
			gameImage = (ImageView) view.findViewById(R.id.console_image);
            gameName = (TextView) view.findViewById(R.id.console_text);
        }
    }

    public JszGameAdapter(List<Console> jszgamelist)
	{
        mJszGameList = jszgamelist;
    }
	@Override
	public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
	{
		if (mContext == null)
		{
            mContext = parent.getContext();
        }
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_console, parent, false);
		final ViewHolder holder=new ViewHolder(view);
		holder.LinearLayout.setOnClickListener(new View.OnClickListener(){
				@Override
				public void onClick(View v)
				{
					int position=holder.getAdapterPosition();
					Console console=mJszGameList.get(position);
					Intent in=new Intent(mContext, JszActivity.class);
					String  input=console.getName().toString();	
					MainActivity m=new MainActivity();
					//m.otherReplaceFragment(new JszFragment());
					mContext.startActivity(in);
					SharedPreferences.Editor t=mContext.getSharedPreferences("string", 0).edit();
					t.putString("金手指_游戏", input);
					t.apply();
				}
			}
		);
		return holder;
	}

	@Override
	public void onBindViewHolder(ViewHolder holder, int position)
	{
		Console co = mJszGameList.get(position);
        holder.gameName.setText(co.getName());
        Glide.with(mContext).load(co.getImageUrl()).into(holder.gameImage);
	}

	@Override
	public int getItemCount()
	{
		return mJszGameList.size();
	}
	
}
