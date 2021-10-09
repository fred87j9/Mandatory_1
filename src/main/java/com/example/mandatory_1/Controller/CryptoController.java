package com.example.mandatory_1.Controller;

import com.example.mandatory_1.Model.Crypto;
import com.example.mandatory_1.Repository.CryptoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CryptoController {

    @Autowired
    CryptoRepository crypto;

    @GetMapping("/crypto")
    public Iterable<Crypto> getCrypto(){
        return crypto.findAll();
    }

    @GetMapping("/crypto/{id}")
    public Crypto getbyID(@PathVariable Long id){
        return crypto.findById(id).get();
    }

    @PostMapping("/crypto/{id}")
    public Crypto addCrypto(@RequestBody Crypto newCrypto){

        return crypto.save(newCrypto);
    }

    @PutMapping("/crypto/{id}")
    public String updateById(@PathVariable Long id,@RequestBody Crypto cryptoToUpdate){
        if(crypto.existsById(id)){
            cryptoToUpdate.setId(id);
            crypto.save(cryptoToUpdate);
            return "Crypto was created";
        }else{
            return "Crypto not found";
        }
    }

    @PatchMapping("/crypto/{id}")
    public String patchCryptoById(@PathVariable Long id, @RequestBody Crypto cryptoToUpdateWith){
        return crypto.findById(id).map(foundCrypto ->{
            if(cryptoToUpdateWith.getName() != null) foundCrypto.setName(cryptoToUpdateWith.getName());
            if(cryptoToUpdateWith.getPrice() != 0) foundCrypto.setPrice(cryptoToUpdateWith.getPrice());
            if(cryptoToUpdateWith.getMarketCap() != 0) foundCrypto.setMarketCap(cryptoToUpdateWith.getMarketCap());
            crypto.save(foundCrypto);
            return "Crypto Updated";
        }).orElse("Crypto not found");
    }

    @DeleteMapping("/crypto/{id}")
    public void deleteCryptoById(@PathVariable Long id){
        crypto.deleteById(id);
    }
}
