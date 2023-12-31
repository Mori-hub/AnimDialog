package com.src.anim

import android.annotation.SuppressLint
import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.core.view.isVisible

@SuppressLint("SetTextI18n")
class AnimDialog(private val context: Context) {
    private val dialog = Dialog(context)
    private val dialogCardView: RelativeLayout
    private val dialogHeaderImage: ImageView
    private val dialogDescription: TextView
    private val dialogPositiveButton: Button
    private val dialogNegativeButton: Button
    private val dialogMiddleButton: Button
    private val userGiven = arrayListOf<String>()
    private var applyToAll: Boolean = false

    init {

        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
//        dialog.window?.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.dialog_one)
        dialogCardView = dialog.findViewById(R.id.mainLayout_dia)
        dialogHeaderImage = dialog.findViewById(R.id.imageHead_dia) as ImageView
        dialogDescription = dialog.findViewById(R.id.description) as TextView
        dialogPositiveButton = dialog.findViewById(R.id.positiveButton) as Button
        dialogNegativeButton = dialog.findViewById(R.id.negativeButton) as Button
        dialogMiddleButton = dialog.findViewById(R.id.middleButton) as Button
        dialogHeaderImage.startAnimation(
            AnimationUtils.loadAnimation(
                context,
                R.anim.bounce
            )
        )
    }

    fun dialogTheme(
        applyToAll: Boolean,
        mainBackColor: String,
        dscBackColor: String,
        desTextColor: String,
        buttonsColor: String,
        buttonTextColor: String
    ) {
        this.applyToAll = applyToAll
        userGiven.add(mainBackColor)
        userGiven.add(dscBackColor)
        userGiven.add(desTextColor)
        userGiven.add(buttonsColor)
        userGiven.add(buttonTextColor)
        applyTheme()
    }

    private fun applyTheme() {
        if (applyToAll) {
            dialogHeaderImage.backgroundTintList =
                ColorStateList.valueOf(Color.parseColor(userGiven[0]))
            dialogCardView.backgroundTintList =
                ColorStateList.valueOf(Color.parseColor(userGiven[0]))

            dialogDescription.backgroundTintList =
                ColorStateList.valueOf(Color.parseColor(userGiven[1]))

            dialogDescription.setTextColor(Color.parseColor(userGiven[2]))

            dialogPositiveButton.backgroundTintList =
                ColorStateList.valueOf(Color.parseColor(userGiven[3]))
            dialogNegativeButton.backgroundTintList =
                ColorStateList.valueOf(Color.parseColor(userGiven[3]))
            dialogMiddleButton.backgroundTintList =
                ColorStateList.valueOf(Color.parseColor(userGiven[3]))

            dialogPositiveButton.setTextColor(Color.parseColor(userGiven[4]))
            dialogNegativeButton.setTextColor(Color.parseColor(userGiven[4]))
            dialogMiddleButton.setTextColor(Color.parseColor(userGiven[4]))
        }
    }

    fun simple(
        headerImage: Int,
        description: String,
        titleOfPositiveButton: String,
        titleOfNegativeButton: String,
        positiveButtonFunction: (() -> Unit)? = null,
        negativeButtonFunction: (() -> Unit)? = null
    ) {
        headerImage.let { dialogHeaderImage.setImageResource(it) }
        dialogDescription.text = description
        titleOfPositiveButton.let { dialogPositiveButton.text = it }
        titleOfNegativeButton.let { dialogNegativeButton.text = it }
        dialogPositiveButton.setOnClickListener {
            positiveButtonFunction?.invoke()
            dialog.dismiss()
            clean()
            applyTheme()
        }
        dialogNegativeButton.visibility = View.VISIBLE
        dialogPositiveButton.visibility = View.VISIBLE
        dialogNegativeButton.setOnClickListener {
            negativeButtonFunction?.invoke()
            dialog.dismiss()
            clean()
            applyTheme()
        }
        dialogHeaderImage.startAnimation(
            AnimationUtils.loadAnimation(
                context,
                R.anim.bounce
            )
        )
        dialog.show()
    }

    fun welcome(
        description: String,
        titleOfPositiveButton: String? = null, positiveButtonFunction: (() -> Unit)? = null
    ) {
        dialogMiddleButton.text = "Let's start"

        dialogHeaderImage.setImageResource(R.drawable.welcome)
        dialogDescription.text = description
        titleOfPositiveButton?.let { dialogMiddleButton.text = it }
        dialogNegativeButton.visibility = View.INVISIBLE
        dialogPositiveButton.visibility = View.INVISIBLE
        dialogMiddleButton.visibility = View.VISIBLE
        dialogMiddleButton.setOnClickListener {
            positiveButtonFunction?.invoke()
            dialog.dismiss()
            clean()
        }
        dialogHeaderImage.startAnimation(
            AnimationUtils.loadAnimation(
                context,
                R.anim.bounce
            )
        )
        dialog.show()

    }

    fun exit(
        description: String,
        titleOfPositiveButton: String? = null,
        titleOfNegativeButton: String? = null,
        positiveButtonFunction: (() -> Unit)? = null, activity: Activity
    ) {
        dialogPositiveButton.text = "Exit"
        dialogNegativeButton.text = "Back"
        dialogHeaderImage.setImageResource(R.drawable.bye)
        dialogDescription.text = description
        titleOfPositiveButton?.let { dialogPositiveButton.text = it } ?: dialogPositiveButton.text
        titleOfNegativeButton?.let { dialogNegativeButton.text = it } ?: dialogNegativeButton.text
        dialogPositiveButton.visibility = View.VISIBLE
        dialogPositiveButton.setOnClickListener {
            positiveButtonFunction?.invoke()
            activity.finish()
            dialog.dismiss()
            clean()
        }
        dialogNegativeButton.visibility = View.VISIBLE

        dialogNegativeButton.setOnClickListener {
            dialog.dismiss()
            clean()
        }
        dialogHeaderImage.startAnimation(
            AnimationUtils.loadAnimation(
                context,
                R.anim.bounce
            )
        )
        dialog.show()
    }

    fun rate(
        description: String,
        titleOfPositiveButton: String? = null,
        titleOfNegativeButton: String? = null,
        positiveButtonFunction: (() -> Unit)? = null
    ) {
        dialogPositiveButton.text = "Rate Now"
        dialogNegativeButton.text = "Maybe Later"
        dialogHeaderImage.setImageResource(R.drawable.rate)
        dialogDescription.text = description
        titleOfPositiveButton?.let { dialogPositiveButton.text = it } ?: dialogPositiveButton.text
        titleOfNegativeButton?.let { dialogNegativeButton.text = it } ?: dialogNegativeButton.text
        dialogPositiveButton.setOnClickListener {
            positiveButtonFunction?.invoke()
            dialog.dismiss()
            clean()
        }
        dialogNegativeButton.visibility = View.VISIBLE
        dialogPositiveButton.visibility = View.VISIBLE
        dialogNegativeButton.setOnClickListener {
            dialog.dismiss()
            clean()
        }
        dialogHeaderImage.startAnimation(
            AnimationUtils.loadAnimation(
                context,
                R.anim.bounce
            )
        )
        dialog.show()
        clean()
    }

    fun info(
        description: String,
        titleOfPositiveButton: String? = null,
        positiveButtonFunction: (() -> Unit)? = null
    ) {
        dialogPositiveButton.text = "Got it"
        dialogHeaderImage.setImageResource(R.drawable.info)
        dialogDescription.text = description
        titleOfPositiveButton.let { dialogMiddleButton.text = it }
        dialogNegativeButton.visibility = View.INVISIBLE
        dialogPositiveButton.visibility = View.INVISIBLE
        dialogMiddleButton.visibility = View.VISIBLE
        dialogMiddleButton.setOnClickListener {
            positiveButtonFunction?.invoke()
            dialog.dismiss()
            clean()
        }
        dialogHeaderImage.startAnimation(
            AnimationUtils.loadAnimation(
                context,
                R.anim.bounce
            )
        )
        dialog.show()
    }

    fun warning(
        description: String,
        titleOfPositiveButton: String? = null,
        titleOfNegativeButton: String? = null,
        positiveButtonFunction: (() -> Unit)? = null
    ) {
        dialogPositiveButton.text = "Accept"
        dialogNegativeButton.text = "Ignore"
        dialogHeaderImage.setImageResource(R.drawable.warning)
        dialogDescription.text = description
        titleOfPositiveButton?.let { dialogPositiveButton.text = it } ?: dialogPositiveButton.text
        titleOfNegativeButton?.let { dialogNegativeButton.text = it } ?: dialogNegativeButton.text
        dialogPositiveButton.setOnClickListener {
            positiveButtonFunction?.invoke()
            dialog.dismiss()
            clean()
        }
        dialogNegativeButton.visibility = View.VISIBLE
        dialogPositiveButton.visibility = View.VISIBLE
        dialogNegativeButton.setOnClickListener {
            dialog.dismiss()
            clean()
        }
        dialogHeaderImage.startAnimation(
            AnimationUtils.loadAnimation(
                context,
                R.anim.bounce
            )
        )
        dialog.show()
    }


    fun del(
        description: String,
        titleOfPositiveButton: String? = null,
        titleOfNegativeButton: String? = null,
        positiveButtonFunction: (() -> Unit)? = null
    ) {
        dialogPositiveButton.text = "Delete it"
        dialogNegativeButton.text = "Ignore"
        dialogHeaderImage.setImageResource(R.drawable.del_bin)
        dialogDescription.text = description
        titleOfPositiveButton?.let { dialogPositiveButton.text = it } ?: dialogPositiveButton.text
        titleOfNegativeButton?.let { dialogNegativeButton.text = it } ?: dialogNegativeButton.text
        dialogPositiveButton.setOnClickListener {
            positiveButtonFunction?.invoke()
            dialog.dismiss()
            clean()
        }
        dialogNegativeButton.visibility = View.VISIBLE
        dialogPositiveButton.visibility = View.VISIBLE
        dialogNegativeButton.setOnClickListener {
            dialog.dismiss()
            clean()
        }
        dialogHeaderImage.startAnimation(
            AnimationUtils.loadAnimation(
                context,
                R.anim.bounce
            )
        )
        dialog.show()
    }

    private fun clean() {
        if (!dialog.isShowing) {
            dialogMiddleButton.text = ""
            dialogPositiveButton.text = ""
            dialogNegativeButton.text = ""

            if (dialogMiddleButton.isVisible) dialogMiddleButton.visibility = View.INVISIBLE
        }
    }
}