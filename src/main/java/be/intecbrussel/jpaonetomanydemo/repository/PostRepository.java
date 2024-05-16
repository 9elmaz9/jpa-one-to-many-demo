package be.intecbrussel.jpaonetomanydemo.repository;

import be.intecbrussel.jpaonetomanydemo.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Аннотация @Repository указывает, что данный класс является репозиторием Spring.

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
}