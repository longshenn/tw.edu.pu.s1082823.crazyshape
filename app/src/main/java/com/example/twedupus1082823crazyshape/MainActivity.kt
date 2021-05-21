package com.example.twedupus1082823crazyshape

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.module.AppGlideModule
import kotlinx.android.synthetic.main.activity_game.*
import kotlinx.android.synthetic.main.activity_main.*


@GlideModule
public final class MyAppGlideModule : AppGlideModule()



class MainActivity : AppCompatActivity(),
    GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener ,View.OnTouchListener{

    lateinit var gDetector: GestureDetector

    var PictureNo:Int = 0  //目前顯示第幾張圖
    var TotalPictures:Int = 4 //總共幾張圖片(假設僅顯示pu0-pu3)


    fun ShowPicture(){
        when (PictureNo){
            0 -> imgNext.setImageResource(R.drawable.circle)
            1 -> imgNext.setImageResource(R.drawable.square)
            2 -> imgNext.setImageResource(R.drawable.star)
            3 -> imgNext.setImageResource(R.drawable.triangle)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        gDetector = GestureDetector(this, this)
        imgNext.setOnTouchListener(this)

        Toast.makeText(baseContext, "作者：沈怡蓉", Toast.LENGTH_LONG).show()

        imgNext.setOnClickListener(object: View.OnClickListener {
            override fun onClick(p0: View?) {
                intent = Intent(this@MainActivity, GameActivity::class.java)
                startActivity(intent)
            }


        })

        val img: ImageView = findViewById(R.id.imgTitle)
        GlideApp.with(this)
            .load(R.drawable.cover)
            .into(img)

    }
    override fun onSingleTapUp(p0: MotionEvent?): Boolean {
        PictureNo = 0
        ShowPicture()
        return true
    }


}