package com.example.praktika8

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(private val taskList : ArrayList<Tasks>) :
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
    private lateinit var mListener : onItemClickListener
    interface onItemClickListener{
        fun onItemClick(position : Int)
    }
    fun setOnItemClickListener(listener: onItemClickListener){
        mListener=listener
    }
    class MyViewHolder(itemView : View, listener: onItemClickListener) : RecyclerView.ViewHolder(itemView){
        val titleView: TextView =itemView.findViewById(R.id.task_title)
        val dateView: TextView = itemView.findViewById(R.id.task_date)
        val timeView: TextView=itemView.findViewById(R.id.task_hour)
        val descView: TextView=itemView.findViewById(R.id.task_desc)
        init {
            itemView.setOnClickListener{
                listener.onItemClick(adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView= LayoutInflater.from(parent.context).inflate(R.layout.taska,parent,false)
        return MyViewHolder(itemView, mListener)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem=taskList[position]
        holder.titleView.text=currentItem.title
        holder.dateView.text=currentItem.date
        holder.timeView.text=currentItem.time
        holder.descView.text=currentItem.description
    }

    override fun getItemCount(): Int {
        return taskList.size
    }
}