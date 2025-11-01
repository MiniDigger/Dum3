package dev.hangarmc.hangar;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.text.MessageFormat;
import java.util.Locale;

public class HangarApiException extends ResponseStatusException {

    private final Message message;
    private final Object[] args;

    public HangarApiException(final HttpStatus status, final Message message, final Object... args) {
        super(status, message.key);
        this.message = message;
        this.args = args;
    }

    public HangarApiException(final Message message) {
        super(HttpStatus.BAD_REQUEST, message.key);
        this.message = message;
        this.args = new String[0];
    }

    public Object[] getArgs() {
        return args;
    }

    public String getMessageKey() {
        return message.getKey();
    }

    @Override
    public String getMessage() {
        return getStatusCode() + ": " + new MessageFormat(message.getDefaultValue()).format(this.args);
    }

    public enum Message {
        VERSION_NEW_ERROR_META_NOT_FOUND("Could not load metadata from uploaded file"),
        VERSION_NEW_ERROR_INCOMPLETE("Plugin file missing {0}"),
        VERSION_NEW_ERROR_JAR_NOT_FOUND("Could not open jar file");

        private final String key;
        private final String defaultValue;

        Message(String defaultValue) {
            this.key = name().toLowerCase(Locale.ROOT).replace('_', '.');
            this.defaultValue = defaultValue;
        }

        public String getKey() {
            return key;
        }

        public String getDefaultValue() {
            return defaultValue;
        }
    }
}
