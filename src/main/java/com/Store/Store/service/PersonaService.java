/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Store.Store.service;

import com.Store.Store.entity.Persona;
import com.Store.Store.repository.PersonaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author keylo
 */
@Service
public class PersonaService implements IPersonaService {
    
     @Autowired
    private PersonaRepository personaRepository;
      
    @Override
    public List<Persona> getAllPersona() {
     return(List<Persona>)personaRepository.findAll();   
    }

    @Override
    public Persona getPersonaById(long id) {
         return personaRepository.findById(id).orElse(null);
    }

    @Override
    public void savePersona(Persona persona) {
        personaRepository.save(persona);
    }

    @Override
    public void delete(long id) {
        personaRepository.deleteById(id);
    }

    @Override
    public List<Persona> listAll(String palabraClave) {
       if(palabraClave != null){
            return personaRepository.findAll(palabraClave);
            
        }
     return(List<Persona>)personaRepository.findAll();   
    }

    @Override
    public Persona findByNombre(String username) {
      return personaRepository.findByNombre(username); /*El findByNombre daba error entonces vamos al repository*/
    }
    
    
}
