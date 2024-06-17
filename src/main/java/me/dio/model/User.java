package me.dio.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Objects;

@Entity(name = "tb_user")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private Long id;
    private String name;
    private Account account;
    private Card card;
    private List<Feature> features;
    private List<News> news;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


}
