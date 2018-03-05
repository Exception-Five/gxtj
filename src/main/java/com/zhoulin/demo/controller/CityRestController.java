package com.zhoulin.demo.controller;


import com.zhoulin.demo.bean.City;
import com.zhoulin.demo.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * RedisDemo
 */
@RestController
@RequestMapping("/api")
public class CityRestController {

    @Autowired
    private CityService cityService;

    @RequestMapping(value = "/city/{id}", method = RequestMethod.GET)
    public City findOneCity(@PathVariable("id") Integer id) {
        return cityService.findCityById(id);
    }

    @RequestMapping(value = "/city", method = RequestMethod.POST)
    public void createCity(@RequestBody City city) {
        cityService.saveCity(city);
    }

    @RequestMapping(value = "/city", method = RequestMethod.PUT)
    public void modifyCity(@RequestBody City city) {
        cityService.updateCity(city);
    }

    @RequestMapping(value = "/city/{id}", method = RequestMethod.DELETE)
    public void modifyCity(@PathVariable("id") Long id) {
        cityService.deleteCity(id);
    }
}
