package robledo.home.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import robledo.home.demo.response.MessageResponse;
import robledo.home.demo.model.Customer;
import robledo.home.demo.repository.CustomerRepository;
import robledo.home.demo.service.RewardService;

@RestController
public class RewardController {

    @Autowired
    private RewardService service;

    @Autowired
    private CustomerRepository customerRepo;

    @GetMapping("/customers/{id}/rewards")
    public ResponseEntity<?> getPoints(@PathVariable long id) {

        Customer customer = customerRepo.findById(id).orElse(null);

        if(customer != null) {
            return service.calculatePoints(customer);
        } else {
            return ResponseEntity.badRequest().body(new MessageResponse("Customer not exist!"));
        }
    }
}
