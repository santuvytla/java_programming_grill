package com.company;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.junit.runners.JUnit4;
public class tstcas {


        @Test
        public void testSomeDashLowerStart() {
            String input = "Wall_left_south_Green_down_Lake";
            System.out.println("input: "+input);
            assertEquals("Wall_left_south_Green_down_Lake", camlcase.toCamelCase(input));
        }
    }

