package com.example.fntoast;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.cardview.widget.CardView;
import androidx.core.content.res.ResourcesCompat;

public class FnToast {

    public enum LENGTH {
        SHORT,
        LONG
    }

    // Default Class
    private static Context contexts;
    private static LayoutInflater inflater;
    private static Toast toast;

    // View Class
    private static View parent;
    private static CardView cardView;
    private static ImageView icon;
    private static TextView title;

    // Attributes
    private static int background_color = Color.BLACK;
    private static int title_text_color = Color.WHITE;
    private static float title_text_size = 15f;
    private static int border_radius = 10;
    private static int margin_L_R = 32;
    private static boolean icon_animation = true;
    private static boolean icon_visibility = true;
    private static boolean forceDark = true;
    private static String title_text = "";
    private static int toast_duration = Toast.LENGTH_SHORT;
    private static int image_address = R.drawable.ic_baseline_archive_24;

    public FnToast(Context context) {
        contexts = context;
        initDisplaySize();
        init();
    }

    public static FnToast createToast(Context context, String titleText) {
        title_text = titleText;
        return new FnToast(context);
    }

    public void setImage_address (int image){
        image_address = image;
    }

    public void setBackgroundColor(int color) {
        background_color = color;
    }

    public void setTextColor(int color) {
        title_text_color = color;
    }

    public void setTextSize(float size) {
        title_text_size = size;
    }

    public void setRadius(int radius) {
        border_radius = radius;
    }

    public void setMargin_L_R(int margin) {
        margin_L_R = margin;
    }

    public void setIconAnimation(boolean animation) {
        icon_animation = animation;
    }

    public void setIconVisibility(boolean visibility) {
        icon_visibility = visibility;
    }

    public void setText(String text) {
        title_text = text;
    }

    public void setForceDark(boolean force) {
        forceDark = force;
    }

    public void setDuration (LENGTH length){
        if(length == LENGTH.SHORT){
            toast_duration = Toast.LENGTH_SHORT;
        }else{
            toast_duration = Toast.LENGTH_LONG;
        }
    }

    private static void init() {
        inflater = LayoutInflater.from(contexts);
        toast = new Toast(contexts);
        parent = inflater.inflate(R.layout.toast_layout, null);

        title = parent.findViewById(R.id.toast_view_text);
        cardView = parent.findViewById(R.id.toast_view_card);
        icon = parent.findViewById(R.id.toast_view_icon);

        initUi();

        toast.setDuration(Toast.LENGTH_LONG);
        toast.setGravity(Gravity.BOTTOM, 0, 32);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(parent);
    }

    private static void initUi() {
        cardView.setCardBackgroundColor(background_color);
        cardView.setRadius(pxFromDp(border_radius));
        title.setTextColor(title_text_color);
        title.setTextSize(title_text_size);
        icon.setImageDrawable(ResourcesCompat.getDrawable(contexts.getResources() , image_address , null));

        if (!icon_visibility) {
            icon.setVisibility(View.INVISIBLE);
        }

        if (icon_animation) {
            animate();
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            cardView.setForceDarkAllowed(forceDark);
            title.setForceDarkAllowed(forceDark);
        }

        if(toast_duration == Toast.LENGTH_LONG){
            toast.setDuration(Toast.LENGTH_LONG);
        }else {
            toast.setDuration(Toast.LENGTH_SHORT);
        }
    }

    private static void animate() {
        icon.setScaleX(0);
        icon.setScaleY(0);
        icon.animate().scaleX(1).scaleY(1).setDuration(500).start();
    }

    public void show() {
        initUi();
        toast.show();
        ViewGroup.LayoutParams layoutParams = cardView.getLayoutParams();
        layoutParams.width = DisplaySizes.getWidth(contexts) - (int) pxFromDp(margin_L_R);
        cardView.setLayoutParams(layoutParams);
    }

    private static void initDisplaySize() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        WindowManager windowmanager = (WindowManager) contexts.getSystemService(Context.WINDOW_SERVICE);
        windowmanager.getDefaultDisplay().getMetrics(displayMetrics);
        int width = (int) pxFromDp(displayMetrics.widthPixels);
        int height = (int) pxFromDp(displayMetrics.heightPixels);
        DisplaySizes.width = width;
        DisplaySizes.height = height;
    }

    private static float pxFromDp(final float dp) {
        return dp * contexts.getResources().getDisplayMetrics().density;
    }

}
