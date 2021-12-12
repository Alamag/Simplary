package bonch.hack.ssd.simplary.ui.notes

import bonch.hack.ssd.simplary.ui.base.adapter.AdapterListener
import bonch.hack.ssd.simplary.ui.base.adapter.BaseListAdapter
import bonch.hack.ssd.simplary.ui.notes.cells.NoteCell

class NotesAdapter(listener: AdapterListener?) : BaseListAdapter(
    NoteCell,
    listener = listener
)