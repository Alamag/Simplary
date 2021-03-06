package bonch.hack.ssd.simplary.ui.notes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import bonch.hack.ssd.simplary.router.Router

class NewNotesViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is notes Fragment"
    }
    val text: LiveData<String> = _text
    fun onBackPressed() {
        Router.back()
    }

    fun onNewNoteClicked(title: String, description: String) {

    }

    class Note(
        var name: String?,
        val description: String?
    )
}
