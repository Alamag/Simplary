package bonch.hack.ssd.simplary.ui.tasks

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import bonch.hack.ssd.simplary.databinding.ItemGoalBinding

class GoalsAdapter : RecyclerView.Adapter<GoalsAdapter.GoalVH>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GoalVH {
        return GoalVH(
            ItemGoalBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: GoalVH, position: Int) {}

    override fun getItemCount(): Int {
        return 10
    }

    inner class GoalVH(private val binding: ItemGoalBinding) :
        RecyclerView.ViewHolder(binding.root)
}