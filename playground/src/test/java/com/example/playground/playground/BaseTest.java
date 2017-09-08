package com.example.playground.playground;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by BurggrafM on 08.09.2017.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles({"test"})
@Configuration
@ComponentScan({"com.example.playground"})
public abstract class BaseTest {
}
