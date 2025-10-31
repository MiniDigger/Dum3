package dev.hangarmc.hangar.project.factory;

import dev.hangarmc.hangar.project.Project;
import dev.hangarmc.hangar.project.ProjectCreatedEvent;
import dev.hangarmc.hangar.project.factory.ProjectFactoryController.ProjectCreateRequest;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
class ProjectFactory {

    private final ApplicationEventPublisher eventPublisher;

    ProjectFactory(ApplicationEventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    void createProject(ProjectCreateRequest request) {
        // TODO validation

        Project project = new Project(-1, request.name());

        // TODO save to db
//        Project withId = db.persist(project);
        Project withId = new Project(1, project.name());

        eventPublisher.publishEvent(new ProjectCreatedEvent(withId));
    }
}
