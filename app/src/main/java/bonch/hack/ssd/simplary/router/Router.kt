package bonch.hack.ssd.simplary.router

import androidx.fragment.app.FragmentManager

object Router {

    private var fragmentManager: FragmentManager? = null

    fun setFragmentManager(fragmentManager: FragmentManager?) {
        this.fragmentManager = fragmentManager
    }

    fun back() {
        fragmentManager?.popBackStack()
    }
}