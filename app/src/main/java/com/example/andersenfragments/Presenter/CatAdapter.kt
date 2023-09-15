package com.example.andersenfragments.Presenter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.andersenfragments.Data.Cat
import com.example.andersenfragments.databinding.CatItemBinding

class CatAdapter(
    private var catList: List<Cat>,
    private var clickFirstFragment: ClickFirstFragment
) :
    RecyclerView.Adapter<CatAdapter.CatViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatViewHolder {
        val binding = CatItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CatViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return catList.size
    }

    override fun onBindViewHolder(holder: CatViewHolder, position: Int) {
        val item = catList[position]
        holder.bind(catList[position])
        holder.catItemBinding.catItemSingle.setOnClickListener {
            clickFirstFragment.onClick(item)
        }
    }

    fun addData(newCatList: List<Cat>) {

        val diffCallBack = MovieDiffUtil(catList, newCatList)
        val difference = DiffUtil.calculateDiff(diffCallBack, true)
        catList = newCatList.toMutableList()
        difference.dispatchUpdatesTo(this)

    }

    class CatViewHolder(
        val catItemBinding: CatItemBinding,
    ) :
        RecyclerView.ViewHolder(catItemBinding.root) {
        fun bind(cat: Cat) {
            catItemBinding.id.text = cat.id.toString()
            catItemBinding.name.text = cat.name
            catItemBinding.surname.text = cat.surname
            catItemBinding.phone.text = cat.phone.toString()


        }


    }

    class MovieDiffUtil(private val oldList: List<Cat>, private val newList: List<Cat>) :
        DiffUtil.Callback() {
        override fun getOldListSize(): Int {
            return oldList.size
        }

        override fun getNewListSize(): Int {
            return newList.size
        }

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldList[oldItemPosition].id == newList[newItemPosition].id
        }

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldList[oldItemPosition] == newList[newItemPosition]
        }
    }
}