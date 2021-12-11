package bonch.hack.ssd.simplary.data.model

class NotesRecyclerItem {
    private var taskTitle: String? = null
    private var taskDescription: String? = null


    fun NotesRecyclerItem(taskTitle: String?, taskDescription: String?) {
        this.taskTitle = taskTitle
        this.taskDescription = taskDescription
    }

    //геттеры

    fun getTaskTitle(): String? {
        return taskTitle
    }

    fun getTaskDescription(): String? {
        return taskDescription
    }
}