package playground.hateoas;

import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/activity")
public class ActivityController {

    private ActivityJpaRepository activityRepo;

    public ActivityController(ActivityJpaRepository activityRepo) {
        this.activityRepo = activityRepo;
    }

    @GetMapping("/{id}")
    public ActivityEntityModel getActivityResource(@PathVariable Integer id) {
        Activity activity = activityRepo.findById(id).orElseThrow(ResourceNotFoundException::new);
        return new ActivityEntityModelAssembler().toModel(activity);
    }

}
