# **OrderStateLine**
这是一个简单的时间轴实现(LinearLayout)
----------
### 效果图:</br>
![gif](https://raw.githubusercontent.com/weipeilong123/OrderStateLine/master/image/psb.gif)</br></br>
### 依赖：</br>
----------
 ##### Step 1.
 ###### 添加Jitpack到您的root gradle，如果无法导包，一般情况下都是这个原因，请仔细检查
 ```xml
     allprojects {
    	repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
 ```
##### Step 2.
 ###### 在需要使用到的Module中添加以下依赖
 ```xml
    dependencies {
		compile 'com.github.weipeilong123:OrderStateLine:1.0.0'
	}
 ```
 </br></br>
 ----------
 ## 使用方法：</br>
 ##### Step 1.</br>
 ###### 像您平时定制activity布局文件一样定制您的布局
 ```xml
<?xml version="1.0" encoding="utf-8"?>
<ScrollView xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="#ffffff"
    android:orientation="vertical"
    android:scrollbars="none">

    <com.wpl.underline.UnderLineLayout
        android:id="@+id/underLineLayout"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="vertical"
        app:line_dynamic_dimen="8dp"
        app:line_margin_side="25dp" />

</ScrollView>
 ```
 ##### Step 2.</br>
 ###### 因为继承的LinearLayout，所以请直接addView就行啦
 ```java
private void addItem(String title, String content, String time, boolean isDisplayContent, int currentState) {
        View v = LayoutInflater.from(this).inflate(R.layout.view_order_state_row, underLineLayout, false);
        TextView titleTv = (TextView) v.findViewById(R.id.orderState_title);
        TextView contentTv = (TextView) v.findViewById(R.id.orderState_content);
        TextView timeTv = (TextView) v.findViewById(R.id.orderState_time);
        RelativeLayout otherRl = (RelativeLayout) v.findViewById(R.id.orderState_other);

        titleTv.setText(title);
        timeTv.setText(time);
        contentTv.setVisibility(isDisplayContent ? View.VISIBLE : View.GONE);
        if (isDisplayContent) {
            contentTv.setText(content);
            titleTv.setTextAppearance(this, R.style.BoldText);
            titleTv.setTextColor(getResources().getColor(R.color.app_color));
            if (currentState >= 3 && currentState <= 5) {
                initOtherView(otherRl);
            }
        }
        underLineLayout.addView(v);
    }

    private void initOtherView(RelativeLayout container) {
        container.setVisibility(View.VISIBLE);
        ImageView iv = new ImageView(this);
        iv.setScaleType(ImageView.ScaleType.FIT_XY);
        iv.setImageResource(R.mipmap.pic_map);
        container.addView(iv);
    }
 ```
 ## 各值属性：</br>
 ##### attrs.xml:</br>
 ```xml
 <declare-styleable name="UnderLineLinearLayout">
        <!--时间轴偏移值-->
        <attr name="line_margin_side" format="dimension"/>
        <!--时间轴动态调整值-->
        <attr name="line_dynamic_dimen" format="dimension"/>
        <!--线宽-->
        <attr name="line_stroke_width" format="dimension"/>
        <!--线的颜色-->
        <attr name="line_color" format="color"/>
        <!--点的大小-->
        <attr name="point_size" format="dimension"/>
        <!--点的颜色-->
        <attr name="point_color" format="color"/>
        <!--图标-->
        <attr name="icon_src" format="reference"/>
           <!--时间轴的gravity-->
                <!--the gravity of the timeline-->
                <attr name="line_gravity">
                    <enum name="Left" value="2"/>
                    <enum name="Right" value="4"/>
                    <enum name="Middle" value="0"/>
                    <enum name="Top" value="1"/>
                    <enum name="Bottom" value="3"/>
                </attr>
 </declare-styleable>
 ```
 ----------</br>
[Download Demo](https://raw.githubusercontent.com/weipeilong123/OrderStateLine/master/app/app-release.apk "下载Demo")

 ----------</br>
 ## 最后：</br>
 ##### 不要被那些复杂的布局吓到了，都是一步一步来的.</br>
