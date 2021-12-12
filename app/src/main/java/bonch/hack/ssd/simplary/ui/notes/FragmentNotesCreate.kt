package bonch.hack.ssd.simplary.ui.notes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import bonch.hack.ssd.simplary.MainActivity
import bonch.hack.ssd.simplary.R
import bonch.hack.ssd.simplary.databinding.FragmentNotesBinding
import bonch.hack.ssd.simplary.databinding.FragmentNotesCreateBinding
import bonch.hack.ssd.simplary.ui.base.BaseBindingFragment


class FragmentNotesCreate : BaseBindingFragment<FragmentNotesCreateBinding, NewNotesViewModel>(
    FragmentNotesCreateBinding::inflate) {

    private fun setupToolbar(){
        binding.toolbar.title.text = getString(R.string.title_notes)
        binding.toolbar.btnBack.setOnClickListener{
            model.onBackPressed()
        }
        (activity as MainActivity).setSupportActionBar(binding.toolbar.root)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super<BaseBindingFragment>.onViewCreated(view, savedInstanceState)
        setupToolbar()
    }

    companion object {
        private const val ID = "id"
        fun newInstance(id : String?) : FragmentNotesCreate{
            val fragment = FragmentNotesCreate()
            val arguments = Bundle()
            arguments.putString("ID", id)
            fragment.arguments = arguments
            return fragment
        }

    }
    override val model: NewNotesViewModel by viewModels()
}