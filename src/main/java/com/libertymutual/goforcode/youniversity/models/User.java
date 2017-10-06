package com.libertymutual.goforcode.youniversity.models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
//@Table(name="youniversity_user")
public class User implements UserDetails {
        
        private static final long serialVersionUID = 1L;

        @Id
        @GeneratedValue(strategy=GenerationType.AUTO)
        private Long id;
        
        @Column(nullable=false)
        private String password;
        
        @Column(nullable=false, unique=true)
        private String username;
        
       public User() {}
        
        public User(String username, String password) {
                this.username = username;
                this.password = password;
        }
                
        @Override
        public String getPassword() {
                return password;
        }

        @Override
        public String getUsername() {
                return username;
        }

        @Override
        public boolean isAccountNonExpired() {
                return true;
        }

        @Override
        public boolean isAccountNonLocked() {
                return true;
        }

        @Override
        public boolean isCredentialsNonExpired() {
                return true;
        }

        @Override
        public boolean isEnabled() {
                return true;
        }

        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        public void setPassword(String password) {
                this.password = password;
        }

        public void setUsername(String username) {
                this.username = username;
        }

        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            // TODO Auto-generated method stub
            return null;
        }       
}