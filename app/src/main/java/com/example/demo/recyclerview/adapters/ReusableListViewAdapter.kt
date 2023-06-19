package com.example.demo.recyclerview.adapters

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.example.androidproject.R

class ReusableListViewAdapter(
    private val context: Activity,
    private val languageProfile: List<Int>,
    private val langName: List<String>,
    private val ratings: List<Int>
) : ArrayAdapter<String>(context, R.layout.item_list_language, langName) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val holder: com.example.demo.recyclerview.models.ViewHolder
        val view: View
        if (convertView == null) {
            val inflater = LayoutInflater.from(context)
            view = inflater.inflate(R.layout.item_list_language, parent, false)
            holder = com.example.demo.recyclerview.models.ViewHolder()
            holder.languageProfile = view.findViewById(R.id.languageProfile)
            holder.languageName = view.findViewById(R.id.language)
            holder.ratings = view.findViewById(R.id.description)

            view.tag = holder
        } else {
            view = convertView
            holder = convertView.tag as com.example.demo.recyclerview.models.ViewHolder
        }
        holder.languageProfile.setImageResource(languageProfile[position])
        holder.languageName.text = langName[position]
        holder.ratings.text = ratings[position].toString()
        return view
    }
}
