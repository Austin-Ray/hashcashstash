package com.edge.demo.controller;

import com.edge.demo.model.Currency;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * Created by kelseyedge on 2/13/18.
 *
 * CryptoCurrency CRUD Operations
 * Pure Spring MVC - Boot is managing the JSON/Jackson parsing
 */
@RestController
@RequestMapping("api/v1/")
//sets endpoint to connect to api/v1
public class CurrencyController {

    @RequestMapping(value = "currencys", method = RequestMethod.GET)
    public List<Currency> list(){
        return CurrencyStub.list();
    }

    @RequestMapping(value = "currencys", method = RequestMethod.POST)
    public Currency create(@RequestBody Currency currency){
        return CurrencyStub.create(currency);
    }

    @RequestMapping(value = "currencys/{id}", method = RequestMethod.GET)
    public Currency get(@PathVariable Long id){
        return CurrencyStub.get(id);
    }

    @RequestMapping(value = "currencys/{id}", method = RequestMethod.PUT)
    public Currency update(@PathVariable Long id, @RequestBody Currency currency){
        return CurrencyStub.update(id, currency);
    }

    @RequestMapping(value = "currencys/{id}", method = RequestMethod.DELETE)
    public Currency delete(@PathVariable Long id){
        return CurrencyStub.delete(id);
    }

}
