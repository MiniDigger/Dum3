package dev.hangarmc.hangar;

import org.junit.jupiter.api.Test;
import org.springframework.modulith.core.ApplicationModules;
import org.springframework.modulith.docs.Documenter;

class ModularityTests {

    @Test
    void verifyModularity() {
        ApplicationModules modules = ApplicationModules.of(HangarApplication.class);
        modules.verify();

        new Documenter(modules).writeDocumentation();
    }
}
