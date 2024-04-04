package com.example.demo.repository;

import com.example.demo.dao.BroadbandRepository;
import com.example.demo.entity.Broadband;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
public class BroadbandRepositoryTest {
    @Autowired
    private BroadbandRepository broadbandRepository;

    @Test
    void save() {
        // Arrange --> setting up the data
        Broadband broadband = new Broadband();
        broadband.setProviderName("Airtel");

        // Act ---> calling method or unit being tested
        Broadband newBroadband = broadbandRepository.save(broadband);

        // Assert ----> verifying the data which is as expected or not
        assertNotNull(newBroadband);
        assertThat(newBroadband.getProviderName()).isEqualTo("Airtel");
    }
}
