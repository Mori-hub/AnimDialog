package com.src.anim

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.View
import android.view.Window
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
@SuppressLint("SetTextI18n")
class TwoHeaders(private val context: Context) {
    private val dialogTwo = Dialog(context)
    private val dialogTitle: TextView
    private val dialogHeaderImage: ImageView
    private val dialogDescription: TextView
    private val dialogPositiveButton: Button
    private val dialogNegativeButton: Button

    init {

        dialogTwo.requestWindowFeature(Window.FEATURE_NO_TITLE)
//        dialogTwo.window?.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE)
        dialogTwo.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialogTwo.setCancelable(false)
        dialogTwo.setContentView(R.layout.dialog_two)
        dialogTitle = dialogTwo.findViewById(R.id.headerText2) as TextView
        dialogHeaderImage = dialogTwo.findViewById(R.id.imageHead_dia2) as ImageView
        dialogDescription = dialogTwo.findViewById(R.id.description2) as TextView
        dialogPositiveButton = dialogTwo.findViewById(R.id.positiveButton2) as Button
        dialogNegativeButton = dialogTwo.findViewById(R.id.negativeButton2) as Button

    }

    fun two(
        title: String,
        headerImage: Int? = null,
        description: String,
        titleOfPositiveButton: String? = null,
        titleOfNegativeButton: String? = null,
        positiveButtonFunction: (() -> Unit)? = null,
        negativeButtonFunction: (() -> Unit)? = null
    ) {
        headerImage?.let { dialogHeaderImage.setImageResource(it) }

        dialogTitle.text = title
        dialogDescription.text = description
        titleOfPositiveButton?.let { dialogPositiveButton.text = it } ?: dialogPositiveButton.text
        titleOfNegativeButton?.let { dialogNegativeButton.text = it } ?: dialogNegativeButton.text

        if (positiveButtonFunction?.invoke() == null) dialogPositiveButton.visibility =
            View.INVISIBLE
        if (negativeButtonFunction?.invoke() == null) dialogNegativeButton.visibility =
            View.INVISIBLE

        dialogPositiveButton.setOnClickListener {
            positiveButtonFunction?.invoke()
            dialogTwo.dismiss()
        }
        dialogNegativeButton.setOnClickListener {
            negativeButtonFunction?.invoke()
            dialogTwo.dismiss()
        }
        dialogHeaderImage.startAnimation(
            AnimationUtils.loadAnimation(
                context,
                R.anim.bounce
            )
        )

        dialogTwo.show()

    }


    fun simple(
        title: String,
        headerImage: Int? = null,
        description: String,
        titleOfPositiveButton: String? = null,
        titleOfNegativeButton: String? = null,
        positiveButtonFunction: (() -> Unit)? = null,
        negativeButtonFunction: (() -> Unit)? = null
    ) {
        dialogTitle.text = title
        dialogPositiveButton.text = "OK"
        dialogNegativeButton.text = "Ignore"
        dialogHeaderImage.setImageResource(android.R.drawable.btn_star_big_on)
        dialogDescription.text = description
        headerImage?.let { dialogHeaderImage.setImageResource(it) }
        titleOfPositiveButton?.let { dialogPositiveButton.text = it } ?: dialogPositiveButton.text
        titleOfNegativeButton?.let { dialogNegativeButton.text = it } ?: dialogNegativeButton.text
        dialogPositiveButton.setOnClickListener {
            positiveButtonFunction?.invoke()
            dialogTwo.dismiss()

        }
        dialogNegativeButton.visibility = View.VISIBLE
        dialogPositiveButton.visibility = View.VISIBLE
        dialogNegativeButton.setOnClickListener {
            negativeButtonFunction?.invoke()
            dialogTwo.dismiss()

        }
        dialogHeaderImage.startAnimation(
            AnimationUtils.loadAnimation(
                context,
                R.anim.bounce
            )
        )
        dialogTitle.startAnimation(
            AnimationUtils.loadAnimation(
                context,
                R.anim.move_rl
            )
        )
        dialogTwo.show()
    }


}