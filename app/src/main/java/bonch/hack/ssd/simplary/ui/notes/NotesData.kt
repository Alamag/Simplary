package bonch.hack.ssd.simplary.ui.notes

import bonch.hack.ssd.simplary.ui.base.adapter.RecyclerItem
import bonch.hack.ssd.simplary.ui.notes.cells.Note

object NotesData {
    val list = ArrayList<RecyclerItem>()
    fun createList(): List<RecyclerItem> {
        list.add(
            Note(
                id = "1",
                title = "Выиграть хакатон",
                description = "Я обязательно выживу"
            )
        )
        return list
    }

    fun createList(title: String, description: String): List<RecyclerItem> {

        list.add(
            Note(
                id = "2",
                title = title,
                description = description
            )
        )
        return list
    }


}