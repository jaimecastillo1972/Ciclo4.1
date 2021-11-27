package com.usa.divinacomedia.app.controller;

import com.usa.divinacomedia.app.model.HairProduct;
import com.usa.divinacomedia.app.services.HairProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("hairproducts")
@CrossOrigin(origins = "*")//habilita acceso desde cualquier ordenador
public class HairProductController {
    @Autowired
    private HairProductService service;

    /**
     * Metodo GET
     * @return
     */
    @GetMapping("/all") //GET
    public List<HairProduct> getHairProducts(){
        return service.getAll();
    }

    /**
     * Metodo POST
     * @param product
     * @return
     */
    @PostMapping("/new") //POST
    @ResponseStatus(HttpStatus.CREATED)
    public HairProduct save(@RequestBody HairProduct product){
        return service.save(product);
    }

    /**
     * Metodo PUT
     * @param product
     * @return
     */

    @PutMapping("/update") //PUT
    @ResponseStatus(HttpStatus.CREATED)
    public HairProduct update(@RequestBody HairProduct product){
        return service.update(product);
    }

    /**
     *
     * @param referenceId
     * @return
     */

    @DeleteMapping("/{reference}") //DELETE
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable ("reference") String referenceId){
        return service.deleteReference(referenceId);
    }
}
