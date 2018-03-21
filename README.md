# SimpleEmojiPicker
Just a quick simple emoji picker, it helps you to setup your emoji picker app quickly.

It allows you to define a set of emoji groups, includes the emoji icons / emoji icon size / columns / click listeners. And pretty easy and lightweight to integrate into your apps.

## Screenshots
### One the emoji groups
 ![image](https://github.com/chinalwb/SimpleEmojiPicker/blob/master/demo/demo_emoji_picker.png?raw=true)
 
### Another one of the emoji groups
 ![image](https://github.com/chinalwb/SimpleEmojiPicker/blob/master/demo/demo_emoji_picker_2.png?raw=true)

## How to use?
0. Import the library to your project. The lib is inside the `EmojiSample` folder at here [emojipanel](https://github.com/chinalwb/SimpleEmojiPicker/tree/master/EmojiSample/emojipanel) 

1. Add an emoji container to your layout file, your emoji panel will be shown inside:
```
    <LinearLayout
        android:id="@+id/emojiContainer"
        android:layout_width="match_parent"
        android:layout_height="0dp"
        android:visibility="gone"
        android:orientation="horizontal">

    </LinearLayout>
```

2. In your java file, init an instance of `EmojiPanel` like this:
```
    private void initEmojiPanel() {
        // mContext = YOUR_ACTIVITY
        EmojiPanel emojiPanel = new EmojiPanel(mContext);
        emojiPanel.setId(R.id.emojiPanelId);
        FragmentManager fragmentManager = ((AppCompatActivity) mContext).getSupportFragmentManager();
        ArrayList<EmojiGroup> emojiGroups = initEmojiGroups();
        EmojiPagerAdapter adapter = new EmojiPagerAdapter(mContext, emojiGroups, fragmentManager);
        emojiPanel.setAdapter(adapter);
    }
```

3. You may have noticed the `initEmojiGroups`, it is as below:
```
private ArrayList<EmojiGroup> initEmojiGroups() {
        // I just didn't paste group1 and 2 here...
        EmojiGroup group3 = new EmojiGroup();
        EmojiGroupDesc desc3 = new EmojiGroupDesc();
        desc3.numColumns = 4; // The columns count
        desc3.size = 90; // The size of each emoji, in dp
        int[] imageResIds3 = { // The emoji icons to be shown for this group
                R.drawable.wx_d_1,
                R.drawable.wx_d_2,
                R.drawable.wx_d_3,
        };
        desc3.imageResIds = imageResIds3;
        group3.listener = listenerC;
        group3.desc = desc3;

        ArrayList<EmojiGroup> groups = new ArrayList<>();
        groups.add(group3);
        return groups;
    }
```

4. So what is `listenerC`?
```
    private AdapterView.OnItemClickListener listenerC = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            int resId = ((EmojiGridViewAdapter.ViewHolder) view.getTag()).resId;
            insertEmoji(resId);
        }
    };
```

That's it!

## To summary:
With this library you can define a set of emoji groups, each group will be shown at a fragment, all groups will be shown within a ViewPager (`EmojiPanel` extends ViewPager). You can set different click listener to each emoji group, such as append the emoji to EditText or show it in a PopupWindow.

BTW, in the sample app, I added the feature about toggling between emoji panel and keyboard, which I think will be useful in most cases.

### Todos
Add emoji group indicator
Add Gradle support


Any advice will be appreaciate. Enjoy playing with Simple Emoijipicker.
