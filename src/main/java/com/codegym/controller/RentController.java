package com.codegym.controller;

import com.codegym.model.entity.Rent;
import com.codegym.service.rent.IRentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rents")
@CrossOrigin(origins = "*")
public class RentController {
    @Autowired
    IRentService rentService;

    @GetMapping
    public ResponseEntity<Iterable<Rent>> getAllRent() {
        List<Rent> rents = (List<Rent>) rentService.findAll();
        if (rents.isEmpty()) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(rents, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Rent> getRentById(@PathVariable Long id) {
        Optional<Rent> rentOptional = rentService.findById(id);
        if (!rentOptional.isPresent()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(rentOptional.get(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Rent> saveRent(@RequestBody Rent rent) {
        rent.setStatus(0);
        return new ResponseEntity<>(rentService.save(rent), HttpStatus.OK);
    }

    @PutMapping("/feedback/{id}")
    public ResponseEntity<Rent> updateRent(@PathVariable Long id, @RequestParam int newStatus, @RequestBody String feedback) {
        Optional<Rent> rentOptional = rentService.findById(id);
        if (!rentOptional.isPresent()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        rentOptional.get().setId(id);
        rentOptional.get().setStatus(newStatus);
        rentOptional.get().setFeedback(feedback);
        return new ResponseEntity<>(rentService.save(rentOptional.get()), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Rent> changeStatusWithoutFeedback(@PathVariable Long id, @RequestParam int newStatus) {
        Optional<Rent> rentOptional = rentService.findById(id);
        if (!rentOptional.isPresent()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        rentOptional.get().setId(id);
        rentOptional.get().setStatus(newStatus);
        return new ResponseEntity<>(rentService.save(rentOptional.get()), HttpStatus.OK);
    }

    @GetMapping("/payer/{id}")
    public ResponseEntity<Iterable<Rent>> getAllRentForPayer(@PathVariable Long id) {
        List<Rent> rents = (List<Rent>) rentService.findByUserRentId(id);
        if (rents.isEmpty()) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(rents, HttpStatus.OK);
    }

    @GetMapping("/provider/{id}")
    public ResponseEntity<Iterable<Rent>> getAllRentForProvider(@PathVariable Long id) {
        List<Rent> rents = (List<Rent>) rentService.findByUserId(id);
        if (rents.isEmpty()) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(rents, HttpStatus.OK);
    }

}
