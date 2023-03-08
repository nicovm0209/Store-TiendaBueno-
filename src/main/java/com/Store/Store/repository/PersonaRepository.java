/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Store.Store.repository;

import com.Store.Store.entity.Persona;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.Store.Store.repository.PersonaRepository;
/**
 *
 * @author keylo
 */
public interface PersonaRepository extends CrudRepository<Persona,Long> {
    
}
