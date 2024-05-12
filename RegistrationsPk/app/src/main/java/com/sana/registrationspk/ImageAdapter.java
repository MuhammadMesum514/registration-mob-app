package com.sana.registrationspk;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

public class ImageAdapter extends PagerAdapter {
    Context mContext;
    private int[] sliderImageId = {R.drawable.image1, R.drawable.image2, R.drawable.image3, R.drawable.image4, R.drawable.image5};

    ImageAdapter(Context context) {
        this.mContext = context;
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isViewFromObject(android.view.View r2, Object r3) {
        /*
            r1 = this;
            r0 = r3
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            if (r2 != r0) goto L_0x0007
            r0 = 1
            goto L_0x0008
        L_0x0007:
            r0 = 0
        L_0x0008:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.myapplication.ImageAdapter.isViewFromObject(android.view.View, java.lang.Object):boolean");
    }

    public Object instantiateItem(ViewGroup container, int position) {
        ImageView imageView = new ImageView(this.mContext);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setImageResource(this.sliderImageId[position]);
        ((ViewPager) container).addView(imageView, 0);
        return imageView;
    }

    public void destroyItem(ViewGroup container, int position, Object object) {
        ((ViewPager) container).removeView((ImageView) object);
    }

    public int getCount() {
        return this.sliderImageId.length;
    }
}
