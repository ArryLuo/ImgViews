package com.example.imgviews;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;


public class MainActivity extends Activity {
	//缓存
	private ImageView img1,img2;
	 Bitmap mbitmap;
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       img1=(ImageView) findViewById(R.id.img1);
       img2=(ImageView) findViewById(R.id.img2);
       BitmapDrawable drawable=(BitmapDrawable) img1.getDrawable();
       mbitmap=drawable.getBitmap();
       //创建一个图片的拷贝
       //创建一个副本
       //1,创建了一个空白的位图
        Bitmap bitmap=Bitmap.createBitmap(mbitmap.getWidth(), mbitmap.getHeight(), mbitmap.getConfig());
       //2,定义一个画板
       Canvas canvas=new Canvas(bitmap);
       //3,创建一个画笔
       Paint paint=new Paint();
       paint.setColor(Color.BLACK);
       //4,临摹作画
       //矩阵
       Matrix matrix=new Matrix();
       //放大
     //  matrix.setScale(2.0f, 2.0f);
       //倒影
       //matrix.setScale(1,-1);
       //由于纵轴为负，因此他在新创建的bitmap之外，所以加上原图的高度就可以显示出来了
       //matrix.postTranslate(0, mbitmap.getHeight());
       //镜子
      matrix.setScale(-1,1);
       //与倒影一样的原理
      matrix.postTranslate(mbitmap.getWidth(),0);
       //颜色矩阵
       ColorMatrix colorMatrix=new ColorMatrix();
       colorMatrix.set(new float[]{
    		   2,0,0,0,0,//红色如何变化
    		   0,1,0,0,0,//绿色如何变化
    		   0,0,1,0,0,//蓝色如何变化
    		   0,0,0,1,0//
       });
       //你要临摹的那个图片;
       paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
       canvas.drawBitmap(mbitmap, matrix, paint);
       img2.setImageBitmap(bitmap);
	}
	public void click(View view){
	}
}
