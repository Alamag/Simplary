package bonch.hack.ssd.simplary.ui.tasks

import bonch.hack.ssd.simplary.model.Category
import bonch.hack.ssd.simplary.model.Task

sealed class TasksState {
    object Loading: TasksState()
    object Waiting: TasksState()
    class Success(val categories: List<Category>, val tasks: List<Task>): TasksState()
    class Error(val msg: String): TasksState()
}