package bonch.hack.ssd.simplary.ui.community

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import bonch.hack.ssd.simplary.R
import bonch.hack.ssd.simplary.databinding.FragmentCommunityBinding
import bonch.hack.ssd.simplary.ui.base.BaseBindingFragment
import bonch.hack.ssd.simplary.ui.community.tabs.popular.FragmentPopular
import bonch.hack.ssd.simplary.ui.community.tabs.search.FragmentSearch
import bonch.hack.ssd.simplary.ui.community.tabs.subscriptions.FragmentSubscriptions
import com.google.android.material.tabs.TabLayoutMediator

class FragmentCommunity :
    BaseBindingFragment<FragmentCommunityBinding, CommunityViewModel>(FragmentCommunityBinding::inflate) {
    override val model: CommunityViewModel by viewModels()

    private var pagerAdapter: CommunityPagerAdapter? = null

    private var fragmentSubscriptions: FragmentSubscriptions? = null
    private var fragmentPopular: FragmentPopular? = null
    private var fragmentSearch: FragmentSearch? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initPager()

        fragmentSubscriptions = FragmentSubscriptions()
        fragmentPopular = FragmentPopular()
        fragmentSearch = FragmentSearch()

        pagerAdapter?.update(listOf(fragmentSubscriptions!!, fragmentPopular!!, fragmentSearch!!))

        TabLayoutMediator(binding.tabLayout, binding.pager) { tab, position ->
            tab.text = when (position) {
                0 -> getString(R.string.tab_subcribed_label)
                1 -> getString(R.string.tab_popular_label)
                2 -> getString(R.string.tab_search_label)
                else -> throw IllegalStateException("Unsupported tab position = $position")
            }
        }.attach()
    }

    private fun initPager() {
        pagerAdapter = CommunityPagerAdapter(childFragmentManager, lifecycle)

        binding.pager.adapter = pagerAdapter
    }
}