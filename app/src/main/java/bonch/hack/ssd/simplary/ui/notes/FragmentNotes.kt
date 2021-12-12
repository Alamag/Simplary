package bonch.hack.ssd.simplary.ui.notes

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import bonch.hack.ssd.simplary.databinding.FragmentNotesBinding
import bonch.hack.ssd.simplary.router.Router
import bonch.hack.ssd.simplary.ui.base.BaseBindingFragment
import bonch.hack.ssd.simplary.ui.notes.adapter.NotesAdapterListener
import com.google.android.material.floatingactionbutton.FloatingActionButton

class FragmentNotes : NotesAdapterListener,
    BaseBindingFragment<FragmentNotesBinding, NotesViewModel>(FragmentNotesBinding::inflate) {

    override val model: NotesViewModel by viewModels()

    private val listAdapter by lazy { NotesAdapter(this) }

    private fun setupToolbar() {
        (activity as AppCompatActivity).setSupportActionBar(binding.toolbar)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.notesRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = listAdapter
            listAdapter.submitList(NotesData.createList())
        }
        val noteButton: FloatingActionButton = binding.fab
        noteButton.setOnClickListener() {
            Router.navigateToCreateNewNote("1")

            listAdapter.submitList(NotesData.createList())
            val noteButton: FloatingActionButton = binding.fab
            noteButton.setOnClickListener {
                Router.navigateToCreateNewNote("0")

            }
            setupToolbar()
        }
    }


    override fun click(pos: Int) {
        super.click(pos)
    }
}