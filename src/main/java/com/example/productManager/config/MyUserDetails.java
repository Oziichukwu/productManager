package com.example.productManager.config;

import com.example.productManager.data.models.ProductUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;

public class MyUserDetails implements UserDetails {

    private ProductUser productUser;

    public MyUserDetails(ProductUser productUser) {
        this.productUser = productUser;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(productUser.getRole());
        return Arrays.asList(authority);
    }

    @Override
    public String getPassword() {
        return productUser.getPassword();
    }

    @Override
    public String getUsername() {
        return productUser.getUsername();
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
}
