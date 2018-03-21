package com.rainliu.emojisample;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import com.rainliu.emojipanel.EmojiGridViewAdapter;
import com.rainliu.emojipanel.EmojiGroup;
import com.rainliu.emojipanel.EmojiGroupDesc;
import com.rainliu.emojipanel.EmojiPagerAdapter;
import com.rainliu.emojipanel.EmojiPanel;
import com.rainliu.emojipanel.Util;
import com.rainliu.emojipanel.span.EmojiSpan;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Activity mContext;
    private View mEmojiPanelContainer;
    private EditText mEditText;
    private ImageView mEmojiImageView;
    private PopupWindow mPopupWindow;

    private AdapterView.OnItemClickListener listenerA = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            int resId = ((EmojiGridViewAdapter.ViewHolder) view.getTag()).resId;
            insertEmoji(resId);
        }
    };

    private AdapterView.OnItemClickListener listenerB = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            int resId = ((EmojiGridViewAdapter.ViewHolder) view.getTag()).resId;
            insertEmoji(resId);
        }
    };

    private AdapterView.OnItemClickListener listenerC = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            int resId = ((EmojiGridViewAdapter.ViewHolder) view.getTag()).resId;
            showEmoji(resId);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.mContext = this;
        this.mEditText = this.findViewById(R.id.emojiEdit);
        this.mEmojiImageView = this.findViewById(R.id.emojiImageView);
        this.mEmojiPanelContainer = this.findViewById(R.id.emojiContainer);
        this.mPopupWindow = new PopupWindow(mContext);
        initKeyboard();
        initEmojiPanel();
        setupListener();
    }

    private void initEmojiPanel() {
        EmojiPanel emojiPanel = new EmojiPanel(mContext);
        emojiPanel.setId(R.id.emojiPanelId);
        FragmentManager fragmentManager = ((AppCompatActivity) mContext).getSupportFragmentManager();
        ArrayList<EmojiGroup> emojiGroups = initEmojiGroups();
        EmojiPagerAdapter adapter = new EmojiPagerAdapter(mContext, emojiGroups, fragmentManager);
        emojiPanel.setAdapter(adapter);
        setEmojiPanel(emojiPanel);
    }

    private ArrayList<EmojiGroup> initEmojiGroups() {
        EmojiGroup group1 = new EmojiGroup();
        EmojiGroupDesc desc1 = new EmojiGroupDesc();
        desc1.numColumns = 7;
        int[] imageResIds1 = {
                R.drawable.wx_56_56_56_1_1,
                R.drawable.wx_56_56_56_1_2,
                R.drawable.wx_56_56_56_1_3,
                R.drawable.wx_56_56_56_1_4,
                R.drawable.wx_56_56_56_1_5,
                R.drawable.wx_56_56_56_1_6,
                R.drawable.wx_56_56_56_1_7,
                R.drawable.wx_56_56_56_1_8,
                R.drawable.wx_56_56_56_1_9,
                R.drawable.wx_56_56_56_1_10,
                R.drawable.wx_56_56_56_1_11,
                R.drawable.wx_56_56_56_1_12,
                R.drawable.wx_56_56_56_1_13,
                R.drawable.wx_56_56_56_1_14,
                R.drawable.wx_56_56_56_1_15,
                R.drawable.wx_56_56_56_2_1,
                R.drawable.wx_56_56_56_2_2,
                R.drawable.wx_56_56_56_2_3,
                R.drawable.wx_56_56_56_2_4,
                R.drawable.wx_56_56_56_2_5,
                R.drawable.wx_56_56_56_2_6,
                R.drawable.wx_56_56_56_2_7,
                R.drawable.wx_56_56_56_2_8,
                R.drawable.wx_56_56_56_2_9,
                R.drawable.wx_56_56_56_2_10,
                R.drawable.wx_56_56_56_2_11,
                R.drawable.wx_56_56_56_2_12,
                R.drawable.wx_56_56_56_2_13,
                R.drawable.wx_56_56_56_2_14,
                R.drawable.wx_56_56_56_2_15,
        };
        desc1.imageResIds = imageResIds1;
        desc1.size = 48;
        desc1.padding = 5;
        group1.desc = desc1;
        group1.listener = listenerA;

        EmojiGroup group2 = new EmojiGroup();
        EmojiGroupDesc desc2 = new EmojiGroupDesc();
        desc2.numColumns = 6;
        int[] imageResIds2 = {
                R.drawable.wx_48_48_48_1_1,
                R.drawable.wx_48_48_48_1_2,
                R.drawable.wx_48_48_48_1_3,
                R.drawable.wx_48_48_48_1_4,
                R.drawable.wx_48_48_48_1_5,
                R.drawable.wx_48_48_48_1_6,
                R.drawable.wx_48_48_48_1_7,
                R.drawable.wx_48_48_48_1_8,
                R.drawable.wx_48_48_48_1_9,
                R.drawable.wx_48_48_48_1_10,
                R.drawable.wx_48_48_48_1_11,
                R.drawable.wx_48_48_48_1_12,
                R.drawable.wx_48_48_48_1_13,
                R.drawable.wx_48_48_48_1_14,
                R.drawable.wx_48_48_48_1_15,
                R.drawable.wx_48_48_48_2_1,
                R.drawable.wx_48_48_48_2_2,
                R.drawable.wx_48_48_48_2_3,
                R.drawable.wx_48_48_48_2_4,
                R.drawable.wx_48_48_48_2_5,
                R.drawable.wx_48_48_48_2_6,
                R.drawable.wx_48_48_48_2_7,
                R.drawable.wx_48_48_48_2_8,
                R.drawable.wx_48_48_48_2_9,
                R.drawable.wx_48_48_48_2_10,
                R.drawable.wx_48_48_48_2_11,
                R.drawable.wx_48_48_48_2_12,
                R.drawable.wx_48_48_48_2_13,
                R.drawable.wx_48_48_48_2_14,
                R.drawable.wx_48_48_48_2_15,
        };
        desc2.size = 48;
        desc2.padding = 3;
        desc2.imageResIds = imageResIds2;
        group2.listener = listenerB;
        group2.desc = desc2;

        EmojiGroup group3 = new EmojiGroup();
        EmojiGroupDesc desc3 = new EmojiGroupDesc();
        desc3.numColumns = 4;
        desc3.size = 90;
        int[] imageResIds3 = {
                R.drawable.wx_d_1,
                R.drawable.wx_d_2,
                R.drawable.wx_d_3,
                R.drawable.wx_d_4,
                R.drawable.wx_d_5,
                R.drawable.wx_d_6,
                R.drawable.wx_d_7,
                R.drawable.wx_d_8,
        };
        desc3.imageResIds = imageResIds3;
        group3.listener = listenerC;
        group3.desc = desc3;

        ArrayList<EmojiGroup> groups = new ArrayList<>();
        groups.add(group1);
        groups.add(group2);
        groups.add(group3);

        return groups;
    }

    private void insertEmoji(int resId) {
        EmojiSpan emojiSpan = new EmojiSpan(mContext, resId, (int) (mEditText.getLineHeight() * 1.2));
        SpannableStringBuilder ssb = new SpannableStringBuilder();
        ssb.append(Util.ZERO_WIDTH_SPACE_STR);
        ssb.setSpan(emojiSpan, 0, ssb.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        mEditText.append(ssb);
    }

    private void showEmoji(int resId) {
        mPopupWindow.dismiss();
        int size = Util.getPixelByDp(mContext, 100);
        mPopupWindow.setWidth(size);
        mPopupWindow.setHeight(size);
        ImageView emojiRenderView = (ImageView) LayoutInflater.from(mContext).inflate(R.layout.emoji_window, null);
        mPopupWindow.setContentView(emojiRenderView);
        emojiRenderView.setImageResource(resId);
        View anchorView = mContext.getWindow().getDecorView();
        mPopupWindow.showAtLocation(anchorView,
                Gravity.LEFT | Gravity.TOP ,
                anchorView.getWidth()/2 - size / 2,
                anchorView.getHeight()/2 - size * 2);
        emojiRenderView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPopupWindow.dismiss();
            }
        });
    }

    private void setupListener() {
        this.mEmojiImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleEmojiPanel(true);
            }
        });
    }

    private EditText getEditText() {
        return this.mEditText;
    }

    /* -------- START: Keep it at the bottom of the class.. Keyboard and emoji ------------ */
	/* -------- START: Keep it at the bottom of the class.. Keyboard and emoji ------------ */
    private void initKeyboard() {
        final Window window = mContext.getWindow();
        final View rootView = window.getDecorView().findViewById(android.R.id.content);
        rootView.getViewTreeObserver().addOnGlobalLayoutListener(
                new ViewTreeObserver.OnGlobalLayoutListener() {
                    public void onGlobalLayout() {
                        if (mLayoutDelay == 0) {
                            init();
                            return;
                        }
                        rootView.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                init();
                            }
                        }, mLayoutDelay);

                    }

                    private void init() {
                        Rect r = new Rect();
                        View view = window.getDecorView();
                        view.getWindowVisibleDisplayFrame(r);
                        int[] screenWandH = Util.getScreenWidthAndHeight(mContext);
                        int screenHeight = screenWandH[1];
                        final int keyboardHeight = screenHeight - r.bottom;

                        Util.log("p height == " + mPreviousKeyboardHeight + ", this height == " + keyboardHeight);
                        if (mPreviousKeyboardHeight != keyboardHeight) {
                            if (keyboardHeight > 100) {
                                mKeyboardHeight = keyboardHeight;
                                onKeyboardShow();
                            } else {
                                onKeyboardHide();
                            }
                        }
                        mPreviousKeyboardHeight = keyboardHeight;
                    }
                });
    }

    private void onKeyboardShow() {
        mKeyboardShownNow = true;
        toggleEmojiPanel(false);
        mEmojiShownNow = false;
        mLayoutDelay = 100;
    }

    private void onKeyboardHide() {
        Util.log("on key board hide, hewhkb == " + mHideEmojiWhenHideKeyboard);
        mKeyboardShownNow = false;
        if (mHideEmojiWhenHideKeyboard) {
            toggleEmojiPanel(false);
        } else {
            this.mEditText.postDelayed(new Runnable() {
                @Override
                public void run() {
                    mHideEmojiWhenHideKeyboard = true;
                }
            }, 100);
        }
    }

    private int mLayoutDelay = 0;
    private int mPreviousKeyboardHeight = 0;
    private boolean mKeyboardShownNow = true;
    private boolean mEmojiShownNow = false;
    private boolean mHideEmojiWhenHideKeyboard = true;
    private int mKeyboardHeight = 0;
    private View mEmojiPanel;


    private void initEmojiPanelHeight(int expectHeight) {
        int emojiHeight = this.mEmojiPanelContainer.getHeight();
        if (emojiHeight != expectHeight) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) mEmojiPanelContainer.getLayoutParams();
            layoutParams.height = expectHeight;
            mEmojiPanelContainer.setLayoutParams(layoutParams);
            if (mEmojiPanel != null) {
                LinearLayout.LayoutParams emojiPanelLayoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
                mEmojiPanel.setLayoutParams(emojiPanelLayoutParams);
                ((ViewGroup) mEmojiPanelContainer).addView(mEmojiPanel);
            }
            mContext.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        }
    }

    public void toggleEmojiPanel(boolean byClickEmoji) {
        if (mKeyboardShownNow) {
            if (byClickEmoji) {
                // Keyboard is shown now
                // Click emoji icon we should hide keyboard and keep emoji panel open

                // 1. Set keyboard as hide
                mKeyboardShownNow = false;

                // 2. When hide keyboard, don't need to hide emoji
                // as we need to open emoji
                mHideEmojiWhenHideKeyboard = false;

                // 3. Hide keyboard
                View view = mContext.getCurrentFocus();
                hideKeyboard(view);

                // 4. Show emoji
                initEmojiPanelHeight(mKeyboardHeight);
                mEmojiPanelContainer.setVisibility(View.VISIBLE);

                // 5. Set emoji is shown now
                mEmojiShownNow = true;

                // 6. Change emoji icon to keyboard
                mEmojiImageView.setImageResource(R.drawable.keyboard);
            } else {
                // Keyboard is shown now
                // Toggle emoji panel to make the layout looks well for adjustPan

                // 1. Sets emoji panel to visible so it takes up height
                mEmojiPanelContainer.setVisibility(View.VISIBLE);

                // 2. Although emoji panel takes up height but it is not shown now
                // (NOT VISIBLE TO USER, AS KEYBOARD IS BEING SHOWN)
                mEmojiShownNow = false;
            }
        } else {
            if (byClickEmoji) {
                // Keyboard is hide, then use clicks emoji
                // We should consider two cases
                // 1. keyboard is hidden but emoji is shown
                // 2. keyboard is hidden and Emoji is hidden too


                if (mEmojiShownNow) {
                    // Case 1: keyboard is hidden but emoji is shown
                    // And user clicks emoji icon
                    //
                    // We should show keyboard and hide emoji

                    // 1. Set keyboard as shown now
                    mKeyboardShownNow = true;

                    // 1.1. Show keyboard
                    View view = getEditText();
                    showKeyboard(view);

                    // 2. Set emoji as hide now
                    mEmojiShownNow = false;

                    // 3. Change emoji icon to emoji
                    mEmojiImageView.setImageResource(R.drawable.emoji);
                } else {
                    // Case 2: keyboard is hidden and Emoji is hidden too
                    // And user clicks emoji icon
                    //
                    // We should show emoji panel

                    // 1. Show emoji panel
                    initEmojiPanelHeight(mKeyboardHeight);
                    mEmojiPanelContainer.setVisibility(View.VISIBLE);
                    // 1.1 Set emoji panel as shown now
                    mEmojiShownNow = true;
                    // 1.2 Change emoji icon to keyboard
                    mEmojiImageView.setImageResource(R.drawable.keyboard);
                }

            } else {
                // User clicks the virtual button to hide keyboard
                // We should hide emoji panel
                mEmojiPanelContainer.setVisibility(View.GONE);
                mEmojiShownNow = false;
                mEmojiImageView.setImageResource(R.drawable.emoji);
            }
        }
    }

    protected void showKeyboard(View view) {
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) mContext.getSystemService(Context.INPUT_METHOD_SERVICE);
            if (imm != null) {
                view.requestFocus();
                imm.showSoftInput(view, 0);
            }
        }
    }

    protected void hideKeyboard(View view) {
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) mContext.getSystemService(Context.INPUT_METHOD_SERVICE);
            if (imm != null) {
                imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }
        }
    }


    public void setEmojiPanel(View emojiPanel) {
        mEmojiPanel = emojiPanel;
    }
    /* -------- END: Keep it at the bottom of the class.. Keyboard and emoji ------------ */
    /* -------- END: Keep it at the bottom of the class.. Keyboard and emoji ------------ */
}
