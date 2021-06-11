package playground.enum_persisting;

import java.util.stream.Stream;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PostLoad;
import javax.persistence.PrePersist;
import javax.persistence.Transient;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;

    @Basic
    @Setter(AccessLevel.PRIVATE)
    @Column(name="priority")
    private int priorityValue;

    @Transient
    private Priority priority;

    @PostLoad
    public void fillTransient() {
        if(this.priorityValue > 0) {
            this.priority = Priority.of(priorityValue);
        }
    }

    @PrePersist
    public void fillPersistent() {
        if (this.priority != null) {
            this.priorityValue = this.priority.getPriority();
        }
    }


    public static enum Priority {
        LOW(100), MEDIUM(200), HIGH(300);

        @Getter
        private int priority;

        private Priority(int priority) {
            this.priority = priority;
        }

        public static Priority of(int priority) {
            return Stream.of(Priority.values())
                    .filter(value -> value.getPriority() == priority)
                    .findFirst()
                    .orElseThrow(IllegalArgumentException::new);
        }
    }

}
