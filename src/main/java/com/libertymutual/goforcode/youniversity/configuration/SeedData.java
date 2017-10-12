package com.libertymutual.goforcode.youniversity.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.libertymutual.goforcode.youniversity.models.Preferences;
import com.libertymutual.goforcode.youniversity.models.SchoolList;
import com.libertymutual.goforcode.youniversity.models.User;
import com.libertymutual.goforcode.youniversity.repositories.PreferencesRepository;
import com.libertymutual.goforcode.youniversity.repositories.SchoolListRepository;
import com.libertymutual.goforcode.youniversity.repositories.UserRepository;

@Configuration
@Profile("development")
public class SeedData {

    public SeedData(UserRepository userRepository, PasswordEncoder encoder, PreferencesRepository preferencesRepository, SchoolListRepository schoolListRepo) {
        
        Preferences preferences = new Preferences("10000", "WA", "SomeMajor");        
               
        User dan = userRepository.save(new User("dan", "danielson", "dan@dan.com", encoder.encode("password"), preferences));
        User peter = userRepository.save(new User("peter", "peterson", "peter@peter.com", encoder.encode("password"), null));
        User james = userRepository.save(new User("james", "jameson", "james@james.com", encoder.encode("password"), null));
        
        schoolListRepo.save(new SchoolList("firstList", dan));
        schoolListRepo.save(new SchoolList("secondList", dan));
        schoolListRepo.save(new SchoolList("firstList", peter));

    }

}
