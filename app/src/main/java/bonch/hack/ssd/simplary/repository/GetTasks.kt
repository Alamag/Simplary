package bonch.hack.ssd.simplary.repository

import bonch.hack.ssd.simplary.utils.FirebaseHelper
import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.DocumentSnapshot

class GetTasks: () -> Task<DocumentSnapshot> {
    override fun invoke(): Task<DocumentSnapshot> {
        return FirebaseHelper.currentUserDoc.get()
    }
}