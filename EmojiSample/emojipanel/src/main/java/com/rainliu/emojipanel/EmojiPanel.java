package com.rainliu.emojipanel;

import android.content.Context;
import android.support.v4.view.ViewPager;

/**
 * Created by wliu on 2018/3/17.
 */

public class EmojiPanel extends ViewPager {

    private Context mContext;
    public EmojiPanel(Context context) {
        super(context);
        mContext = context;
    }
}
