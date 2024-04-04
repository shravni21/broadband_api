package com.example.demo.service.service_interface;

import com.example.demo.entity.Broadband;

import java.util.List;

public interface BroadbandService {
    List<Broadband> getAllBroadbandConnections();

    Broadband saveBroadbandConnection(Broadband broadband);

    Broadband getBroadbandConnectionById(Integer id);

    void deleteBroadbandConnection(Integer id);

    void addPlanToBroadband(int broadbandId, int planId);
}
