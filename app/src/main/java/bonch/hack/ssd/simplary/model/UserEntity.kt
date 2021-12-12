package bonch.hack.ssd.simplary.model

import bonch.hack.ssd.simplary.ui.auth.signup.SignUpViewModel

data class UserEntity(
    val id: String? = null,
    val login: String? = null,
    val name: String? = null,
    val lastName: String? = null,
    val email: String? = null,
    val tasks: Map<String, Task>? = emptyMap(),
    val notes: Map<String, Note>? = emptyMap(),
    val goals: Map<String, Goal>? = emptyMap(),
    val subscriptions: List<String>? = emptyList(),
) {
    companion object {
        fun fromUserData(user: SignUpViewModel.User): UserEntity {
            return UserEntity(
                id = user.id,
                login = user.login,
                name = user.name,
                lastName = user.lastName,
                email = user.email
            )
        }
    }
}

data class Task(
    val id: String?,
    val name: String?,
    val description: String?,
    val subTasks: List<SubTask>? = emptyList(),
    val isCompleted: Boolean? = false,
)

data class SubTask(
    val id: String?,
    val name: String?,
    val isCompleted: Boolean? = false,
)

data class Note(
    val id: String?,
    val name: String?,
    val text: String?
)

data class Goal(
    val id: String?,
    val name: String?,
    val description: String?
)
