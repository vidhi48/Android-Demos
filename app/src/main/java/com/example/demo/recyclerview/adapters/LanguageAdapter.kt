package com.example.demo.recyclerview.adapters

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.androidproject.R

class LanguageAdapter(
    private val context: Activity,
    private val languageProfile: List<Int>,
    private val langName: List<String>,
    private val ratings: List<Int>
) : ArrayAdapter<String>(context, R.layout.item_list_language, langName) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val inflater = context.layoutInflater
        val rowView = inflater.inflate(R.layout.item_list_language, null, true)

        val profile = rowView.findViewById<ImageView>(R.id.languageProfile)
        val title = rowView.findViewById<TextView>(R.id.language)
        val description = rowView.findViewById<TextView>(R.id.description)

        profile.setImageResource(languageProfile[position])
        title.text = langName[position]
        description.text = ratings[position].toString()

        return rowView
    }
}

