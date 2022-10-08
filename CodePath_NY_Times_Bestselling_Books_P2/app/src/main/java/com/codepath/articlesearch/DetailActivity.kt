package com.codepath.articlesearch

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

private const val TAG = "DetailActivity"

class DetailActivity : AppCompatActivity() {
    private lateinit var mediaImageView: ImageView
    private lateinit var titleTextView: TextView
    private lateinit var bylineTextView: TextView
    private lateinit var abstractTextView: TextView
    private lateinit var returnButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        // TODO: Find the views for the screen
        mediaImageView = findViewById(R.id.mediaImage)
        titleTextView = findViewById(R.id.mediaTitle)
        bylineTextView = findViewById(R.id.mediaByline)
        abstractTextView = findViewById(R.id.mediaAbstract)
        returnButton = findViewById(R.id.returnBtn)

        // TODO: Get the extra from the Intent
        val article = intent.getSerializableExtra(ARTICLE_EXTRA) as DisplayArticle

        // TODO: Set the title, byline, and abstract information from the article
//        titleTextView.text = article.headline?.main
//        bylineTextView.text = article.byline?.original    // from lab 4
        titleTextView.text = article.headline
        bylineTextView.text = article.byline
        abstractTextView.text = article.abstract

        // TODO: Load the media image
        Glide.with(this)
            .load(article.mediaImageUrl)
            .placeholder(R.drawable.ic_launcher_foreground_teal)
            .error(R.drawable.ic_launcher_foreground_purple)
            .into(mediaImageView)

        // TODO: return to previous (main) page
        returnButton.setOnClickListener {
            finish()
        }
    }
}