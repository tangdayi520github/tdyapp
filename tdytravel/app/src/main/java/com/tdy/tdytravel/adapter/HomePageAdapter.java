package com.tdy.tdytravel.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.tdy.tdytravel.R;
import com.tdy.tdytravel.bean.HomePage;
import com.tdy.tdytravel.http.ImageLoader;

import java.util.List;

public class HomePageAdapter extends PagerAdapter {
	private Context context;
	private List<HomePage.homePageBean> beans;

	public HomePageAdapter(Context context, List<HomePage.homePageBean> beans) {
		this.context = context;
		this.beans = beans;
	}

	@Override
	public int getCount() {
		return beans.size();
	}

	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {
		return arg0 == arg1;
	}

	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		container.removeView((View) (object));
	}

	@Override
	public Object instantiateItem(ViewGroup container, int position) {
		View view = LayoutInflater.from(context).inflate(
				R.layout.fragment_home_vp_item, container, false);
		ImageView homepageImage = (ImageView) view.findViewById(R.id.home_head_vp_image);
		TextView homepageTitle = (TextView) view.findViewById(R.id.home_head_vp_title);
		HomePage.homePageBean bean = beans.get(position);
		homepageImage.setTag(bean.getPicurl());
		new ImageLoader(bean.getPicurl(), homepageImage);
		homepageTitle.setText(bean.getTitle());
		container.addView(view);
		return view;
	}

}
