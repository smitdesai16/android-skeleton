package com.bombaytone.androidskeleton;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.shimmer.ShimmerFrameLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView3 = findViewById(R.id.tvTitle);
        textView3.setBackgroundColor(Color.parseColor("#dddddd"));
        TextView tvDescription = findViewById(R.id.tvDescription);
        tvDescription.setBackgroundColor(Color.parseColor("#dddddd"));
        ImageView ivDisplayPic = findViewById(R.id.ivDisplayPic);
        ivDisplayPic.setBackgroundColor(Color.parseColor("#dddddd"));

        ShimmerFrameLayout sflRoot = findViewById(R.id.sflRoot);
        // container.startShimmer();
        sflRoot.startShimmer();
    }
}