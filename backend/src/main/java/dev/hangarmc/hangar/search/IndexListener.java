package dev.hangarmc.hangar.search;

import dev.hangarmc.hangar.project.ProjectCreatedEvent;
import dev.hangarmc.hangar.project.ProjectUpdatedEvent;
import dev.hangarmc.hangar.version.VersionCreatedEvent;
import dev.hangarmc.hangar.version.VersionUpdatedEvent;
import org.springframework.modulith.events.ApplicationModuleListener;
import org.springframework.stereotype.Component;

@Component
class IndexListener {

    private final IndexService indexService;

    IndexListener(IndexService indexService) {
        this.indexService = indexService;
    }

    @ApplicationModuleListener
    void onProjectCreated(ProjectCreatedEvent event) {
        // TODO index the new project
        indexService.indexProject();
    }

    @ApplicationModuleListener
    void onProjectUpdated(ProjectUpdatedEvent event) {
        // TODO reindex the updated project
        indexService.indexProject();
    }

    @ApplicationModuleListener
    void onVersionCreated(VersionCreatedEvent event) {
        // TODO create the index
        indexService.indexVersion();
    }

    @ApplicationModuleListener
    void onVersionUpdated(VersionUpdatedEvent event) {
        // TODO reindex the updated version
        indexService.indexVersion();
    }
}
