package com.platform.tutorgo.payments.controller;

import com.platform.tutorgo.payments.http.Message;
import com.platform.tutorgo.payments.model.Article;
import com.platform.tutorgo.payments.service.ArticleService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/articles", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Articles", description = "Article Management Endpoints")
public class ArticleController {

    @Autowired
    ArticleService articleService;

    @GetMapping("/list")
    public ResponseEntity<List<Article>> list(){
        List<Article> list = articleService.list();
        return new ResponseEntity<List<Article>>(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Article> detalle(@PathVariable("id") long id){
        if(!articleService.existsId(id))
            return new ResponseEntity(new Message("no existe"), HttpStatus.NOT_FOUND);
        Article articulo = articleService.getById(id).get();
        return new ResponseEntity<Article>(articulo, HttpStatus.OK);
    }

    @PostMapping("/new")
    public ResponseEntity<?> crear(@RequestBody Article articulo){
        if(StringUtils.isBlank(articulo.getName()))
            return new ResponseEntity(new Message("required name"), HttpStatus.BAD_REQUEST);
        if((Integer)articulo.getPrice() == null || articulo.getPrice() < 1)
            return new ResponseEntity(new Message("required price"), HttpStatus.BAD_REQUEST);
        if(articleService.existsName(articulo.getName()))
            return new ResponseEntity(new Message("that name already exists"), HttpStatus.BAD_REQUEST);
        articleService.save(articulo);
        return new ResponseEntity(new Message("article created"), HttpStatus.CREATED);
    }
}
