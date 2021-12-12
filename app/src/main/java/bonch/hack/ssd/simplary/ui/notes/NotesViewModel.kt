package bonch.hack.ssd.simplary.ui.notes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import bonch.hack.ssd.simplary.router.Router

class NotesViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is notes Fragment"
    }
    val text: LiveData<String> = _text
    fun onBackPressed(){
        Router.back()
    }
    var notesData = NotesData.createList()
    fun onNoteClicked(pos : Int){
        notesData[pos].id?.let {
            Router.navigateToCreateNewNote(it) }
    }
}