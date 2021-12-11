package bonch.hack.ssd.simplary.ui.notes

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import bonch.hack.ssd.simplary.databinding.FragmentNotesBinding
import bonch.hack.ssd.simplary.ui.base.BaseBindingFragment
import bonch.hack.ssd.simplary.ui.base.adapter.AdapterListener

class FragmentNotes : AdapterListener,
    BaseBindingFragment<FragmentNotesBinding, NotesViewModel>(FragmentNotesBinding::inflate) {

    private lateinit var notesViewModel: NotesViewModel
    private val listAdapter by lazy { NotesAdapter(this) }

    // This property is only valid between onCreateView and
    // onDestroyView.


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.notesRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = listAdapter
            listAdapter.submitList(NotesData.createList())
        }
    }


    override val model: NotesViewModel by viewModels()
}