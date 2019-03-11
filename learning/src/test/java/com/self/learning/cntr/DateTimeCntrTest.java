package com.self.learning.cntr;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.DateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy hh");
        assertEquals(now.format(formatter), dayTimeCntr.getTime(Optional.of("IST")));
    }
}