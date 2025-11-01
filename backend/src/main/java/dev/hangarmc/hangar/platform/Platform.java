package dev.hangarmc.hangar.platform;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import org.jdbi.v3.core.enums.EnumByOrdinal;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
@EnumByOrdinal
@Schema(description = "Server platform", example = "PAPER")
public enum Platform {

    // NOTE: The order here should always be the order they are displayed whenever there is a list somewhere on the frontend
    PAPER("Paper", "https://papermc.io/downloads/paper/"),
    WATERFALL("Waterfall", "https://papermc.io/software/waterfall/"),
    VELOCITY("Velocity", "https://papermc.io/software/velocity/"),
    FOLIA("Folia", "https://papermc.io/software/folia/");

    private static final Platform[] VALUES = values();

    private final String name;
    private final String url;

    Platform(final String name, final String url) {
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return this.name;
    }

    @JsonValue
    public String getEnumName() {
        return this.name();
    }

    public String getUrl() {
        return this.url;
    }

    public static Platform[] getValues() {
        return VALUES;
    }
}
