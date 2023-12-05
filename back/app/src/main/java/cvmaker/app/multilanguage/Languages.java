package cvmaker.app.multilanguage;

public enum Languages {

    //If additional languages are added, they must also be included in LanguageConfig.java
    ENGLISH("en"), SPANISH("es"), GERMAN("de");
    private final String language;
    public String getLanguage(){
        return this.language;
    }
    private Languages(final String language) {
        this.language = language;
    }



}
