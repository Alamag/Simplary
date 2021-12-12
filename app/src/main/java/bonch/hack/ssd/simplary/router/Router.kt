package bonch.hack.ssd.simplary.router

import androidx.fragment.app.FragmentManager
import bonch.hack.ssd.simplary.R
import bonch.hack.ssd.simplary.ui.notes.FragmentNotesCreate

object Router {

    private var fragmentManager: FragmentManager? = null

    fun setFragmentManager(fragmentManager: FragmentManager?) {
        this.fragmentManager = fragmentManager
    }

    fun navigateToCreateNewNote(id: String) {
        fragmentManager?.let {
            it.beginTransaction()
                .add(R.id.main_fragment_container_view, FragmentNotesCreate.newInstance(id))
                .addToBackStack(null)
                .commitAllowingStateLoss()
        }
    }

    fun back() {
        fragmentManager?.popBackStack()
    }
}