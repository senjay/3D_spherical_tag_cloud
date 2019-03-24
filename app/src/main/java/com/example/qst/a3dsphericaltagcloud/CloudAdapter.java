package com.example.qst.a3dsphericaltagcloud;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.moxun.tagcloudlib.view.TagsAdapter;

import java.util.ArrayList;

public class CloudAdapter extends TagsAdapter {

    private ArrayList<String> list;
    private ArrayList<Integer> precentlist=new ArrayList<>();
    int max=-1;
    int maxposition=-1;
    int newposition=-1;
    public CloudAdapter(ArrayList<String> list) {
        this.list = list;
        for (int i = 0; i < list.size(); i++) {
            precentlist.add((int) (Math.random()*100));
            if(precentlist.get(i)>max)
            {
                max=precentlist.get(i);
                maxposition=i;
            }
        }
        newposition=(int) (Math.random()*list.size());
        newposition= (newposition==maxposition)? maxposition-1: newposition;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public View getView(Context context, int position, ViewGroup parent) {
        View v= LayoutInflater.from(context).inflate(R.layout.tag_layout,null,false);
        TextView tv=v.findViewById(R.id.textView);
        TextView ptv=v.findViewById(R.id.textView2);
        ImageView iv =v.findViewById(R.id.imageView);
        if(position==maxposition)
        {
            iv.setImageResource(R.drawable.p3);
            ptv.setText(precentlist.get(position)+"%"+"\n 最匹配");
        }
        else if(position==newposition)
        {
            iv.setImageResource(R.drawable.p2);
            ptv.setText(precentlist.get(position)+"%"+"\n 最新人");
        }
        else
        {
            iv.setImageResource(R.drawable.p1);
            ptv.setText(precentlist.get(position)+"%");
        }
        tv.setText(getItem(position).toString());
        tv.setSelected(true);//跑马灯
        tv.setTextSize(8);
        ptv.setTextSize(5);
        return v;
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getPopularity(int position) {
        return 1;
    }

    @Override
    public void onThemeColorChanged(View view, int themeColor) {

    }
}
