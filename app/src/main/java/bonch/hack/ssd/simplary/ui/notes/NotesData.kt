package bonch.hack.ssd.simplary.ui.notes

import bonch.hack.ssd.simplary.ui.base.adapter.*
import bonch.hack.ssd.simplary.ui.notes.cells.Note

object NotesData {
    val list = ArrayList<RecyclerItem>()
    fun createList(): List<RecyclerItem> {
        list.add(
            Note(
                id = "1",
                title = "Заметка",
                description = "Текст заметки"
            )
        )
        return list
    }


}