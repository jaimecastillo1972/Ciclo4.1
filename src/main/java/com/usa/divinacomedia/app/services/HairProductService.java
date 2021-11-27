package com.usa.divinacomedia.app.services;

import com.usa.divinacomedia.app.model.HairProduct;
import com.usa.divinacomedia.app.repositories.HairProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HairProductService {
    @Autowired
    private HairProductRepository repository;

    /**
     *
     * @return
     */
    public List<HairProduct> getAll(){
        return repository.getAll();
    }

    /**
     *
     * @param product
     * @return
     */
    public HairProduct save(HairProduct product){
        if(product.getReference()==null){
            return product;
        }else{
            Optional<HairProduct> existsProduct = repository.getByReference(product.getReference());
            if(existsProduct.isEmpty()){
                return repository.save(product);
            }else {
                return product;
            }
        }
    }

}
