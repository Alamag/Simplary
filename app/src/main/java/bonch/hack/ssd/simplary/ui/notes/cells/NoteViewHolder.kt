package bonch.hack.ssd.simplary.ui.notes.cells

import bonch.hack.ssd.simplary.databinding.ItemNotesRecyclerViewBinding
import bonch.hack.ssd.simplary.ui.base.adapter.BaseViewHolder
import bonch.hack.ssd.simplary.ui.notes.adapter.NotesAdapterListener

class NoteViewHolder(private val binding: ItemNotesRecyclerViewBinding) : BaseViewHolder(binding) {

    fun bind(note: Note, listener: NotesAdapterListener) {
        binding.title.text = note.title
        binding.description.text = note.description
        binding.root.setOnClickListener {
            listener.click(absoluteAdapterPosition)
        }
    }

}