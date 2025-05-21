package com.example.travelbucketlist

import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SettingsActivity : AppCompatActivity() {

    private lateinit var radioGroup: RadioGroup
    private lateinit var buttonSave: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        // Apply saved theme before super.onCreate
        ThemeHelper.applyTheme(this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        // Show back button in the action bar
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        radioGroup = findViewById(R.id.radioGroupTheme)
        buttonSave = findViewById(R.id.buttonSaveSettings)

        // Load saved preference using ThemeHelper
        val savedTheme = ThemeHelper.getSavedTheme(this)
        if (savedTheme == "Light") {
            radioGroup.check(R.id.radioLight)
        } else {
            radioGroup.check(R.id.radioDark)
        }

        buttonSave.setOnClickListener {
            val selectedId = radioGroup.checkedRadioButtonId
            val selectedRadioButton = findViewById<RadioButton>(selectedId)
            val theme = selectedRadioButton.text.toString()

            // Save preference using ThemeHelper
            ThemeHelper.saveTheme(this, theme)

            Toast.makeText(this, "Settings saved: $theme", Toast.LENGTH_SHORT).show()

            // Restart activity to apply new theme
            recreate()
        }
    }

    // Handle action bar back button
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
