package bonch.hack.ssd.simplary.ui.notes.cells

import bonch.hack.ssd.simplary.ui.base.adapter.*

data class Note(
    override val id: String,
    val title: String,
    val description: String
) : RecyclerItem, AdapterListener {
}