/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Store.Store.service;

import com.Store.Store.entity.Persona;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author keylo
 */
public class Userprincipal  implements UserDetails{
    
      private Persona persona;
    
    public Userprincipal(Persona persona){
        
        this.persona = persona;
    }

    @Override
     public Collection<? extends GrantedAuthority> getAuthorities() {
     List<GrantedAuthority> authorities = new ArrayList<>();
     
     
     //Extract list of permissions (name)
     this.persona.getPermissionList().forEach(p -> {
        GrantedAuthority authority = new SimpleGrantedAuthority(p);
        authorities.add(authority);
     });
     
      //Extract list of roles (Role_name)
     this.persona.getRoleList().forEach(r -> {
        GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_"+ r);
        authorities.add(authority);
     });
     
     return authorities;  
     
    }
     
     
    
    @Override
    public String getPassword() {
    return this.persona.getPassword();
    }

    @Override
   public String getUsername() {
        return this.persona.getNombre();
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
        return this.persona.getActive()==1;
    }
    
    
}
