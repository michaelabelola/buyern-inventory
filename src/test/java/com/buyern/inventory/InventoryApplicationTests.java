package com.buyern.inventory;

import com.buyern.inventory.services.InventoryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;

@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@SpringBootTest
//@AutoConfigureMockMvc
//@TestPropertySource(locations= "classpath:application-test.properties")
class InventoryApplicationTests {

    @LocalServerPort
    private int port;
    @Autowired
    private InventoryService inventoryService;

    @Test
    void contextLoads() {

    }

}
