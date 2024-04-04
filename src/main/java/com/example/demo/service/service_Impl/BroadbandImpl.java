package com.example.demo.service.service_Impl;

import com.example.demo.dao.BroadbandRepository;
import com.example.demo.dao.PlanRepository;
import com.example.demo.entity.Broadband;
import com.example.demo.entity.Plan;
import com.example.demo.service.service_interface.BroadbandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BroadbandImpl implements BroadbandService {
    private BroadbandRepository broadbandRepository;
    @Autowired
    private PlanRepository planRepository;

    @Autowired
    public BroadbandImpl(BroadbandRepository broadbandRepository) {
        this.broadbandRepository = broadbandRepository;
    }

    @Override
    public List<Broadband> getAllBroadbandConnections() {
        return broadbandRepository.findAll();
    }

    @Override
    public Broadband saveBroadbandConnection(Broadband broadband) {
        return broadbandRepository.save(broadband);
    }

    @Override
    public Broadband getBroadbandConnectionById(Integer id) {
        return broadbandRepository.findById(id).orElse(null);
    }
    @Override
    public void deleteBroadbandConnection(Integer id) {
        broadbandRepository.deleteById(id);
    }

    @Override
    public void addPlanToBroadband(int broadbandId, int planId) {
        Broadband broadband=broadbandRepository.findById(broadbandId).orElse(null);
        Plan plan=planRepository.findById(planId).orElse(null);

        List<Plan> plans=broadband.getPlans();
        plans.add(plan);

        broadbandRepository.save(broadband);
    }
}