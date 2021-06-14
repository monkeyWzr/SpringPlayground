package playground.hateoas;

import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;

public class UserEntityModelAssembler extends RepresentationModelAssemblerSupport<User, UserEntityModel> {
    public UserEntityModelAssembler() {
        super(UserController.class, UserEntityModel.class);
    }

    @Override
    public UserEntityModel toModel(User user) {
        return this.createModelWithId(user.getId(), user);
    }

    @Override
    public UserEntityModel instantiateModel(User user) {
        return new UserEntityModel(user);
    }

}
