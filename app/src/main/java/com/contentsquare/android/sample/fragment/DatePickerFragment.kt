package com.contentsquare.android.sample.fragment

import android.app.DatePickerDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import com.contentsquare.api.sessionreplay.csqMaskButtonPanel
import com.contentsquare.api.sessionreplay.csqUnmaskHeader
import java.util.Calendar

class DatePickerFragment(private val onDateSelected: (year: Int, month: Int, day: Int) -> Unit) :
    DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        return DatePickerDialog(requireContext(), { _, selectedYear, selectedMonth, selectedDay ->
            onDateSelected(selectedYear, selectedMonth, selectedDay)
        }, year, month, day).also {
            it.csqMaskButtonPanel()
            it.csqUnmaskHeader()
        }
    }
}
