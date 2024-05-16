package be.intecbrussel.jpaonetomanydemo.controller;


import be.intecbrussel.jpaonetomanydemo.exeption.ResourceNotFoundException;
import be.intecbrussel.jpaonetomanydemo.model.Comment;
import be.intecbrussel.jpaonetomanydemo.repository.CommentRepository;
import be.intecbrussel.jpaonetomanydemo.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
/**
 * The CommentController class handles HTTP requests related to comments.
 */
@RestController
public class CommentController {
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private PostRepository postRepository;


    /**
     * Retrieve all comments for a specific post.
     * @param postId The ID of the post for which comments are to be retrieved.
     * @param pageable Pagination information for the results.
     * @return A page of comments associated with the specified post.
     */
    @GetMapping("/posts/{postId}/comments")
    public Page<Comment> getAllCommentsByPostId(@PathVariable(value = "postId") Long postId, Pageable pageable) {
        return commentRepository.findByPostId(postId, pageable);
    }


    /**
     * Create a new comment for a specific post.
     * @param postId The ID of the post to which the comment belongs.
     * @param comment The comment object to be created.
     * @return The created comment.
     */
    @PostMapping("/posts/{postId}/comments")
    public Comment createComment(@PathVariable(value = "postId") Long postId, @Valid @RequestBody Comment comment) {
        return postRepository.findById(postId).map(post -> {
            comment.setPost(post);
            return commentRepository.save(comment);
        }).orElseThrow(() -> new ResourceNotFoundException("PostId " + postId + " not found"));
    }



    /**
     * Update an existing comment for a specific post.
     * @param postId The ID of the post to which the comment belongs.
     * @param commentId The ID of the comment to be updated.
     * @param commentRequest The updated comment object.
     * @return The updated comment.
     */
    @PutMapping("/posts/{postId}/comments/{commentId}")
    public Comment updateComment(@PathVariable(value = "postId") Long postId, @PathVariable(value = "commentId") Long commentId, @Valid @RequestBody Comment commentRequest) {
        if (!postRepository.existsById(postId)) {
            throw new ResourceNotFoundException("PostId " + postId + " not found");
        }
        return commentRepository.findById(commentId).map(comment -> {
            comment.setText(commentRequest.getText());
            return commentRepository.save(comment);
        }).orElseThrow(() -> new ResourceNotFoundException("CommentId " + commentId + "not found"));
    }



    /**
     * Delete a comment associated with a specific post.
     * @param postId The ID of the post to which the comment belongs.
     * @param commentId The ID of the comment to be deleted.
     * @return ResponseEntity with status indicating success or failure of the operation.
     */
    @DeleteMapping("/posts/{postId}/comments/{commentId}")
    public ResponseEntity<?> deleteComment(@PathVariable(value = "postId") Long postId, @PathVariable(value = "commentId") Long commentId) {
        return commentRepository.    // Метод для поиска комментария по его идентификатору и идентификатору поста.
                findByIdAndPostId(commentId, postId).map(comment -> {
            commentRepository.delete(comment);
            return ResponseEntity.ok().build(); // Default Exception die kan gebruikt worden is ResponseStatusException
        }).orElseThrow(() -> new ResourceNotFoundException("Comment not found with id " + commentId + " and postId " + postId));
    }
};



//Аннотация @RestController указывает, что данный класс является контроллером, где каждый метод возвращает объект домена вместо представления.
//Это удобная аннотация, объединяющая @Controller и @ResponseBody, что позволяет избежать необходимости аннотировать каждый метод обработки запроса класса контроллера с @ResponseBody.
//@RestController

// Эта аннотация используется для сопоставления веб-запросов с конкретными классами обработчиков и/или методами обработчиков. Она используется для создания RESTful веб-сервиса.
//@RequestMapping("/posts/{postId}/comments")

// Указывает, что параметр метода должен быть связан с переменной шаблона URI.
//@PathVariable(value = "postId")

// Эта аннотация используется для сопоставления тела запроса HTTP с параметром метода.
//@Valid

//Эта аннотация используется для выполнения проверки корректности входного тела запроса.
//@RequestBody

//// Эта аннотация используется для сопоставления параметров запроса HTTP с аргументами метода.
//@RequestParam

//Эта аннотация используется для привязки параметра метода к телу веб-запроса.
//@RequestBody

//Эта аннотация используется для указания, что аннотированное поле должно быть автоматически заполнено Spring.
//@Autowired

// Эта аннотация указывает, что аннотированный метод должен обрабатывать запросы HTTP GET.
//@GetMapping

//Эта аннотация указывает, что аннотированный метод должен обрабатывать запросы HTTP POST.
//@PostMapping

// Эта аннотация указывает, что аннотированный метод должен обрабатывать запросы HTTP PUT.
//@PutMapping

//Эта аннотация указывает, что аннотированный метод должен обрабатывать запросы HTTP DELETE.
//@DeleteMapping

//Эта аннотация используется для выполнения проверки корректности параметров запроса.
//@RequestParam

//Эта аннотация используется для проверки корректности тела запроса.
//@Valid

//Эта аннотация используется для обработки исключений, выбрасываемых маппингами запросов.
//@ExceptionHandler

//Эта аннотация используется для указания, что параметр метода должен быть связан с конкретным заголовком.
//@RequestHeader

//Эта аннотация используется для указания групп проверки корректности, которые должны применяться к шагу проверки, запущенному аннотированным методом или классом.
//@Validated
























