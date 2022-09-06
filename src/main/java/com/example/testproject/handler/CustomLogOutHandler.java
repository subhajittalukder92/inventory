package com.example.testproject.handler;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.FlashMap;
import org.springframework.web.servlet.FlashMapManager;
import org.springframework.web.servlet.support.SessionFlashMapManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class CustomLogOutHandler extends SimpleUrlLogoutSuccessHandler {
    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        FlashMap flashMap = new FlashMap();
        flashMap.put("message", "You've been logged out.");
        flashMap.put("className", "alert-success");
        FlashMapManager flashMapManager = new SessionFlashMapManager();
        flashMapManager.saveOutputFlashMap(flashMap, request, response);
        response.sendRedirect("/login");
        super.onLogoutSuccess(request, response, authentication);
    }
}
