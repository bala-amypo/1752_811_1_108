package com.example.demo;

import com.example.demo.servlet.HelloServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.junit.jupiter.api.Test;

import java.io.PrintWriter;
import java.io.StringWriter;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class DynamicEventTicketPricingEngineApplicationTests {

    @Test
    void helloServletTest() throws Exception {
        HelloServlet servlet = new HelloServlet();

        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);

        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);

        when(response.getWriter()).thenReturn(pw);

        servlet.doGet(request, response);

        assertEquals("Hello World", sw.toString());
    }
}
