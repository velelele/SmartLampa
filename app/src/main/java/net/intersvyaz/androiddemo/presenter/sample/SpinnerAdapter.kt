package net.intersvyaz.androiddemo.presenter.sample

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import net.intersvyaz.androiddemo.R

class SpinnerAdapter(private val context: Context, private val data: List<String>) : BaseAdapter() {

    override fun getCount(): Int {
        return data.size
    }

    override fun getItem(position: Int): Any {
        return data[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val textView = TextView(context)
        textView.text = data[position]
        textView.setPadding(16, 16, 16, 16)
        return textView
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val textView = TextView(context)
        textView.text = data[position]
        textView.setPadding(16, 16, 16, 16)
        return textView
    }
}
