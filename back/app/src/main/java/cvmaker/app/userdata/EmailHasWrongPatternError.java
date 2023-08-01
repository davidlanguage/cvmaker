package cvmaker.app.userdata;

public class EmailHasWrongPatternError extends Throwable {
    public EmailHasWrongPatternError(final String message){
        super(message);
    }
}
