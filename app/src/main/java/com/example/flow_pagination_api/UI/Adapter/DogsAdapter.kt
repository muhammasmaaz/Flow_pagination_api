package com.example.flow_pagination_api.UI.Adapter

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.flow_pagination_api.R
import com.example.flow_pagination_api.UI.DogsDetail
import com.example.flow_pagination_api.UI.data.Dogs
import com.example.flow_pagination_api.databinding.EachRowBinding
import javax.inject.Inject


class DogsAdapter @Inject constructor():PagingDataAdapter<Dogs,DogsAdapter.DogsViewHolder>(diff) {




    class DogsViewHolder(private val binding: EachRowBinding):RecyclerView.ViewHolder(binding.root){

        fun bind(dogs: Dogs){
            binding.apply {
                image.load(dogs.url)


                itemView.setOnClickListener {

                    image.load(R.drawable.ic_launcher_background)
                    Log.d("dogs-adapter","item clicked")
                    Toast.makeText(itemView.context, "view clicked", Toast.LENGTH_SHORT).show()

                }

            }

        }
    }




    override fun onBindViewHolder(holder: DogsViewHolder, position: Int) {
        val dogs=getItem(position)
        if (dogs!=null){
            holder.bind(dogs)
        }

        holder.itemView.setOnClickListener {
            Toast.makeText(holder.itemView.context,"Dogs pic No:"+position,Toast.LENGTH_SHORT).show()
            val intent = Intent(holder.itemView.context, DogsDetail::class.java)
            holder.itemView.context?.startActivity(intent)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogsViewHolder {
        return DogsViewHolder(EachRowBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }




    //recyclerview ki performance ko increases karny kam karta
    object diff:DiffUtil.ItemCallback<Dogs>(){
        override fun areItemsTheSame(oldItem: Dogs, newItem: Dogs): Boolean =
            oldItem.url==newItem.url

        override fun areContentsTheSame(oldItem: Dogs, newItem: Dogs): Boolean =
            oldItem.url==newItem.url

    }
}