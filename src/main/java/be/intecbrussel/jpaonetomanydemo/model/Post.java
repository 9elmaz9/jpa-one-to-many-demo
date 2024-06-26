package be.intecbrussel.jpaonetomanydemo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.HashSet;
import java.util.Set;

// Аннотация @Entity указывает, что данный класс является сущностью, представляющей таблицу в базе данных.

@Entity
@Table(name = "posts")   // Аннотация @Table указывает на имя таблицы, в которой будут храниться объекты этой сущности.

public class Post extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    // Аннотация @GeneratedValue указывает на то, что значение этого поля будет автоматически генерироваться.

    private Long id;
    @NotNull     // Аннотация @NotNull обозначает, что это поле не может быть пустым.

    @Size(max = 100)      // Аннотация @Size указывает на максимальный размер для значения этого поля.

    @Column(unique = true)      // Аннотация @Column позволяет настроить свойства столбца базы данных.

    private String title;
    @NotNull
    @Size(max = 250)
    private String description;

    public Post() {
    }

    @NotNull
    @Lob       // Аннотация @Lob указывает, что это поле представляет собой большой объект.

    private String content;

    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }


    // Связь "один ко многим" с сущностью Comment.
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "post")
    private Set<Comment> comments = new HashSet<>();

    public Post(String title, String description, String content) {
        this.title = title;
        this.description = description;
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", content='" + content + '\'' +
                ", comments=" + comments +
                '}';
    }
}