package bonch.hack.ssd.simplary.ui.community.tabs.popular

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import bonch.hack.ssd.simplary.databinding.ItemPostBinding

class PopularAdapter : RecyclerView.Adapter<PopularAdapter.PostVH>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostVH {
        return PostVH(
            ItemPostBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: PostVH, position: Int) {}

    override fun getItemCount(): Int = 5

    inner class PostVH(private val binding: ItemPostBinding) : RecyclerView.ViewHolder(binding.root)
}