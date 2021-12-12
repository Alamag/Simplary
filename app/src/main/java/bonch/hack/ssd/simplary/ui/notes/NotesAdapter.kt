package bonch.hack.ssd.simplary.ui.notes

import bonch.hack.ssd.simplary.ui.base.adapter.*
import bonch.hack.ssd.simplary.ui.notes.cells.*

class NotesAdapter(listener: AdapterListener?) : BaseListAdapter(
    NoteCell,
    listener = listener
)