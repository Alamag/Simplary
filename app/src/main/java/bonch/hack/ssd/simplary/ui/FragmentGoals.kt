package bonch.hack.ssd.simplary.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import bonch.hack.ssd.simplary.R
import bonch.hack.ssd.simplary.databinding.FragmentGoalsBinding
import bonch.hack.ssd.simplary.ui.tasks.GoalsAdapter

class FragmentGoals : Fragment(R.layout.fragment_goals) {

    private var _binding: FragmentGoalsBinding? = null
    private val binding get() = _binding!!

    private val adapter: GoalsAdapter by lazy { GoalsAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGoalsBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.recyclerGoals.adapter = adapter
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}