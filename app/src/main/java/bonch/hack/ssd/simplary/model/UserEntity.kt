package bonch.hack.ssd.simplary.model

import bonch.hack.ssd.simplary.ui.base.adapter.RecyclerItem

data class UserEntity(
    val login: String,
    val name: String,
    val lastName: String,
    val email: String,
    val tasks: List<Task> = emptyList(),
    val notes: List<Note>? = emptyList(),
    val goals: List<Goal>? = emptyList(),
    val subscriptions: List<String> = emptyList(),
)

data class Task(
    val name: String,
    val description: String,
    val category: Category,
    val time: String,
    val subTasks: List<SubTask> = emptyList(),
    var isCompleted: Boolean = false,
    var isOpened: Boolean = false
)

data class SubTask(
    val name: String,
    var isCompleted: Boolean = false,
)

data class Note(
    val name: String,
    val text: String
)

data class Goal(
    val name: String,
    val description: String
)

data class Category(
    val name: String,
    val color: Int,
    var isSelected: Boolean = false
)