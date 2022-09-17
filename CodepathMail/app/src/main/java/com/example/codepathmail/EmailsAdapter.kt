package com.example.codepathmail

import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class EmailsAdapter(private val emails: List<Email>) : RecyclerView.Adapter<EmailsAdapter.ViewHolder>() {
    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        // TODO: Create member variables for any view that will be set
        // as you render a row.
        val senderTextView: TextView
        val titleTextView: TextView
        val summaryTextView: TextView

        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each sub-view
        init {
            // TODO: Store each of the layout's views into
            // the public final member variables created above
            senderTextView = itemView.findViewById(R.id.senderTextView)
            titleTextView = itemView.findViewById(R.id.titleTextView)
            summaryTextView = itemView.findViewById(R.id.summaryTextView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        // Inflate the custom layout
        val contactView = inflater.inflate(R.layout.email_item, parent, false)
        // Return a new holder instance
        return ViewHolder(contactView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Get the data model based on position
        val email = emails[position]
        // Set item views based on views and data model
        holder.senderTextView.text = email.sender
        holder.titleTextView.text = email.title
        holder.summaryTextView.text = email.summary

        // check if email is read/unread
        val isEmailRead = email.isRead
        // if unread, bold all textviews
        if (!isEmailRead){
            holder.senderTextView.setTypeface(
                holder.senderTextView.typeface, Typeface.BOLD_ITALIC
            )
            holder.titleTextView.setTypeface(
                holder.titleTextView.typeface, Typeface.BOLD_ITALIC
            )
            holder.summaryTextView.setTypeface(
                holder.summaryTextView.typeface, Typeface.BOLD_ITALIC
            )
        }
    }

    override fun getItemCount(): Int {
        return emails.size
    }
}