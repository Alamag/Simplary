package bonch.hack.ssd.simplary.ui.tasks

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import bonch.hack.ssd.simplary.model.Category
import bonch.hack.ssd.simplary.model.Task
import bonch.hack.ssd.simplary.repository.TasksRepository
import bonch.hack.ssd.simplary.utils.notifyObserver

class TasksViewModel : ViewModel() {

    val repository: TasksRepository = TasksRepository()

    private val _state: MutableLiveData<TasksState> = MutableLiveData(TasksState.Loading)
    val state: LiveData<TasksState> = _state

    var tasks: ArrayList<Task> = ArrayList()
    var categories: ArrayList<Category> = ArrayList()

    private val categoriesSet = mutableSetOf<Category>()

    init {
        getTasks()
    }

    fun getTasks() {
        tasks = repository.getTasks()

        tasks.forEach { categoriesSet.add(it.category) }

        categories.addAll(categoriesSet)

        _state.value = TasksState.Success(categories, tasks)
    }

    fun onTaskCompleteClicked(pos: Int) {
        tasks[pos].isCompleted = !tasks[pos].isCompleted
    }

    fun onTaskClicked(pos: Int) {
        tasks[pos].isOpened = !tasks[pos].isOpened
    }

    fun onCategoryClicked(pos: Int) {
        categories[pos].isSelected = !categories[pos].isSelected
    }
}