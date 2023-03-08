/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Store.Store.service;

import com.Store.Store.entity.Pais;
import com.Store.Store.repository.PaisRepository;
import static java.util.Collections.list;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;





@Service
public class PaisService implements IPaisService {
    
    @Autowired
      private PaisRepository paisRepository;
    
    @Override
    public List<Pais> listCountry() {
       return (List<Pais>)paisRepository.findAll();
    }
    

    
 }
