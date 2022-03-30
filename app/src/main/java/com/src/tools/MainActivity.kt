package com.src.tools

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.src.anim.AnimDialog
import com.src.anim.TwoHeaders

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // 1. Call a lib as a class like this:
        val animDialog = AnimDialog(this) // Dialog with an icon header by 6 defaults and one simple
        val twoHeaders = TwoHeaders(this) // Dialog with an icon & textBox


        // Call different dialogs in side of **OnClick***
        findViewById<Button>(R.id.btn1)
            .setOnClickListener {
                animDialog.simple(
                    headerImage = android.R.drawable.presence_video_online,
                    description = "Hi thi is a test",
                    titleOfPositiveButton = "OK",
                    titleOfNegativeButton = "Cancel",
                    positiveButtonFunction = {
                        Toast.makeText(
                            this,
                            "Click on OK",
                            Toast.LENGTH_SHORT
                        ).show()
                    },
                    negativeButtonFunction = {
                        Toast.makeText(
                            this,
                            "Click on Cancel",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                )
            }
        // If you need create your Theme!
        animDialog.dialogTheme(
            true,
            "White",
            "#DFD3C3", "black",
            "#000B49", "yellow"
        )

        findViewById<Button>(R.id.btn4).setOnClickListener {
            animDialog.welcome("Welcome to this", null, {})
        }
        findViewById<Button>(R.id.btn5).setOnClickListener {
            animDialog.exit("Do you want exit?", null, "Cancel", {
                Toast.makeText(this, "goodbye", Toast.LENGTH_SHORT).show()
            }, this)
        }
        findViewById<Button>(R.id.btn6).setOnClickListener {
            animDialog.rate("Do you enjoy it? \n Please rate us", "Rate", "Maybe later")
        }
        findViewById<Button>(R.id.btn7).setOnClickListener {
            animDialog.info("This message inform you about this", "Got it")
        }
        findViewById<Button>(R.id.btn8).setOnClickListener {
            animDialog.warning("Attention! \n You are going in bad way", "Accept", "Ignore", {})
        }
        findViewById<Button>(R.id.btn9).setOnClickListener {
            animDialog.del("Do you want Delete it!? \n You will lose this",
                "Delete",
                "Ignore",
                { Toast.makeText(this, "It's deleted!", Toast.LENGTH_SHORT).show() })
        }

        // In the second class , there is a two headers dialog
        findViewById<Button>(R.id.btn2)
            .setOnClickListener {
                twoHeaders.simple(
                    title = "Exit App",
                    headerImage = null,
                    description = "Hi thi is a test",
                    titleOfPositiveButton = "OK",
                    titleOfNegativeButton = "Ignore",
                    positiveButtonFunction = {
                        Toast.makeText(this, "OK", Toast.LENGTH_SHORT).show()
                    },
                    negativeButtonFunction = {
                        Toast.makeText(this, "Ignore", Toast.LENGTH_SHORT).show()
                    }
                )
            }
        /*
        findViewById<Button>(R.id.btn3)
            .setOnClickListener {
                animDialog.custom(
                    title = "Welcome Dear",
                    titleColor = resources.getColor(android.R.color.background_light),
                    titleBackground = android.R.drawable.ic_notification_overlay,
                    headerImage = android.R.drawable.btn_star_big_on,
                    headerBackgroundTint = Color.argb(205, 182, 144, 0),
                    description = "Sometimes we looking for new dialog to fill better \n ",
                    descriptionColorTint = Color.argb(205, 102, 254, 23),
                    titleOfPositiveButton = "Accept it",
                    titleOfNegativeButton = "Not now",
                    negBackground = android.R.drawable.arrow_up_float,
                    posBackground = android.R.drawable.arrow_down_float,
                    negColor = Color.BLUE,
                    posColor = resources.getColor(android.R.color.holo_red_dark),
                    positiveButtonFunction = {
                        animDialog.test("OK")
                    },
                    negativeButtonFunction = {
                        animDialog.test("NO")
                    }).show()
            }
        */
    }

}