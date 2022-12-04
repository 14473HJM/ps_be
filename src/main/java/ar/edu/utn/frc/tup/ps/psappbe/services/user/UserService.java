package ar.edu.utn.frc.tup.ps.psappbe.services.user;

import ar.edu.utn.frc.tup.ps.psappbe.domain.user.User;
import ar.edu.utn.frc.tup.ps.psappbe.entities.user.UserEntity;
import ar.edu.utn.frc.tup.ps.psappbe.services.BaseModelService;

public interface UserService extends BaseModelService<User, UserEntity> {

    User getByUserName(String userName);

    Boolean isAdmin(User user);

    void changePassword(String userName, String password);
}
