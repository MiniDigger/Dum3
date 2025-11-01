package dev.hangarmc.hangar.version.scanning;

import dev.hangarmc.hangar.version.VersionCreatedEvent;
import org.springframework.modulith.events.ApplicationModuleListener;
import org.springframework.stereotype.Service;

@Service
class JarScanningService {

    @ApplicationModuleListener
    void onVersionCreated(VersionCreatedEvent event) {
        // TODO scan
    }
}
