package com.okta.example.autenticacion.login;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.saml2.provider.service.authentication.Saml2AuthenticatedPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.okta.example.autenticacion.login.model.DatosLogin;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class HomeController {

    @RequestMapping("/")
    public ResponseEntity<DatosLogin> home(@AuthenticationPrincipal Saml2AuthenticatedPrincipal principal) {
    	log.info("Logueando....");
    	DatosLogin response = new DatosLogin();
    	response.setName(principal.getName());
    	response.setEmail(principal.getFirstAttribute("email"));
    	response.setAttributes(principal.getAttribute("groups"));
        return ResponseEntity.ok(response);
    }
}