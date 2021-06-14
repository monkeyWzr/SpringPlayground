package playground.hateoas;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.RepresentationModel;

import lombok.Getter;

public class UserEntityModel extends RepresentationModel<UserEntityModel> {

    private ActivityEntityModelAssembler activityEntityModelAssembler = new ActivityEntityModelAssembler();
    @Getter
    private String name;
    @Getter
    private CollectionModel<ActivityEntityModel> activities;

    public UserEntityModel(User user) {
        this.name = user.getName();
        this.activities = activityEntityModelAssembler.toCollectionModel(user.getActivities());
    }


}
