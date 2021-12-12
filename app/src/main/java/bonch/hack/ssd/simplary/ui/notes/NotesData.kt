package bonch.hack.ssd.simplary.ui.notes

import android.app.ActivityManager
import android.text.Editable
import bonch.hack.ssd.simplary.ui.base.adapter.*
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
    fun createList(title : String, description: String): List<RecyclerItem> {

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