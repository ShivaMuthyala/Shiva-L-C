package Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import Entity.News;

public interface NewsRepo extends JpaRepository<News, Integer>{

}
