package com.bombaytone.androidskeleton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.shimmer.ShimmerFrameLayout;

public class MainActivity extends AppCompatActivity {

    private static Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView tvTitle = findViewById(R.id.tvTitle);
        tvTitle.setBackgroundColor(Color.parseColor("#dddddd"));
        final TextView tvDescription = findViewById(R.id.tvDescription);
        tvDescription.setBackgroundColor(Color.parseColor("#dddddd"));
        final ImageView ivDisplayPic = findViewById(R.id.ivDisplayPic);
        ivDisplayPic.setBackgroundColor(Color.parseColor("#dddddd"));

        final ShimmerFrameLayout sflRoot = findViewById(R.id.sflRoot);
        sflRoot.startShimmer();

        handler = new Handler() {
            @Override
            public void handleMessage(@NonNull Message msg) {
                super.handleMessage(msg);

                tvTitle.setBackgroundColor(Color.TRANSPARENT);
                tvTitle.setText("This is title");
                tvDescription.setBackgroundColor(Color.TRANSPARENT);
                tvDescription.setText("This is description");
                ivDisplayPic.setBackground(getDrawable(R.drawable.ic_launcher_background));

                sflRoot.hideShimmer();
            }
        };

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                long futureTime = System.currentTimeMillis() + 6000;
                while (System.currentTimeMillis() < futureTime) {
                    synchronized (this) {
                        try {
                            wait(futureTime - System.currentTimeMillis());
                        }catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
                handler.sendEmptyMessage(0);
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();
    }
}