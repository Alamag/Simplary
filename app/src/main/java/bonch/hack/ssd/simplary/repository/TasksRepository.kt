package bonch.hack.ssd.simplary.repository

import bonch.hack.ssd.simplary.model.Category
import bonch.hack.ssd.simplary.model.SubTask
import bonch.hack.ssd.simplary.model.Task

class TasksRepository {
    fun getTasks(): ArrayList<Task> {
        return arrayListOf(
            Task(
                name = "Победить на хакатоне",
                "Только победа",
                Category(
                    "Важное",
                    0xFBB86FC
                ),
                "12:00",
                listOf(
                    SubTask(
                        "Продумать решение",
                        true
                    ),
                    SubTask(
                        "Нарисовать дизайн",
                        false
                    ),
                ),
            ),
            Task(
                name = "Победить на хакатоне",
                "Только победа",
                Category(
                    "Почти",
                    0xFBB86FC
                ),
                "12:00",
                listOf(
                    SubTask(
                        "Продумать решение",
                        true
                    ),
                    SubTask(
                        "Нарисовать дизайн",
                        false
                    ),
                ),
            ),
            Task(
                name = "Победить на хакатоне",
                "Только победа",
                Category(
                    "Скиллы",
                    0xFBB86FC
                ),
                "12:00",
                listOf(
                    SubTask(
                        "Продумать решение",
                        true
                    ),
                    SubTask(
                        "Нарисовать дизайн",
                        false
                    ),
                ),
            ),
            Task(
                name = "Победить на хакатоне",
                "Только победа",
                Category(
                    "Красивое",
                    0xFBB86FC
                ),
                "12:00",
                listOf(
                    SubTask(
                        "Продумать решение",
                        true
                    ),
                    SubTask(
                        "Нарисовать дизайн",
                        false
                    ),
                ),
            ),
            Task(
                name = "Жёстко наверстать 5 экранов",
                "Только вёрстка",
                Category(
                    "Очень важное",
                    0xFBB86FC
                ),
                "14:00",
                listOf(
                    SubTask(
                        "1 экран",
                        true
                    ),
                    SubTask(
                        "2 экран",
                        true
                    ),
                    SubTask(
                        "3 экран",
                        false
                    ),
                    SubTask(
                        "4 экран",
                        false
                    ),
                ),
            )
        )
    }
}