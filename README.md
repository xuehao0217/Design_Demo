BottomSheets 和CoordinatorLayout
=======================

Android Support Library 23.2里的 Design Support Library新加了一个Bottom Sheets控件，一个底部表，就是我们经常在分享或者地图、音乐等app看到的效果

* 1. Support Vector Drawables and Animated Vector Drawables
* 2. AppCompat DayNight theme
* 3. Design Support Library: Bottom Sheets
* 4. Support v4: MediaBrowserServiceCompat
* 5. RecyclerView
* 6. Custom Tabs
* 7. Leanback for Android TV

具体可以上官网博客看看。

BottomSheetBehavior的使用及注意的地方

##Usage
###(1)在布局文件xml中
```xml
<?xml version="1.0" encoding="utf-8"?>
<android.support.design.widget.CoordinatorLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:id="@+id/cl"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:fitsSystemWindows="true"
    >

    <android.support.v4.widget.NestedScrollView
        android:id="@+id/bottom_sheet"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:behavior_hideable="true"
        app:behavior_peekHeight="50dp"
        app:layout_behavior="@string/bottom_sheet_behavior"
        >
          <!-- NestedScrollView里设置你的底部表长什么样的-->
    </android.support.v4.widget.NestedScrollView>
</android.support.design.widget.CoordinatorLayout>

```
###(2)在java代码中
```java
  @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ns);

        // The View with the BottomSheetBehavior
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) findViewById(R.id.cl);
        View bottomSheet = coordinatorLayout.findViewById(R.id.bottom_sheet);
        final BottomSheetBehavior behavior = BottomSheetBehavior.from(bottomSheet);
        behavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                //这里是bottomSheet 状态的改变回调
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {
                //这里是拖拽中的回调，根据slideOffset可以做一些动画
            }
        });
    }
```

通过附加一个BottomSheetBehavior 给CoordinatorLayout的子视图，上文xml中的是NestedScrollView(adding app:layout_behavior = " android.support.design.widget.BottomSheetBehavior”)，当然，RecyclerView也是可以的。如果需要BottomSheet View可以保持滚动，需要支持 nested scrolling (例如: NestedScrollView, RecyclerView, or ListView/ScrollView on API 21+).

```xml
     app:behavior_hideable="true"
     app:behavior_peekHeight="50dp"
```
这两个属性我说说，peekHeight是当Bottom Sheets关闭的时候，底部下表我们能看到的高度，hideable 是当我们拖拽下拉的时候，bottom sheet是否能全部隐藏。
如果你需要监听Bottom Sheets回调的状态，可以通过setBottomSheetCallback来实现，onSlide方法是拖拽中的回调，根据slideOffset可以做一些动画
onStateChanged方法可以监听到状态的改变,总共有5种

* STATE_COLLAPSED: 关闭Bottom Sheets,显示peekHeight的高度，默认是0
* STATE_DRAGGING:  用户拖拽Bottom Sheets时的状态
* STATE_SETTLING: 当Bottom Sheets view摆放时的状态。
* STATE_EXPANDED: 当Bottom Sheets 展开的状态
* STATE_HIDDEN: 当Bottom Sheets 隐藏的状态








