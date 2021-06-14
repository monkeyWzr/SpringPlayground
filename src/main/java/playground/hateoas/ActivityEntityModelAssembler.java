package playground.hateoas;

import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;

public class ActivityEntityModelAssembler extends RepresentationModelAssemblerSupport<Activity, ActivityEntityModel>{

    public ActivityEntityModelAssembler() {
        super(ActivityController.class, ActivityEntityModel.class);
    }

    @Override
    public ActivityEntityModel toModel(Activity activity) {
        return this.createModelWithId(activity.getId(), activity);
    }

    @Override
    public ActivityEntityModel instantiateModel(Activity activity) {
        return new ActivityEntityModel(activity);
    }

}
