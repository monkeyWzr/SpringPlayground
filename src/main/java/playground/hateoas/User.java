package playground.hateoas;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private LocalDateTime createdAt = LocalDateTime.now();

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Activity> activities;

}
