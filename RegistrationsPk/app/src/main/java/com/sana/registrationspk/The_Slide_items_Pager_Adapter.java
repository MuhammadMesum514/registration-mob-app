package com.sana.registrationspk;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.viewpager.widget.PagerAdapter;

import com.sana.registrationspk.ModelClass.The_Slide_Items_Model_Class;

import java.util.List;

public class The_Slide_items_Pager_Adapter extends PagerAdapter {
    private Context Mcontext;
    private List<The_Slide_Items_Model_Class> theSlideItemsModelClassList;

    public The_Slide_items_Pager_Adapter(Context Mcontext2, List<The_Slide_Items_Model_Class> theSlideItemsModelClassList2) {
        this.Mcontext = Mcontext2;
        this.theSlideItemsModelClassList = theSlideItemsModelClassList2;
    }

    public Object instantiateItem(ViewGroup container, int position) {
        View sliderLayout = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
            sliderLayout = ((LayoutInflater) this.Mcontext.getSystemService(LayoutInflater.class)).inflate(R.layout.items_layout, (ViewGroup) null);
        }
        ((ImageView) sliderLayout.findViewById(  R.id.my_featured_image)).setImageResource(this.theSlideItemsModelClassList.get(position).getFeatured_image());
        container.addView(sliderLayout);
        return sliderLayout;
    }

    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    public int getCount() {
        return this.theSlideItemsModelClassList.size();
    }

    public boolean isViewFromObject(View view, Object o) {
        return view == o;
    }
}
