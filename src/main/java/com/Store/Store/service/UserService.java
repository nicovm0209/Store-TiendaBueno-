/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Store.Store.service;

import com.Store.Store.entity.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author keylo
 */
@Service
public class UserService implements UserDetailsService{ /*Clase de spring para almacenar los detalles del usuario que se va logear*/
     @Autowired
    public IPersonaService personaService; 

    @Override /*Para cargar el usuario dado, buscamos la info y si existe la mostramos*/
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Persona persona = this.personaService.findByNombre(username);    
        Userprincipal userPrincipal = new Userprincipal(persona);
        return userPrincipal;
    }
    
    
}
