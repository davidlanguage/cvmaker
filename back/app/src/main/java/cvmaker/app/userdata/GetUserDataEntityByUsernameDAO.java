package cvmaker.app.userdata;

public interface GetUserDataEntityByUsernameDAO {
    UserDataEntity findByUsername(final String email);
}
