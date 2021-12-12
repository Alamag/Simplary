package bonch.hack.ssd.simplary.repository

import bonch.hack.ssd.simplary.model.UserEntity
import bonch.hack.ssd.simplary.utils.FirebaseHelper
import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.DocumentReference

class CreateUserInDatabase : (UserEntity) -> Task<DocumentReference> {
    override fun invoke(user: UserEntity): Task<DocumentReference> {
        return FirebaseHelper.usersCollection.add(user)
    }
}