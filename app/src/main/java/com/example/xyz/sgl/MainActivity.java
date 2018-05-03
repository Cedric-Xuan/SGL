package com.example.xyz.sgl;

import android.app.Activity;
import android.os.Bundle;

public class MainActivity extends Activity {

    private SGLView glView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        glView = (SGLView) findViewById(R.id.gl_view);
//        glView.setPicPath("texture/fengj.png");

    }

    @Override
    protected void onResume() {
        super.onResume();
        if(glView!=null) {
            glView.onResume();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        glView.onPause();
    }


}
