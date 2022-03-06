package com.comtrade.Comtrade.Controller;

import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


@Profile("ext")
@RestController
@CrossOrigin(origins = "*")
public class ExternalLangController {

    RestTemplate restTemplate = new RestTemplate();

    // 403 FORBIDDEN
    public String getToken() {
        try {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        headers.set("Accept", "*/*");
        HttpEntity<String> entity = new HttpEntity<>(headers);

        return this.restTemplate.exchange("https://translate.systran.net/oidc", HttpMethod.POST, entity, String.class).getBody();

    } catch (Exception ex) {
            return ex.getMessage();
        }
    }

    // RETURNS INVALID TOKEN
    @PostMapping("/hello")
    public String externalApi(@RequestParam(name = "input") String input, @RequestParam(name = "target") String target) {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setBearerAuth(getToken());
            headers.set("Content-Type", "application/json");
            headers.set("Accept", "*/*");
            HttpEntity<String> entity = new HttpEntity<>(headers);
            return this.restTemplate.exchange("https://api-translate.systran.net/translation/text/translate", HttpMethod.POST, entity, String.class, input, target).getBody();
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }
}
