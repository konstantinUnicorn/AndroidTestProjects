package com.example.app4sat7sem;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

class ViewPagerAdapter extends PagerAdapter {
    private Context mContext;

    public ViewPagerAdapter(Context context) {
        mContext = context;
    }

    @Override
    public Object instantiateItem(ViewGroup viewGroup, int position) {
        // получаем ресурсы (название и макет) соответствующий позиции в адаптере
        ResourcesModel resources = ResourcesModel.values()[position];
        LayoutInflater inflater = LayoutInflater.from(mContext);
        // инициализируем экран ViewPager'а в соответствии с позицией
        ViewGroup layout = (ViewGroup) inflater.inflate(
                resources.getLayoutResourceId(), viewGroup, false);
        viewGroup.addView(layout);

        return layout;
    }

    @Override
    public void destroyItem(ViewGroup viewGroup, int position, Object view) {
        viewGroup.removeView((View) view);
    }

    @Override
    public int getCount() {
        return ResourcesModel.values().length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        // получаем название соответствующее позиции в адаптере
        ResourcesModel customPagerEnum = ResourcesModel.values()[position];

        return mContext.getString(customPagerEnum.getTitleResourceId());
    }
}
