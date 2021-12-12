package bonch.hack.ssd.simplary.ui.tasks

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import bonch.hack.ssd.simplary.databinding.FragmentTasksBinding
import bonch.hack.ssd.simplary.ui.base.BaseBindingFragment

class FragmentTasks :
    BaseBindingFragment<FragmentTasksBinding, TasksViewModel>(FragmentTasksBinding::inflate),
    TasksAdapter.TaskClickListener,
    CatsAdapter.CategoryClickListener {

    override val model: TasksViewModel by viewModels()

    private val tasksAdapter by lazy { TasksAdapter(this) }
    private val catsAdapter by lazy { CatsAdapter(this) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        model.state.observe(viewLifecycleOwner) {
            when (it) {
                is TasksState.Error -> {

                }
                TasksState.Loading -> {


                }
                is TasksState.Success -> {
                    tasksAdapter.addAll(it.tasks)
                    binding.tasks.adapter = tasksAdapter

                    catsAdapter.addAll(it.categories)
                    binding.categories.adapter = catsAdapter
                }
                TasksState.Waiting -> {

                }
            }
        }

        (activity as AppCompatActivity).setSupportActionBar(binding.toolbar)
    }

    override fun onCompleteClick(pos: Int) {
        model.onTaskCompleteClicked(pos)
        tasksAdapter.notifyItemChanged(pos)
    }

    override fun onItemClick(pos: Int) {
        model.onTaskClicked(pos)
        tasksAdapter.notifyItemChanged(pos)
    }

    override fun onCategoryClick(pos: Int) {
        model.onCategoryClicked(pos)
        catsAdapter.notifyItemChanged(pos)
    }
}