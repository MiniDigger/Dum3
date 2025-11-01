package dev.hangarmc.hangar.version.factory;

import dev.hangarmc.hangar.version.VersionCreatedEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
class VersionFactory {

    private final ApplicationEventPublisher eventPublisher;
    private final PluginDataService pluginDataService;

    VersionFactory(ApplicationEventPublisher eventPublisher, PluginDataService pluginDataService) {
        this.eventPublisher = eventPublisher;
        this.pluginDataService = pluginDataService;
    }

    void createVersion() {
        // TODO validation

        // TODO save to db

        eventPublisher.publishEvent(new VersionCreatedEvent());
    }
}
