package bonch.hack.ssd.simplary.ui.community.tabs.subscriptions

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import bonch.hack.ssd.simplary.R
import bonch.hack.ssd.simplary.databinding.FragmentCommunityTabBinding
import bonch.hack.ssd.simplary.ui.community.tabs.popular.PopularAdapter

class FragmentSubscriptions : Fragment(R.layout.fragment_community_tab) {

    private var _binding: FragmentCommunityTabBinding? = null
    private val binding get() = _binding!!

    private val adapter: PopularAdapter by lazy { PopularAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCommunityTabBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.recyclerCommunity.adapter = adapter
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}