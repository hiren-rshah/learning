package com.self.learning.cntr;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@WebMvcTest(value = DateTimeCntr.class, secure = false)
public class DateTimeCntrTest {

    @Autowired
    DateTimeCntr dayTimeCntr;

    @Test
    public void getTimeTest(){
        //assertEquals("11 Mar 2019 04", dayTimeCntr.getTime(Optional.of("IST")));
        
        assertEquals("11 Mar 2019 06", dayTimeCntr.getTime(Optional.of("IST")));
    }
}