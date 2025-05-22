// src/main/java/at/htlle/service/UserService.java
package at.htlle.SchoolMatch.service;

import at.htlle.SchoolMatch.model.UserDTO;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ExecutionException;

@Service
public class UserService {

    private static final String COLLECTION = "users";

    public List<UserDTO> findAll() throws ExecutionException, InterruptedException {
        Firestore db = FirestoreClient.getFirestore();               // erst hier holen
        ApiFuture<QuerySnapshot> fut = db.collection(COLLECTION).get();
        List<UserDTO> list = new ArrayList<>();
        for (DocumentSnapshot doc : fut.get().getDocuments()) {
            UserDTO u = doc.toObject(UserDTO.class);
            u.setId(doc.getId());
            list.add(u);
        }
        return list;
    }

    public UserDTO findById(String id) throws ExecutionException, InterruptedException {
        Firestore db = FirestoreClient.getFirestore();               // erst hier holen
        DocumentSnapshot doc = db.collection(COLLECTION).document(id).get().get();
        return doc.exists() ? doc.toObject(UserDTO.class) : null;
    }

    public UserDTO save(UserDTO user) throws ExecutionException, InterruptedException {
        Firestore db = FirestoreClient.getFirestore();               // erst hier holen
        DocumentReference ref;
        if (user.getId() != null) {
            ref = db.collection(COLLECTION).document(user.getId());
            ref.set(user).get();
        } else {
            ref = db.collection(COLLECTION).document();
            ref.set(user).get();
            user.setId(ref.getId());
        }
        return user;
    }

    public void delete(String id) throws ExecutionException, InterruptedException {
        Firestore db = FirestoreClient.getFirestore();               // erst hier holen
        db.collection(COLLECTION).document(id).delete().get();
    }
}
