package cvmaker.app.userdata;

interface CreateUserDataDao {

    boolean create(final UserData userData) throws EmailHasWrongPatternError;
}
