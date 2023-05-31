package com.example.room_salma_xirpl3_23

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.room_salma_xirpl3_23.dataroom.user

class Adapter_Activity(private val list: ArrayList<user>, private val listener: onAdapterListener)
    : RecyclerView.Adapter<Adapter_Activity.ViewHolder>() {
    class ViewHolder(view: View):RecyclerView.ViewHolder(view){
        val id = itemView.findViewById<TextView>(R.id.txtid)
        val nama = itemView.findViewById<TextView>(R.id.txtusername)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.activity_adapter, parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user = list [position]
        holder.id.text = user.iduser.toString()
        holder.nama.text = user.namauser.toString()
        holder.id.setOnClickListener {
            listener.onClick(user)
        }
    }

    override fun getItemCount() = list.size
    fun setdata(listData: List<user>){
        list.clear()
        list.addAll(listData)
        notifyDataSetChanged()

    }

    interface onAdapterListener{
        fun onClick(
            user: user
        )
    }
    }
