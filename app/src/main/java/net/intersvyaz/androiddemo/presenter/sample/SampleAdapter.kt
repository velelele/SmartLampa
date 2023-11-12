package net.intersvyaz.androiddemo.presenter.sample

import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SampleAdapter : RecyclerView.Adapter<SampleAdapter.SampleViewHolder>() {

    private val list = mutableListOf<String>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SampleViewHolder {
        val context = parent.context
        val textView = TextView(context)
        return SampleViewHolder(textView)
    }

    override fun getItemCount(): Int =
        list.size

    override fun onBindViewHolder(holder: SampleViewHolder, position: Int) {
        holder.textView.text = list[position]
    }

    fun submitList(list: List<String>) {
        with(this.list) {
            clear()
            addAll(list)
        }
        notifyDataSetChanged()
    }

    class SampleViewHolder(
        val textView: TextView
    ) : RecyclerView.ViewHolder(textView)
}
