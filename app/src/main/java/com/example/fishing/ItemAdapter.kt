package com.example.fishing

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class ItemAdapter (listArray:ArrayList<FishDescription>, context:Context) :RecyclerView.Adapter<ItemAdapter.ViewHolder>()
{
    var listArrayR = listArray
    var contextR = context

    class ViewHolder(view: View):RecyclerView.ViewHolder(view) {
        val tvTitle = view.findViewById<TextView>(R.id.tvItemTitle)
        val tvDescr = view.findViewById<TextView>(R.id.itemDescr)
        val imgF = view.findViewById<ImageView>(R.id.imgFish)
        fun bind(fishDescription: FishDescription, context: Context)
        {
            tvTitle.text = fishDescription.titleText
            var textCon = fishDescription.contentText.substring(0..50)+"..."
            tvDescr.text = textCon
            imgF.setImageResource(fishDescription.imgID)
            itemView.setOnClickListener {
                Toast.makeText(context, "Pressed ${tvTitle.text} ", Toast.LENGTH_SHORT).show()
                val intent = Intent(context,ContentActivity::class.java).apply {
                    putExtra("title",tvTitle.text)
                    putExtra("content",fishDescription.contentText)
                    putExtra("img",fishDescription.imgID)
                }
                context.startActivity(intent)
            }
            
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater  = LayoutInflater.from(contextR)
        return ViewHolder(inflater.inflate(R.layout.item_layout,parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var listItem =listArrayR[position]
        holder.bind(listItem,contextR)
    }

    override fun getItemCount(): Int {
        return listArrayR.size
    }
    fun updateAdapter(list:ArrayList<FishDescription>)
    {
        listArrayR.clear()
        listArrayR.addAll(list)
        notifyDataSetChanged()
    }

}