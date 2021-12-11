package bonch.hack.ssd.simplary.ui.notes.cells

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import bonch.hack.ssd.simplary.R
import bonch.hack.ssd.simplary.databinding.ItemNotesRecyclerViewBinding
import bonch.hack.ssd.simplary.ui.base.adapter.*
import bonch.hack.ssd.simplary.ui.notes.adapter.NotesAdapterListener

object NoteCell : Cell<RecyclerItem>() {

    override fun belongsTo(item: RecyclerItem?): Boolean {
        return item is Note
    }

    override fun type(): Int {
        return R.layout.item_notes_recycler_view
    }

    override fun holder(parent: ViewGroup): RecyclerView.ViewHolder {
        return NoteViewHolder(ItemNotesRecyclerViewBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun bind(
        holder: RecyclerView.ViewHolder,
        item: RecyclerItem?,
        listener: AdapterListener?
    ) {
       item as Note
       listener as NotesAdapterListener
        (holder as NoteViewHolder).bind(item,listener)
        Log.d("check", "maybe")
    }

}