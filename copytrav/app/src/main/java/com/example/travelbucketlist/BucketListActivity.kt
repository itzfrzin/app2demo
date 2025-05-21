package com.example.travelbucketlist

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity

class BucketListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        // Apply saved theme before super.onCreate or after is fine
        ThemeHelper.applyTheme(this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bucket_list)

        // Show back button on action bar
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val listView = findViewById<ListView>(R.id.listViewBucket)
        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, MainActivity.bucketList)
        listView.adapter = adapter
    }

    // Handle back button in action bar
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                finish()  // go back to previous activity (MainActivity)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
