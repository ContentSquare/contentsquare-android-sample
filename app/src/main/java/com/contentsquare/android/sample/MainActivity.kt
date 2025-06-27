package com.contentsquare.android.sample

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.contentsquare.api.model.Currency
import com.contentsquare.android.sample.analytics.Analytics
import com.contentsquare.android.sample.crash.ErrorAnalysisCrashActivity
import com.contentsquare.android.sample.databinding.ActivityMainBinding
import com.contentsquare.android.sample.fragment.MainFragmentActivity
import com.contentsquare.android.sample.network.NetworkAnalysisActivity
import com.contentsquare.android.sample.useridentifier.UserIdentifierActivity
import com.contentsquare.api.model.Transaction

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
        Analytics.trackScreen("Main-Activity")
    }

    fun openActivity(view: View) {
        startActivity(Intent(this, SimpleActivity::class.java))
    }

    fun openFragment(view: View) {
        startActivity(Intent(this, MainFragmentActivity::class.java))
    }

    fun openPrivacyOptions(view: View) {
        startActivity(Intent(this, GdprActivity::class.java))
    }

    fun openNetworkAnalysis(view: View) {
        startActivity(Intent(this, NetworkAnalysisActivity::class.java))
    }

    fun openCrashActivity(view: View) {
        startActivity(Intent(this, ErrorAnalysisCrashActivity::class.java))
    }

    fun openUserIdentifier(view: View) {
        startActivity(Intent(this, UserIdentifierActivity::class.java))
    }

    fun openCustomVariables(view: View) {
        startActivity(Intent(this, CustomVariablesActivity::class.java))
    }

    fun openDynamicVariables(view: View) {
        startActivity(Intent(this, DynamicVariablesActivity::class.java))
    }

    fun openMaskingScenarios(view: View){
        startActivity(Intent(this, MaskingScenariosActivity::class.java))
    }

    fun openPopUp(view: View) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("App Bar color")
        builder.setMessage("Set the App bar color to RED?")

        builder.setPositiveButton("YES") { _, _ ->
            Toast.makeText(
                applicationContext, "Ok, we changed the App bar color.", Toast
                    .LENGTH_SHORT
            ).show()
            supportActionBar?.setBackgroundDrawable(ColorDrawable(Color.RED))
        }

        builder.setNegativeButton("No") { _, _ ->
            Toast.makeText(
                applicationContext, "Ok, back to its original color.", Toast
                    .LENGTH_SHORT
            )
                .show()
            supportActionBar?.setBackgroundDrawable(
                ContextCompat.getDrawable(
                    applicationContext,
                    R.color.purple_500
                )
            )
        }

        builder.setNeutralButton("Cancel") { _, _ ->
            Toast.makeText(applicationContext, "You cancelled the dialog.", Toast.LENGTH_SHORT)
                .show()
        }

        builder.setOnDismissListener {
            //After the Popup is dismissed. The base activity lifecycle remains the same, Therefore
            // we need to manually generate an activity ScreenView for the base Activity.
            Analytics.trackScreen("Main-Activity")
        }

        val dialog: AlertDialog = builder.create()
        dialog.show()
        Analytics.trackScreen("ActivityDialog_DialogShow")
    }

    fun openCompose(view: View) {
        startActivity(Intent(this, ComposeSimpleActivity::class.java))
    }

    fun pushTransaction(view: View) {
        val amount = 244.33f
        val currency = Currency.EUR
        val id = "123"
        val transaction = Transaction(amount, currency, id)
        Analytics.pushTransaction(transaction)
        Toast.makeText(
            applicationContext, "Transaction id $id is being tracked", Toast.LENGTH_SHORT
        ).show()
    }

    fun pushTransactionString(view: View) {
        val amount = 234.33f
        val currency = Currency.fromString("USD")
        val id = "456"
        val transaction = Transaction(amount, currency, id)
        Analytics.pushTransaction(transaction)
        Toast.makeText(
            applicationContext, "Transaction id $id is being tracked", Toast.LENGTH_SHORT
        ).show()
    }
}