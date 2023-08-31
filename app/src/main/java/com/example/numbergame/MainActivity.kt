    package com.example.numbergame

    import android.annotation.SuppressLint
    import android.graphics.Color
    import android.media.Ringtone
    import androidx.appcompat.app.AppCompatActivity
    import android.os.Bundle
    import android.util.Log
    import android.view.View
    import android.widget.Button
    import android.widget.TextView
    import androidx.constraintlayout.widget.ConstraintLayout

    class MainActivity : AppCompatActivity() {
    var randomNumber1: Int = 0
    var randomNumber2: Int = 0
    var point: Int = 0
    var pointView: TextView? = null;

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //        Creating Button
        val show1: Button = findViewById<Button>(R.id.buttonLeft)
        val show2: Button = findViewById<Button>(R.id.buttonRight)
        val result: TextView = findViewById<TextView>(R.id.pointCheck)
        val mainLayout = findViewById<ConstraintLayout>(R.id.MainLayout)
        //        Random Number Generator

        genRandom(show1, show2)
        show1.setOnClickListener { btnClick(true, result, show1, show2,mainLayout) }
        show2.setOnClickListener { btnClick(false, result, show1, show2,mainLayout) }

    }

    private fun genRandom(button1: Button, button2: Button) {
        randomNumber1 = (0..100).random();
        randomNumber2 = (0..100).random();
        button1.text = randomNumber1.toString();
        button2.text = randomNumber2.toString();
    }

    private fun btnClick(isLeft: Boolean, result: TextView, btnLeft: Button, btnRight: Button,layout: ConstraintLayout) {
        if(isLeft == true) {
            if (randomNumber1 > randomNumber2) {
                point++;
                layout.setBackgroundColor(Color.GREEN)
            }
            else {
                point--
                layout.setBackgroundColor(Color.RED)
            }
            result.text = "Point:"+point.toString();
            genRandom(btnLeft, btnRight);

        }
        else {
            if (randomNumber2 > randomNumber1) {
                point++;
                layout.setBackgroundColor(Color.GREEN)
            }
            else {
                point--;
                layout.setBackgroundColor(Color.RED)
            }
            result.text = "Point:"+point.toString();
            genRandom(btnLeft, btnRight);

        }
    }
    }






