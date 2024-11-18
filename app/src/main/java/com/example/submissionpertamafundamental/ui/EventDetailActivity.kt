package com.example.submissionpertamafundamental.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.text.HtmlCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import com.example.submissionpertamafundamental.R
import com.example.submissionpertamafundamental.databinding.ActivityEventDetailBinding

class EventDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_event_detail)

        val tvImageDetail: ImageView = findViewById(R.id.tvImageDetail)
        val tvEventName: TextView = findViewById(R.id.tvEventName)
        val tvDescription: TextView = findViewById(R.id.tvDescription)
        val btnOpenLink: Button = findViewById(R.id.btnOpenLink)

        val eventName = intent.getStringExtra("EVENT_NAME")
        val eventDescription = intent.getStringExtra("EVENT_DESCRIPTION")
        val eventImage = intent.getStringExtra("EVENT_IMAGE")
        val eventLink = intent.getStringExtra("EVENT_LINK")

        tvEventName.text = eventName
        tvDescription.text = HtmlCompat.fromHtml(
            eventDescription ?: "",
            HtmlCompat.FROM_HTML_MODE_LEGACY
        )
        Glide.with(this).load(eventImage).into(tvImageDetail)

        btnOpenLink.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(eventLink))
            startActivity(intent)
        }
    }
}