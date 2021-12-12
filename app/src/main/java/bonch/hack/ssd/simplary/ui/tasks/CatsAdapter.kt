package bonch.hack.ssd.simplary.ui.tasks

import android.content.res.ColorStateList
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import bonch.hack.ssd.simplary.databinding.ItemTaskCategoryBinding
import bonch.hack.ssd.simplary.model.Category

class CatsAdapter(private val clickListener: CategoryClickListener) :
    RecyclerView.Adapter<CatsAdapter.CategoryVH>() {

    private val categories: ArrayList<Category> = ArrayList()

    fun addAll(categories: List<Category>) {
        this.categories.addAll(categories)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryVH {
        return CategoryVH(
            ItemTaskCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: CategoryVH, position: Int) {
        holder.bind(categories[position])
    }

    override fun getItemCount(): Int {
        return categories.size
    }

    inner class CategoryVH(private val binding: ItemTaskCategoryBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(category: Category) {
            binding.run {
                categoryText.text = category.name
                categoryCircleColor.backgroundTintList = ColorStateList.valueOf(category.color)

                if (category.isSelected) root.setCardBackgroundColor(0xCD_85_3F)

                root.setOnClickListener {
                    clickListener.onCategoryClick(adapterPosition)
                }
            }
        }
    }

    interface CategoryClickListener {
        fun onCategoryClick(pos: Int)
    }
}