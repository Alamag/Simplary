package bonch.hack.ssd.simplary.repository

import bonch.hack.ssd.simplary.model.Note
import bonch.hack.ssd.simplary.utils.CurrentUser
import bonch.hack.ssd.simplary.utils.FirebaseHelper
import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.FieldValue

class CreateNoteInDatabase : (Note) -> Task<Void> {
    override fun invoke(note: Note): Task<Void> {
        return FirebaseHelper.usersCollection.document(CurrentUser.uid)
            .update("notes", FieldValue.arrayUnion(note))
    }
}