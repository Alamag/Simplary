package bonch.hack.ssd.simplary.ui.notes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import bonch.hack.ssd.simplary.model.Note
import bonch.hack.ssd.simplary.model.UserEntity
import bonch.hack.ssd.simplary.repository.CreateNoteInDatabase
import bonch.hack.ssd.simplary.repository.GetUserNotes
import bonch.hack.ssd.simplary.router.Router
import bonch.hack.ssd.simplary.utils.CurrentUser
import com.google.firebase.firestore.ktx.toObject

class NotesViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is notes Fragment"
    }
    val text: LiveData<String> = _text
    fun onBackPressed(){
        Router.back()
    }
    var notesData = NotesData.createList()
    fun afterCreated() {

    }



}