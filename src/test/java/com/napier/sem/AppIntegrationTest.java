package com.napier.sem;



import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class AppIntegrationTest
{
    static App app;

    @BeforeAll
    static void init()
    {
        app = new App();
        app.connect();
    }

    @Test
    void testGetEmployee()
    {
       City c=new City();
       c= app.getCity("2");
       assertEquals(c.getName(),"Qandahar");
       assertEquals(c.getId(),"2");

    }
}