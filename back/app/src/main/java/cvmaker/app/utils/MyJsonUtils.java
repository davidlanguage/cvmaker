package cvmaker.app.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

public final class MyJsonUtils {

    private MyJsonUtils() {
        throw new IllegalStateException("Utility class");
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (final Exception e) {
            throw new RuntimeException(e);
        }
    }
}
