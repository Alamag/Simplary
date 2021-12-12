package bonch.hack.ssd.simplary.ui.tasks

import android.content.res.ColorStateList
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import bonch.hack.ssd.simplary.R
import bonch.hack.ssd.simplary.databinding.ItemTaskTaskBinding
import bonch.hack.ssd.simplary.model.Task

class TasksAdapter(private val clickListener: TaskClickListener) :
    RecyclerView.Adapter<TasksAdapter.TaskVH>() {

    private val tasks: ArrayList<Task> = ArrayList()

    fun addAll(tasks: List<Task>) {
        this.tasks.addAll(tasks)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskVH {
        return TaskVH(
            ItemTaskTaskBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: TaskVH, position: Int) {
        holder.bind(tasks[position])
    }

    override fun getItemCount(): Int {
        return tasks.size
    }

    inner class TaskVH(private val binding: ItemTaskTaskBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(task: Task) {
            binding.run {
                taskName.text = task.name
                taskDescription.text = task.description
                taskTime.text = task.time

                if (task.isOpened) taskDescription.visibility = View.VISIBLE else View.GONE
                if (task.isCompleted) taskStatus.setImageResource(R.drawable.checkbox_complete)

                categoryCircleColor.backgroundTintList = ColorStateList.valueOf(task.category.color)

                val completedCounter = task.subTasks.count { it.isCompleted }
                taskCounter.text = "$completedCounter из ${task.subTasks.lastIndex}"

                taskStatus.setOnClickListener {
                    clickListener.onCompleteClick(adapterPosition)
                }

                root.setOnClickListener {
                    clickListener.onItemClick(adapterPosition)
                }
            }
        }
    }

    interface TaskClickListener {
        fun onCompleteClick(pos: Int)
        fun onItemClick(pos: Int)
    }
}