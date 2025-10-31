package dev.hangarmc.hangar.project.factory;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api/internal/project/factory")
class ProjectFactoryController {

    private final ProjectFactory projectFactory;

    ProjectFactoryController(ProjectFactory projectFactory) {
        this.projectFactory = projectFactory;
    }

    @PostMapping("/create")
    void createProject(ProjectCreateRequest request) {
        projectFactory.createProject(request);
    }

    record ProjectCreateRequest(String name, String description) {

    }
}
