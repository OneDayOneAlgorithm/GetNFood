package com.get_and_food.application;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import java.io.IOException;
import javax.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class FireBaseInitializer {
 
//    @Value("${app.firebase-configuration-file}")
    @Value("serviceAccountKey.json")
    private String firebaseConfigPath;
 
    @PostConstruct
    public void initialize() {
        try {
            @SuppressWarnings("deprecation")
			FirebaseOptions options = new FirebaseOptions.Builder().setCredentials(
                GoogleCredentials.fromStream(
                    new ClassPathResource(firebaseConfigPath).getInputStream())).build();
            if (FirebaseApp.getApps().isEmpty()) {
                FirebaseApp.initializeApp(options);
                log.info("Firebase application has been initialized");
            }
        } catch (IOException e) {
            log.error(e.getMessage());
        }
 
    }
}
