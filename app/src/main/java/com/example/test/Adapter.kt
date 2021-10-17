package com.example.test

import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class Adapter(var list : List<Model>, var etOnClick: onClickEditText) : ListAdapter<Model, Adapter.MainAdapterViewHolder>(DiffUtils()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainAdapterViewHolder {
        val view =  LayoutInflater.from(parent.context).inflate(R.layout.user_profile_pet_name_item,parent,false)
        return MainAdapterViewHolder(view, etOnClick)
    }

    override fun onBindViewHolder(holder: MainAdapterViewHolder, position: Int) {
        val item = list[position]
        holder.addPetName.setText(item.name)
    }

    override fun getItemCount(): Int {
        /*if(list.size == 1){
            return list.size
        }
        else{
            return list.size-1
        }*/
        return list.size
    }

    class MainAdapterViewHolder(itemView: View, etOnClick: onClickEditText): RecyclerView.ViewHolder(itemView){
        val addPetName = itemView.findViewById<EditText>(R.id.et_pet_name_item)

        init {
            addPetName.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(
                    s: CharSequence?,
                    start: Int,
                    count: Int,
                    after: Int
                ) {}

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

                override fun afterTextChanged(s: Editable?) {
                    etOnClick.editTextClicked(s.toString())
                }
            })
        }

    }

    class DiffUtils : DiffUtil.ItemCallback<Model>() {
        override fun areItemsTheSame(oldItem: Model, newItem: Model): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Model, newItem: Model): Boolean {
            return oldItem == newItem
        }
    }

    interface onClickEditText {
        fun editTextClicked(text: String)
    }

}