package com.tdy.tdytravel.fragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.TextView;

import com.android.volley.toolbox.NetworkImageView;
import com.tdy.tdytravel.R;
import com.tdy.tdytravel.base.BaseFragment;
import com.tdy.tdytravel.base.MyApplication;
import com.tdy.tdytravel.uitls.Constants;
import com.tdy.tdytravel.uitls.ThreadPoolUtil;
import com.tdy.tdytravel.uitls.VolleyImageLoader;

import java.util.zip.CheckedOutputStream;

/**
 * Created by tangdayi on 2017/5/20.
 * 作者:tangdayi
 * 日期:2017年05月20日10时02分
 * 工程:tdytravel * *
 */
public class DetailsScenicFragment extends BaseFragment{
    private NetworkImageView imageView;
    private TextView title;
    private TextView datetime;
    private TextView content;
    private Context context;
    
    private static DetailsScenicFragment fragment;
    public static DetailsScenicFragment getFragment(){
    	if (fragment==null) {
			fragment = new DetailsScenicFragment();
			return fragment;
		}
    	return null;
    }
    
    
	@Override
	public View initView(LayoutInflater inflater, ViewGroup container) {
		View view = inflater.inflate(R.layout.fragment_scenic, container,false);
        imageView = (NetworkImageView) view.findViewById(R.id.scenic_image);
        title = (TextView) view.findViewById(R.id.scenic_title);
        content = (TextView) view.findViewById(R.id.scenic_content);
        datetime = (TextView) view.findViewById(R.id.scenic_datetime);
		return view;
	}

	@Override
	protected void initData() {
        ThreadPoolUtil.runTaskInUIThread(new Runnable() {
            @Override
            public void run() {
                VolleyImageLoader imgLoader =VolleyImageLoader.getInstance(mContext);
                imgLoader.loadImage(MyApplication.getString(Constants.ScenicBeanAPI.image), imageView);
                title.setText(MyApplication.getString(Constants.ScenicBeanAPI.p_name));
                datetime.setText(MyApplication.getString(Constants.ScenicBeanAPI.p_time));
                content.setText(MyApplication.getString(Constants.ScenicBeanAPI.p_desc));
            }
        });
	}

}
