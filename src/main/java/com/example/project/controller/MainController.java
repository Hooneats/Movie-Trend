package com.example.project.controller;

import com.example.project.service.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class MainController {

    private String my_id = "160f05c35f34aef167fabe796efb2a8e";


    //original_title, poster_path, vote_average, overview, release_date, title, original_language , id, backdrop_path
    @RequestMapping(value = "/")
    public String crawlingMainDto(Model model) {
        List<MovieDto> movieDtoList = new ArrayList<>();
        String url = "https://api.themoviedb.org/3/trending/movie/day?api_key=" + my_id;
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            CrawlingMainDto craw = objectMapper.readValue(new URL(url), CrawlingMainDto.class);
            for (Map s : craw.getResults()) {
                MovieDto movieDto = new MovieDto();
                for (Object o : s.keySet()) {
                    if ("id".equals(o)) {
                        movieDto.setId(Long.parseLong(String.valueOf(s.get(o))));
                    } else if ("original_title".equals(o)) {
                        movieDto.setOriginal_title(String.valueOf(s.get(o)));
                    } else if ("title".equals(o)) {
                        movieDto.setTitle(String.valueOf(s.get(o)));
                    } else if ("original_language".equals(o)) {
                        movieDto.setOriginal_language(String.valueOf(s.get(o)));
                    } else if ("release_date".equals(o)) {
                        movieDto.setRelease_date(Date.valueOf(String.valueOf(s.get(o))));
                    } else if ("vote_average".equals(o)) {
                        movieDto.setVote_average(String.valueOf(s.get(o)));
                    } else if ("overview".equals(o)) {
                        movieDto.setOverview(String.valueOf(s.get(o)));
                    } else if ("poster_path".equals(o)) {
                        movieDto.setPoster_path(String.valueOf(s.get(o)));
                    } else if ("backdrop_path".equals(o)) {
                        movieDto.setBackdrop_path(String.valueOf(s.get(o)));
                    }
                }
                movieDtoList.add(movieDto);
            }
            model.addAttribute("movieList", movieDtoList);
            return "index";
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping("/search")
    public String crawlingSearchDto(@RequestParam(required = false) String query, Model model) {
        if (query.trim().isEmpty()) {
            return "redirect:/";
        }
        String search = query;
        String url = "https://api.themoviedb.org/3/search/movie?api_key=" + my_id + "&query=" + search;
        ObjectMapper objectMapper = new ObjectMapper();
        List<MovieDto> resultList = new ArrayList<>();
        try {
            CrawlingSearchDto crawlingSearchDto = objectMapper.readValue(new URL(url), CrawlingSearchDto.class);
            for (Map s : crawlingSearchDto.getResults()) {
                MovieDto movieDto = new MovieDto();
                for (Object o : s.keySet()) {
                    if ("id".equals(o)) {
                        movieDto.setId(Long.parseLong(String.valueOf(s.get(o))));
                    } else if ("original_title".equals(o)) {
                        movieDto.setOriginal_title(String.valueOf(s.get(o)));
                    } else if ("title".equals(o)) {
                        movieDto.setTitle(String.valueOf(s.get(o)));
                    } else if ("original_language".equals(o)) {
                        movieDto.setOriginal_language(String.valueOf(s.get(o)));
                    } else if ("release_date".equals(o)) {
                        movieDto.setRelease_date(Date.valueOf(String.valueOf(s.get(o))));
                    } else if ("vote_average".equals(o)) {
                        movieDto.setVote_average(String.valueOf(s.get(o)));
                    } else if ("overview".equals(o)) {
                        movieDto.setOverview(String.valueOf(s.get(o)));
                    } else if ("poster_path".equals(o)) {
                        movieDto.setPoster_path(String.valueOf(s.get(o)));
                    } else if ("backdrop_path".equals(o)) {
                        movieDto.setBackdrop_path(String.valueOf(s.get(o)));
                    }
                }
                resultList.add(movieDto);
            }
            model.addAttribute("movieList", resultList);
            return "index";
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
