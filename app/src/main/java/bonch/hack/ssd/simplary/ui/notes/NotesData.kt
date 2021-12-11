package bonch.hack.ssd.simplary.ui.notes

import bonch.hack.ssd.simplary.ui.base.adapter.*
import bonch.hack.ssd.simplary.ui.notes.cells.Note

object NotesData {

    fun createList(): List<RecyclerItem> {
        val list = ArrayList<RecyclerItem>()
        list.add(
            Note(
                id = "1",
                title = "Movie 1",
                description = "Description 1"
            )
        )
        return list
    }

}