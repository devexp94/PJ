package com.init.panj.adapter;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.init.panj.R;
import com.init.panj.activity.MainActivity;
import com.init.panj.clases.CustomImageView;
import com.init.panj.clases.ProgressBarCircular;
import com.init.panj.fragments.MainFragment;
import com.init.panj.fragments.New_Video_home;
import com.init.panj.fragments.Video_home;
import com.init.panj.model.ItemBean;
import com.init.panj.model.UrlBean;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;

import java.util.ArrayList;
/**
 * Created by deepak on 10/19/2015.
 */
public class Movies_itemAdap extends RecyclerView.Adapter<Movies_itemAdap.MyViewHolder> {
    ArrayList<ItemBean> list;
    ArrayList<ItemBean> urllist;
    MainActivity act;
    Intent intent;
    int coun=0;
    String tag;
   MainFragment mainFragment;
    //Fragment frag[]={newr SecondAct(),newr Yutube(),newr Audio(),newr Ring(),newr Wallpaper(),newr Schedule(),newr ContactUs()};
    // String color[] = {"#039be5","#ff6d00","#cddc39","#448aff","#42a5f5","#00bcd4","#8bc34a","#ffc107"};
    public Movies_itemAdap(MainActivity mainActivity, ArrayList<ItemBean> mainlist, ArrayList<ItemBean> url2, String tag) {
        act = mainActivity;
        list = mainlist;
        urllist=url2;
this.tag=tag;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new MyViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.trailer_item, viewGroup, false));
    }


    @Override
    public void onBindViewHolder(final MyViewHolder myViewHolder, final int i) {

        final ItemBean itemBean = list.get(i);
        // myViewHolder.img.setImageResource(itemBean.displayicon);
        // Picasso.with(myViewHolder.itemView.getContext()).load(itemBean.tredcover).placeholder(R.mipmap.musicload).fit().into(myViewHolder.img);
      //  myViewHolder.title.setText(itemBean.tredname);
      //  myViewHolder.subt.setText(itemBean.treddesp);
        myViewHolder.img.scaledImage(itemBean.tredcover);
        myViewHolder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // act.replaceFragment(abc Audio(), itemBean.id, itemBean.tredcover, itemBean.tredname, itemBean.treddesp, "http://52.74.238.77/savaan_nirmolak/albumsong.php", "");
                /*Intent it=new Intent(act,PlayVideo.class);
                it.putExtra("list",new UrlBean(urllist));
                it.putExtra("position",i);
                it.putExtra("id",itemBean.id);
                act.startActivity(it);*/
                MainActivity.allurl=urllist;
                act.replaceFragment(new New_Video_home(),urllist.get(i).BT200,itemBean.tredcover,tag+"s", itemBean.tredname + " " + itemBean.treddesp, itemBean.id, myViewHolder.getAdapterPosition());
            }
        });
        /*ImageLoader.getInstance().loadImage(itemBean.tredcover, new  SimpleImageLoadingListener() {
            @Override
            public void onLoadingStarted(String imageUri, View view) {
                myViewHolder.img.setImageResource(R.drawable.logo_fade);
            }

            @Override
            public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {

                super.onLoadingComplete(imageUri, view, loadedImage);
                myViewHolder.img.setImageBitmap(loadedImage);

            }
        });*/
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
      //  TextView title, subt;
        CustomImageView img;
      //  ProgressBarCircular pb;
        FrameLayout fm;
        public MyViewHolder(View itemView) {
            super(itemView);
            img = (CustomImageView) itemView.findViewById(R.id.trailerimage);
            Display mDisplay = act.getWindowManager().getDefaultDisplay();
            final int width = mDisplay.getWidth();
            final int height = mDisplay.getHeight();
            int framewitdh = width / 3;
            fm = (FrameLayout) itemView.findViewById(R.id.mframe);
            RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(framewitdh, (int) act.getResources().getDimension(R.dimen.moviescontainer_height));
            fm.setLayoutParams(lp);

        }
    }
}
