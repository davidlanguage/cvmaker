package cvmaker.app.userdata;

interface CreateUserDataDao {

    UserData create(final UserData userData) throws EmailHasWrongPatternError;
}
