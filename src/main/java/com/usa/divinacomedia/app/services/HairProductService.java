package com.usa.divinacomedia.app.services;

import com.usa.divinacomedia.app.repositories.HairProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HairProductService {
    @Autowired
    private HairProductRepository service;
}
