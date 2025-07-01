package com.contentsquare.android.sample

import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.contentsquare.CSQ
import com.contentsquare.android.sample.analytics.Analytics
import com.contentsquare.android.sample.fragment.BottomSheetFragment
import com.contentsquare.android.sample.fragment.CustomAlertDialog
import com.contentsquare.android.sample.fragment.DatePickerFragment
import com.contentsquare.android.sample.fragment.TimePickerFragment
import com.contentsquare.api.sessionreplay.csqMaskPositiveButton
import com.contentsquare.api.sessionreplay.csqMaskTitle
import java.util.Locale

class SimpleActivity : AppCompatActivity() {

    private val TAG: String? = SimpleActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simple)
    }

    override fun onResume() {
        super.onResume()
        Analytics.trackScreen("Simple-Activity")
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.simple_menu, menu)

        // Apply masking for menu items here
        CSQ.unmaskMenuItem(R.id.menu_unmasked_item)
        CSQ.maskMenuItem(R.id.menu_masked_item)
        Analytics.trackScreen("Simple_Menu")

        return super.onCreateOptionsMenu(menu)
    }

    fun openBottomSheets(view: View) {
        val bottomSheetFragment = BottomSheetFragment()
        bottomSheetFragment.show(supportFragmentManager, bottomSheetFragment.tag)
        Analytics.trackScreen("Bottom_Sheets")
    }

    fun openDatePicker(view: View) {
        val datePickerFragment = DatePickerFragment { year, month, day ->
            val formattedDate = "$day/${month + 1}/$year"
            Log.i(TAG, "Selected Date: $formattedDate")
        }
        datePickerFragment.show(supportFragmentManager, "datePicker")
        Analytics.trackScreen("Date_Picker")
    }

    fun openTimePicker(view: View) {
        val timePickerFragment = TimePickerFragment { hour, minute ->
            val formattedTime = String.format(Locale.ROOT, "%02d:%02d", hour, minute)
            Log.i(TAG, "Selected Time: $formattedTime")
        }
        timePickerFragment.show(supportFragmentManager, "timePicker")
        Analytics.trackScreen("Time_Picker")
    }

    fun openAlertDialog(view: View) {
        val builder: AlertDialog.Builder = AlertDialog.Builder(this@SimpleActivity)
        builder.setMessage(getString(R.string.alert_message))
        builder.setTitle(getString(R.string.alert_title))
        builder.setCancelable(true)
        builder.setPositiveButton(getString(R.string.ok)) { dialog: DialogInterface?, _: Int ->
            dialog?.cancel()
        }
        val alertDialog: AlertDialog = builder.create()
        alertDialog.show()

        // Apply Masking only after the show() is called
        alertDialog.csqMaskTitle()
        alertDialog.csqMaskPositiveButton()
        Analytics.trackScreen("Simple_Dialog")
    }

    fun openCustomAlertDialog(view: View) {
        val dialog = CustomAlertDialog(
            context = this,
            message = getString(R.string.sense_ai_description_short),
            imageResId = R.drawable.sense_ai_image,
            onOkPressed = {
                Log.i(TAG, "CustomAlertDialog: OK button tapped")
            }
        )
        dialog.show()
        Analytics.trackScreen("Simple_Custom_Dialog")
    }
}
