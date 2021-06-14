package playground.hateoas;

import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    private UserJpaRepository userRepo;

    public UserController(UserJpaRepository userRepo) {
        this.userRepo = userRepo;
    }

    @GetMapping("/{id}/without-hateoas")
    public User getUser(@PathVariable("id") Integer userId) {
        return userRepo.findById(userId).orElseThrow(ResourceNotFoundException::new);
    }

    @GetMapping("/{id}")
    public UserEntityModel getUserResource(@PathVariable("id") Integer userId) {
        User user = userRepo.findById(userId).orElseThrow(ResourceNotFoundException::new);
        return new UserEntityModelAssembler().toModel(user);
    }

    @GetMapping
    public CollectionModel<UserEntityModel> getUserResources() {
//        return userRepo.findById(userId).orElseThrow(ResourceNotFoundException::new);
        Iterable<User> users = userRepo.findAll();
        CollectionModel<UserEntityModel> userResources = new UserEntityModelAssembler().toCollectionModel(users);
        userResources.add(WebMvcLinkBuilder.linkTo(UserController.class)
//                .slash("with-hateoas/user")
                .withRel("users"));
        return userResources;
    }
}
