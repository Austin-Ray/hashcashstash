package com.edge.demo.controller;

import com.edge.demo.model.Currency;
import com.edge.demo.repository.CurrencyRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 * Created by kelseyedge on 2/14/18.
 * This class manages the CRUD operations of the Currency Repository
 */

@RestController
@RequestMapping("api/v1/")
//sets endpoint to connect to api/v1
public class CurrencyController {

    @Autowired
    private CurrencyRepository currencyRepository;

    @RequestMapping(value = "currencys", method = RequestMethod.GET)
    public List<Currency> list(){
        return currencyRepository.findAll();
    }

    /*Will get the currency posted from browser, save it in repo, and show a copy
     */
    @RequestMapping(value = "currencys", method = RequestMethod.POST)
    public Currency create(@RequestBody Currency currency){
        return currencyRepository.saveAndFlush(currency);
    }

    @RequestMapping(value = "currencys/{id}", method = RequestMethod.GET)
    public Currency get(@PathVariable Long id){
        return currencyRepository.findOne(id);
    }

    //grab the currency with the incoming id from browser, find the existing one
    //with that id in the database, and update, save, and return updated currency
    @RequestMapping(value = "currencys/{id}", method = RequestMethod.PUT)
    public Currency update(@PathVariable Long id, @RequestBody Currency currency){
        Currency existingCurrency = currencyRepository.findOne(id);
        BeanUtils.copyProperties(currency,existingCurrency);
        return currencyRepository.saveAndFlush(existingCurrency);
    }

    @RequestMapping(value = "currencys/{id}", method = RequestMethod.DELETE)
    public Currency delete(@PathVariable Long id){
        Currency existingCurrency = currencyRepository.findOne(id);
        currencyRepository.delete(existingCurrency);
        return existingCurrency;
    }}