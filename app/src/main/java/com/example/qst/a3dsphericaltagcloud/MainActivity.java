package com.example.qst.a3dsphericaltagcloud;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.moxun.tagcloudlib.view.TagCloudView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    TagCloudView tcvTags;//标签云对象
    ArrayList<String> list = new ArrayList<>();//标签云数据的集合

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);
        for (int i = 0; i < 40; i++) {
            list.add((char)(i%26+(int)'A')+"");
        }
        list.add("你说，一个人可以走多远呢");
        list.add("9Crimes");
        list.add("Happy Now");
        list.add("Sound Of Silence");
        list.add("Way Back Into Love");
        list.add("难离难舍想抱紧些");
        list.add("我转过我的脸 不让你看见");
        list.add("难收的覆水将感情慢慢荡开去");
        list.add("仰望月夜 眉间的寂寞");
        list.add("千年的武功");
        list.add("风里飘雪的花");
        list.add("如真 如假 ");
        list.add("还记得二十年前");
        list.add("谁愿承受岁月无情的变迁");
        list.add("Dream It Possible");
        tcvTags = findViewById(R.id.tagcloud);

        //点击事件
        tcvTags.setOnTagClickListener(new TagCloudView.OnTagClickListener() {
            @Override
            public void onItemClick(ViewGroup parent, View view, int position) {

                //Toast.makeText(MainActivity.this,"点击了："+list.get(position), Toast.LENGTH_SHORT).show();
                //解决小米手机bug
                Toast mToast = Toast.makeText(MainActivity.this, null, Toast.LENGTH_SHORT);
                mToast.setText("点击了："+list.get(position));
                mToast.show();
            }
        });
        //适配器
        CloudAdapter adapter = new CloudAdapter(list);
        tcvTags.setAdapter(adapter);
    }
}
