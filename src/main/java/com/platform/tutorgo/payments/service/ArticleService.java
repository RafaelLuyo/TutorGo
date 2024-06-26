package com.platform.tutorgo.payments.service;

import com.platform.tutorgo.payments.model.Article;
import com.platform.tutorgo.payments.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticleService {

    @Autowired
    ArticleRepository articuloRepository;

    public List<Article> list(){
        List<Article> list = articuloRepository.findAll();
        return list;
    }

    public Optional<Article> getById(long id){
        return articuloRepository.findById(id);
    }

    public Optional<Article> getByName(String name){
        return articuloRepository.findByName(name);
    }

    public void save(Article article){
        articuloRepository.save(article);
    }

    public void delete(long id){
        articuloRepository.deleteById(id);
    }

    public boolean existsId(long id){
        return articuloRepository.existsById(id);
    }

    public boolean existsName(String name){return articuloRepository.existsByName(name);
    }
}
