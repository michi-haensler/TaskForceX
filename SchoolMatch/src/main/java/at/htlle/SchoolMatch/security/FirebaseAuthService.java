package at.htlle.SchoolMatch.security;

import com.google.firebase.auth.*;
import org.springframework.stereotype.Service;

@Service
public class FirebaseAuthService {

    /**
     * Verifiziert ein Firebase ID-Token und gibt das zugehörige FirebaseToken zurück.
     */
    public FirebaseToken verifyIdToken(String idToken) throws FirebaseAuthException {
        return FirebaseAuth.getInstance().verifyIdToken(idToken);
    }
}
