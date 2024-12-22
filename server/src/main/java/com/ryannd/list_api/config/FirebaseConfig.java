package com.ryannd.list_api.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;
import jakarta.annotation.PostConstruct;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FirebaseConfig {

    private static final Logger log = LoggerFactory.getLogger(FirebaseConfig.class);

    @PostConstruct
    public void initialize() throws IOException {
        try {
            GoogleCredentials credentials =
                    GoogleCredentials.fromStream(
                            this.getClass().getResourceAsStream("/serviceAccountKey.json"));

            FirebaseOptions options = FirebaseOptions.builder().setCredentials(credentials).build();

            FirebaseApp.initializeApp(options);
        } catch (IOException e) {
            log.error("Firebase config error", e);
            throw e;
        }
    }

    @Bean
    public FirebaseAuth firebaseAuth() {
        return FirebaseAuth.getInstance();
    }
}
