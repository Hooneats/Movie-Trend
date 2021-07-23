package com.example.demo.controller;

import com.example.demo.service.CrawlingDetailDto;
import com.example.demo.service.MovieDetailDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/detail")
public class DetailController {

    private String my_id = "160f05c35f34aef167fabe796efb2a8e";

    @GetMapping("/{id}")
    public String crawlingDetailDto(@PathVariable("id") Long id, Model model) {
        String url = "https://api.themoviedb.org/3/movie/" + id + "?api_key=" + my_id;
        List<String> genresName = new ArrayList<>();
        CrawlingDetailDto crDetail = new CrawlingDetailDto();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            crDetail = objectMapper.readValue(new URL(url), CrawlingDetailDto.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        MovieDetailDto movieDetailDto = new MovieDetailDto(crDetail.getAdult(), crDetail.getBackdrop_path(),
                crDetail.getPoster_path(), crDetail.getHomepage(), crDetail.getOriginal_language(), crDetail.getOriginal_title(),
                crDetail.getTitle(), crDetail.getOverview(), crDetail.getRelease_date(), crDetail.getRuntime(), crDetail.getStatus(),
                crDetail.getVote_average(), crDetail.getVote_count());
        for (Map m : crDetail.getGenres()) {
            m.forEach((key,value) -> {
                if ("name".equals(key)) {
                    genresName.add(String.valueOf(value));
                }});
        }
        movieDetailDto.setGenres(genresName);
        model.addAttribute("movieDetail", movieDetailDto);
        return "detail";
    }

}
