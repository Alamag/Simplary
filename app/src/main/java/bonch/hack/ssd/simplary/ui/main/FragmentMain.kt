package bonch.hack.ssd.simplary.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import bonch.hack.ssd.simplary.R
import bonch.hack.ssd.simplary.databinding.FragmentMainBinding
import bonch.hack.ssd.simplary.ui.profile.FragmentProfile
import bonch.hack.ssd.simplary.ui.community.FragmentCommunity
import bonch.hack.ssd.simplary.ui.notes.FragmentNotes
import bonch.hack.ssd.simplary.ui.tasks.FragmentTasks
import java.security.InvalidParameterException

class FragmentMain : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val binding: FragmentMainBinding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupNavigation()
    }

    private fun setupNavigation() {
        binding.bottomNavigation.setOnItemSelectedListener {
            setCurrentFragment(it)
            true
        }
        binding.bottomNavigation.selectedItemId = R.id.tasks
    }

    private fun setCurrentFragment(item: MenuItem) {
        val fm = childFragmentManager
        var currentFragment: Fragment? = null
        val fragments = fm.fragments

        for (f in fragments) {
            if (f.isVisible) {
                currentFragment = f
                break
            }
        }

        val newFragment = fm.findFragmentByTag(item.title.toString())

        if (currentFragment != null && newFragment != null && currentFragment === newFragment) return

        val transaction = fm.beginTransaction()

        if (newFragment == null) {
            val fragment = when (item.itemId) {
                R.id.community -> FragmentCommunity()
                R.id.tasks -> FragmentTasks()
                R.id.notes -> FragmentNotes()
                R.id.profile -> FragmentProfile()
                else -> throw InvalidParameterException()
            }

            transaction.add(binding.fragmentContainerView.id, fragment, item.title.toString())
        }

        if (currentFragment != null) {
            transaction.hide(currentFragment)
        }

        if (newFragment != null) {
            transaction.show(newFragment)
        }

        transaction.commitAllowingStateLoss()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}