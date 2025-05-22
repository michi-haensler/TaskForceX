package at.htlle.SchoolMatch.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.io.InputStream;

@Configuration
public class FirebaseConfig {

    @Bean
    public FirebaseApp firebaseApp() throws IOException {
        // Versuche, die JSON aus dem Classpath zu laden (ohne führendes '/')
        InputStream in = FirebaseConfig.class
                .getClassLoader()
                .getResourceAsStream("firebase-service-account.json");

        if (in == null) {
            throw new IllegalStateException(
                    "Service-Account-Key 'firebase-service-account.json' nicht gefunden im Classpath!");
        }

        FirebaseOptions opts = FirebaseOptions.builder()
                .setCredentials(GoogleCredentials.fromStream(in))
                // Optional: setze hier deine DB-URL, falls du Realtime Database nutzt
                // .setDatabaseUrl("https://<DEIN-PROJEKT>.firebaseio.com")
                .build();

        return FirebaseApp.initializeApp(opts);
    }
}
