package com.wildma.wildmaidcardcamera;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;

import com.wildma.idcardcamera.camera.CameraActivity;


public class MainActivity extends AppCompatActivity {
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = (ImageView) findViewById(R.id.iv_image);
    }

    /**
     * 身份证正面
     */
    public void frontIdCard(View view) {
        CameraActivity.toCameraActivity(this, CameraActivity.TYPE_PMI);
    }

    /**
     * 身份证反面
     */
    public void backIdCard(View view) {
        CameraActivity.toCameraActivity(this, CameraActivity.TYPE_FERRITE);
    }

    public void threeIdCard(View view) {
        CameraActivity.toCameraActivity(this, CameraActivity.TYPE_HARDNESS);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CameraActivity.REQUEST_CODE && resultCode == CameraActivity.RESULT_CODE) {
            //获取图片路径，显示图片
            final String path = CameraActivity.getImagePath(data);
            if (!TextUtils.isEmpty(path)) {
                imageView.setImageBitmap(BitmapFactory.decodeFile(path));
            }
        }
    }
}
