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
    PAPER("Paper", "https://papermc.io/downloads", true),
    WATERFALL("Waterfall", "https://papermc.io/downloads#Waterfall", true),
    VELOCITY("Velocity", "https://www.velocitypowered.com/downloads", true);

    private static final Platform[] VALUES = values();

    private final String name;
    private final boolean isVisible;
    private final String url;

    Platform(final String name, final String url, final boolean isVisible) {
        this.name = name;
        this.url = url;
        this.isVisible = isVisible;
    }

    public String getName() {
        return this.name;
    }

    @JsonValue
    public String getEnumName() {
        return this.name();
    }

    public boolean isVisible() {
        return this.isVisible;
    }

    public String getUrl() {
        return this.url;
    }

    public static Platform[] getValues() {
        return VALUES;
    }
}
