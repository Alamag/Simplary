package bonch.hack.ssd.simplary.ui.community.tabs.search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import bonch.hack.ssd.simplary.databinding.ItemPeopleSearchBinding

class PeopleSearchAdapter : RecyclerView.Adapter<PeopleSearchAdapter.SearchPeopleVH>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchPeopleVH {
        return SearchPeopleVH(
            ItemPeopleSearchBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: SearchPeopleVH, position: Int) {}

    override fun getItemCount(): Int {
        return 12
    }

    inner class SearchPeopleVH(private val binding: ItemPeopleSearchBinding) :
        RecyclerView.ViewHolder(binding.root)
}