package bonch.hack.ssd.simplary.ui.notes

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import bonch.hack.ssd.simplary.MainActivity
import bonch.hack.ssd.simplary.R
import bonch.hack.ssd.simplary.databinding.FragmentNotesBinding
import bonch.hack.ssd.simplary.router.Router
import bonch.hack.ssd.simplary.ui.base.BaseBindingFragment
import bonch.hack.ssd.simplary.ui.base.adapter.AdapterListener
import bonch.hack.ssd.simplary.ui.notes.adapter.NotesAdapterListener
import com.google.android.material.floatingactionbutton.FloatingActionButton

class FragmentNotes : NotesAdapterListener,
    BaseBindingFragment<FragmentNotesBinding, NotesViewModel>(FragmentNotesBinding::inflate) {

    private lateinit var notesViewModel: NotesViewModel
    private val listAdapter by lazy { NotesAdapter(this) }

    // This property is only valid between onCreateView and
    // onDestroyView.
    private fun setupToolbar() {
        binding.toolbar.title.text = getString(R.string.title_notes)
        binding.toolbar.btnBack.setOnClickListener {
            model.onBackPressed()
        }
        (activity as MainActivity).setSupportActionBar(binding.toolbar.root)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.notesRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = listAdapter
            listAdapter.submitList(NotesData.createList())
        }
        listAdapter.submitList(NotesData.createList())
        val noteButton: FloatingActionButton = binding.fab
        noteButton.setOnClickListener {
            Router.navigateToCreateNewNote("0")
        }
        setupToolbar()
    }


    override fun click(pos: Int) {
        super.click(pos)
    }

    override val model: NotesViewModel by viewModels()
}