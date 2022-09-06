package com.example.testproject.handler;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.FlashMap;
import org.springframework.web.servlet.FlashMapManager;
import org.springframework.web.servlet.support.SessionFlashMapManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@Component
public class CustomLoginFailureHandler extends SimpleUrlAuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        System.out.println(exception);
        FlashMap flashMap = new FlashMap();
        flashMap.put("message", exception.getMessage());
        flashMap.put("className", "alert-danger");
        flashMap.put("userName", request.getParameter("username"));
        FlashMapManager flashMapManager = new SessionFlashMapManager();
        flashMapManager.saveOutputFlashMap(flashMap, request, response);
        response.sendRedirect("/login");
        // super.onAuthenticationFailure(request, response, exception);
    }
}
