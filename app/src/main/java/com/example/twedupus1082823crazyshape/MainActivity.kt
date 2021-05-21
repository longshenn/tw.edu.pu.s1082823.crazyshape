package com.example.twedupus1082823crazyshape

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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




class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Toast.makeText(baseContext, "作者：沈怡蓉", Toast.LENGTH_LONG).show()

        imgNext.setOnClickListener(object: View.OnClickListener{
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
}