package com.example.demo.recyclerview.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import android.widget.TextView
import com.example.androidproject.databinding.ItemListGroupBinding
import com.example.androidproject.databinding.ItemListItemsBinding

class ExpandableListAdapter(
    context: Context,
    private val titleList: List<String>,
    private val dataList: HashMap<String, List<String>>
) :
    BaseExpandableListAdapter() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private lateinit var groupBinding: ItemListGroupBinding
    private lateinit var itemsBinding: ItemListItemsBinding

    override fun getGroupCount(): Int {
        return titleList.size
    }

    override fun getChildrenCount(p0: Int): Int {
        return dataList[titleList[p0]]?.size ?: 0
    }

    override fun getGroup(p0: Int): Any {
        return titleList[p0]
    }

    override fun getChild(p0: Int, p1: Int): Any {
        return dataList[titleList[p0]]?.get(p1) ?: 0
    }

    override fun getGroupId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getChildId(p0: Int, p1: Int): Long {
        return p1.toLong()
    }

    override fun hasStableIds(): Boolean {
        return false
    }

    override fun getGroupView(p0: Int, p1: Boolean, p2: View?, p3: ViewGroup?): View {
        var convertView = p2
        val holder: GroupViewHolder
        if (convertView == null) {
            groupBinding = ItemListGroupBinding.inflate(inflater)
            convertView = groupBinding.root
            holder = GroupViewHolder(groupBinding.titleText)
            holder.label.text = titleList[p0]
            convertView.tag = holder
        } else {
            holder = convertView.tag as GroupViewHolder
        }
        val listTitle = getGroup(p0) as String
        holder.label.text = listTitle
        return convertView
    }

    override fun getChildView(p0: Int, p1: Int, p2: Boolean, p3: View?, p4: ViewGroup?): View {
        var convertView = p3
        val holder: ItemViewHolder
        if (convertView == null) {
            itemsBinding = ItemListItemsBinding.inflate(inflater)
            convertView = itemsBinding.root
            holder = ItemViewHolder(itemsBinding.subTitle)
            holder.label.text = titleList[p0]
            convertView.tag = holder
        } else {
            holder = convertView.tag as ItemViewHolder
        }
        val expandedListText = getChild(p0, p1) as String
        holder.label!!.text = expandedListText
        return convertView

    }

    override fun isChildSelectable(p0: Int, p1: Int): Boolean {
        return true
    }

    class GroupViewHolder(var label: TextView)

    class ItemViewHolder(var label: TextView)
}