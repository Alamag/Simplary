package bonch.hack.ssd.simplary.ui.notes.cells

import android.util.Log
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import bonch.hack.ssd.simplary.databinding.FragmentNotesBinding
import bonch.hack.ssd.simplary.databinding.ItemNotesRecyclerViewBinding
import bonch.hack.ssd.simplary.ui.base.adapter.AdapterListener
import bonch.hack.ssd.simplary.ui.base.adapter.BaseViewHolder

class NoteViewHolder(private val binding: ItemNotesRecyclerViewBinding) : BaseViewHolder(binding) {

    fun bind(note: Note, listener: AdapterListener) {
        binding.title.text = note.title
        binding.decription.text = note.description
        Log.d("key", note.title)
    }

}