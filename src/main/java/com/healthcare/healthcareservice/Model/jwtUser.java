package com.healthcare.healthcareservice.Model;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class jwtUser implements UserDetails{
     public String user_name;
     public String user_email;
     public String password;
     public String user_mobile;
     public String location;
     private boolean enabled;
    private Collection<? extends GrantedAuthority> authorities;
    
 public String getUser_name() {
        return user_name;
    }
    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }
    public String getUser_email() {
        return user_email;
    }
    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }
    // public String getPassword() {
    //     return password;
    // }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getUser_mobile() {
        return user_mobile;
    }
    public void setUser_mobile(String user_mobile) {
        this.user_mobile = user_mobile;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return user_name;
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
        return enabled;
    }
    public jwtUser(String user_name, String user_email, String password, String user_mobile, String location, Boolean enabled,  Collection<? extends GrantedAuthority> authorities) {
        super();
        this.user_name = user_name;
        this.user_email = user_email;
        this.password = password;
        this.user_mobile = user_mobile;
        this.location = location;
        this.enabled = enabled;
        this.authorities = authorities;
    }
    public jwtUser() {
        super();
    }
    public jwtUser(String user_name, String password) {
        super();
        this.user_name = user_name;
        this.password = password;
    }
    
    //    public Date user_dob;
    
}
