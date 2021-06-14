package playground.hateoas;

import org.springframework.hateoas.RepresentationModel;

import lombok.Getter;

public class ActivityEntityModel extends RepresentationModel<ActivityEntityModel> {

    @Getter
    private User user;
    @Getter
    private String detail;

    public ActivityEntityModel(Activity activity) {
        this.user = activity.getUser();
        this.detail = activity.getDetail();
    }

}
