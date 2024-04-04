package com.example.demo.rest;

import com.example.demo.entity.Broadband;
import com.example.demo.service.service_interface.BroadbandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BroadbandRestController {
    private BroadbandService broadbandService;

    // inject broadband service (use constructor injection)
    @Autowired
    public BroadbandRestController(BroadbandService broadbandService) {
        this.broadbandService = broadbandService;
    }

    // expose "/broadband" and return a list of broadbands
    @GetMapping("/broadband")
    public List<Broadband> getAllBroadbandConnections() {
        return broadbandService.getAllBroadbandConnections();
    }

    // Add mapping for POST /broadband - add new broadband connection
    @PostMapping("/broadband")
    public Broadband saveBroadbandConnection(@RequestBody Broadband broadband) {
        broadband.setConnectionId(0); // in case id is passed in JSON, this will force a save of new item instead of update
        return broadbandService.saveBroadbandConnection(broadband);
    }

    // Add mapping for GET /broadband/{id} - get broadband connection by id
    @GetMapping("/broadband/{id}")
    public Broadband getBroadbandConnectionById(@PathVariable int id) {
        Broadband broadband = broadbandService.getBroadbandConnectionById(id);
        if (broadband == null) {
            throw new RuntimeException("Broadband connection id not found - " + id);
        }
        return broadband;
    }

    // Add mapping for PUT /broadband - update existing broadband connection
    @PutMapping("/broadband")
    public Broadband updateBroadbandConnection(@RequestBody Broadband broadband) {
        broadbandService.saveBroadbandConnection(broadband);
        return broadband;
    }

    // Add mapping for DELETE /broadband/{id} - delete broadband connection
    @DeleteMapping("/broadband/{id}")
    public String deleteBroadbandConnection(@PathVariable int id) {
        Broadband broadband = broadbandService.getBroadbandConnectionById(id);
        if (broadband == null) {
            throw new RuntimeException("Broadband connection id not found - " + id);
        }
        broadbandService.deleteBroadbandConnection(id);
        return "Deleted broadband connection id - " + id;
    }

    // Add plans to broadband
    @PostMapping("/addPlan/{broadbandId}/{planId}")
    public void addPlanToBroadband(@PathVariable int broadbandId, @PathVariable int planId) {
        broadbandService.addPlanToBroadband(broadbandId, planId);
    }
}