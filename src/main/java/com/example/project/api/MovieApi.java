package com.example.project.api;

import com.example.project.service.JsonSearchVo;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URL;

@RestController
public class MovieApi {

    private String my_id = "160f05c35f34aef167fabe796efb2a8e";

    @GetMapping("/api/search")
    public JsonSearchVo jsonSearch(@RequestParam(value = "query", required = false) String query) {
        if (query.trim().isEmpty()) {
            return null;
        } else {
            query = query.trim().replaceAll(" ", "+");
        }
        String url = "https://api.themoviedb.org/3/search/movie?api_key=" + my_id + "&query=" + query;
        try {
            JsonSearchVo jsonSearchVo = new ObjectMapper().readValue(new URL(url), JsonSearchVo.class);
            return jsonSearchVo;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
