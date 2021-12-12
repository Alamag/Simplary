package bonch.hack.ssd.simplary.repository

import bonch.hack.ssd.simplary.model.UserEntity
import bonch.hack.ssd.simplary.utils.FirebaseHelper
import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class CreateUserInDatabase: (UserEntity) -> Task<Void> {
    override fun invoke(user: UserEntity): Task<Void> {
        return FirebaseHelper.usersCollection.document(user.id!!).set(user)
    }
}