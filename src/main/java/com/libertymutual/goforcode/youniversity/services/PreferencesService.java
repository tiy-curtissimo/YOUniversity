package com.libertymutual.goforcode.youniversity.services;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.libertymutual.goforcode.youniversity.repositories.PreferencesRepository;
import com.libertymutual.goforcode.youniversity.repositories.UserRepository;



	@Service
	public class PreferencesService {

	    private PreferencesRepository preferencesRepository;

	    public PreferencesService(PreferencesRepository preferencesRepository) {
	        this.preferencesRepository = preferencesRepository;
	    }
	
	}
