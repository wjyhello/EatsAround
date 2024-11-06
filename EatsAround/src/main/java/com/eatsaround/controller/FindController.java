package com.eatsaround.controller;

import java.net.URI;
import java.nio.charset.StandardCharsets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@RequestMapping("/find")
@Controller
public class FindController {

    private final String clientId = "clientId";
    private final String clientSecret = "password";
    
    private static final Logger logger = LoggerFactory.getLogger(FindController.class);
    
    @GetMapping
    public String findAquarium(Model model) {
        logger.info("아쿠아리움 찾기 요청");
        return "/aquarium/find"; // JSP 페이지로 이동
    }

    @GetMapping(value = "/naver-proxy", produces = "application/json; charset=UTF-8")
    public ResponseEntity<String> findAquarium(@RequestParam("query") String query,
                                               @RequestParam("lat") double lat,
                                               @RequestParam("lng") double lng) {
        // URI 구성
        URI uri = UriComponentsBuilder
                .fromUriString("https://openapi.naver.com/v1/search/local.json")
                .queryParam("query", query)
                .queryParam("display", 5)
                .queryParam("start", 1)
                .queryParam("sort", "random")
                .encode(StandardCharsets.UTF_8)
                .build()
                .toUri();

        // 헤더 설정
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-Naver-Client-Id", clientId);
        headers.set("X-Naver-Client-Secret", clientSecret);

        // 요청 생성
        HttpEntity<Void> requestEntity = new HttpEntity<>(headers);

        // API 호출
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.exchange(uri, HttpMethod.GET, requestEntity, String.class);

        // API 응답 반환
        return responseEntity;
    }
}
