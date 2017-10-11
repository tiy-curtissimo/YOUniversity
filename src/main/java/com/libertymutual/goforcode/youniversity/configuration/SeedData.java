package com.libertymutual.goforcode.youniversity.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.libertymutual.goforcode.youniversity.models.Preferences;
import com.libertymutual.goforcode.youniversity.models.User;
import com.libertymutual.goforcode.youniversity.repositories.PreferencesRepository;
import com.libertymutual.goforcode.youniversity.repositories.UserRepository;

@Configuration
@Profile("development")
public class SeedData {

    public SeedData(UserRepository usersRepository, PasswordEncoder encoder, PreferencesRepository preferencesRepository) {
        
        Preferences preferences = preferencesRepository.save(new Preferences("10000", "WA", "SomeMajor"));
        
        usersRepository.save(new User("dan", "danielson", "dan@dan.com", encoder.encode("password"), preferences));
        usersRepository.save(new User("peter", "peterson", "peter@peter.com", encoder.encode("password"), preferences));
        usersRepository.save(new User("james", "jameson", "james@james.com", encoder.encode("password"), preferences));

    }

}
