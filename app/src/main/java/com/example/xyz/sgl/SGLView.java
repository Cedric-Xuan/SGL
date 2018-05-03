package com.example.xyz.sgl;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;

import com.example.xyz.sgl.filter.AFilter;

import java.io.IOException;

/**
 * Created by xyz. on 2018/3/22.
 */

public class SGLView extends GLSurfaceView{

    private SGLRender render;
    private String picPath;

    public SGLView(Context context){
        this(context,null);
    }

    public SGLView(Context context, AttributeSet attributeSet){
        super(context,attributeSet);
        init();
    }

    private void init(){
        setEGLContextClientVersion(2);
        render=new SGLRender(this);
        setRenderer(render);
        setRenderMode(GLSurfaceView.RENDERMODE_WHEN_DIRTY);

        try {
            render.setImage(BitmapFactory.decodeStream(getResources().getAssets().open("texture/fengj.png")));
            requestRender();
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    public void setPicPath(String path){
        this.picPath = path;
    }

    public SGLRender getRender(){
        return render;
    }

    public void setFilter(AFilter filter){
        render.setFilter(filter);
    }


}
