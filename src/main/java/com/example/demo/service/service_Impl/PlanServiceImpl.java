package com.example.demo.service.service_Impl;

import com.example.demo.dao.PlanRepository;
import com.example.demo.entity.Plan;
import com.example.demo.service.service_interface.PlanService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanServiceImpl implements PlanService {

    private final PlanRepository planRepository;

    public PlanServiceImpl(PlanRepository planRepository) {
        this.planRepository = planRepository;
    }

    @Override
    public List<Plan> getAllPlans() {
        return planRepository.findAll();
    }

    @Override
    public Plan getPlanById(int id) {
        return planRepository.findById(id).orElse(null);
    }

    @Override
    public Plan savePlan(Plan plan) {
        return planRepository.save(plan);
    }

    @Override
    public void deletePlan(int id) {
        planRepository.deleteById(id);
    }
}