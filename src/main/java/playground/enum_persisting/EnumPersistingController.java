package playground.enum_persisting;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import playground.enum_persisting.Article.Status;
import playground.enum_persisting.Article.Type;
import playground.enum_persisting.Event.Category;
import playground.enum_persisting.Task.Priority;

@RestController
@RequestMapping("/enum-persisting")
public class EnumPersistingController {

    private final ArticleRepository articleRepo;
    private final TaskRepository taskRepo;
    private final EventRepository eventRepo;
    private final EventJpaRepository eventJpaRepo;

    public EnumPersistingController(ArticleRepository articleRepo,
            TaskRepository taskRepo, EventRepository eventRepo, EventJpaRepository eventJpaRepo) {
        this.articleRepo = articleRepo;
        this.taskRepo = taskRepo;
        this.eventRepo = eventRepo;
        this.eventJpaRepo = eventJpaRepo;
    }

    @GetMapping("/by-annotation")
    public Article byAnnotation() {
        Article article = new Article();
        article.setStatus(Status.OPEN);
        article.setTitle("Using @Enumerated to persist enum");
        article.setType(Type.INTERNAL);

        return articleRepo.save(article);
    }

    @GetMapping("/by-jpa-callback")
    public Task byJPACallBack() {
        Task task = new Task();
        task.setTitle("Using @PostLoad and @PrePersist to persist enum");
        task.setPriority(Priority.MEDIUM);
        return taskRepo.save(task);
    }

    @GetMapping("/by-jpa-converter")
    public Event byJPAConverter() {
        Event event = new Event();
        event.setTitle("Using custom javax.persistence.Converter to persist enum");
        event.setCategory(Category.MUSIC);

        return eventRepo.save(event);
    }

    @GetMapping("/using-enum-in-jpql")
    public List<Event> enumInJPQL() {

        List<Event> events = new ArrayList<>();
        for (Category category : Category.values()) {
            Event event = new Event();
            event.setTitle("Using custom javax.persistence.Converter to persist enum");
            event.setCategory(category);
            events.add(event);
        }
        eventJpaRepo.saveAll(events);

        return eventJpaRepo.findAllByCategory(Category.TECHNOLOGY);
    }
}
