package com.mytest.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.List;

/**
 * Created by Jason on 2016/11/25.
 */

public class LooperImageAdapter extends PagerAdapter {

    private List<ImageView> resourceImage;

    public LooperImageAdapter(List<ImageView> resourceImage) {
        this.resourceImage = resourceImage;
    }

    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        position = position % resourceImage.size();
        ImageView imageView = resourceImage.get(position);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams
                (ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        imageView.setLayoutParams(params);
        container.addView(imageView);
        return imageView;
    }
}
