package com.example.mangalib.presentation.ui.fragment.open

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.mangalib.databinding.ItemOpenBinding
import com.example.mangalib.domain.model.ResultModel

class OpenAdapter : RecyclerView.Adapter<OpenAdapter.OpenViewModel>() {
    private var list = arrayListOf<ResultModel>()
    var onClick: ((ResultModel) -> Unit)? = null
    var onLongClick: ((ResultModel) -> Unit)? = null

    inner class OpenViewModel(private val binding: ItemOpenBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(resultModel: ResultModel) {
            binding.image.load(resultModel.image)
            binding.year.text = resultModel.issue_year.toString()
            binding.type.text = resultModel.type
            binding.desc.text = resultModel.description

            itemView.setOnClickListener {
                onClick?.invoke(resultModel)
            }
            itemView.setOnLongClickListener {
                onLongClick?.invoke(resultModel)
                return@setOnLongClickListener true
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OpenViewModel {
        return OpenViewModel(
            ItemOpenBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: OpenViewModel, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun array(arrayList: List<ResultModel>) {
        list = arrayList as ArrayList<ResultModel>
    }
}