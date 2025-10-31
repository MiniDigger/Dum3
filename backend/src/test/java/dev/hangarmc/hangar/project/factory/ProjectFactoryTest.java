package dev.hangarmc.hangar.project.factory;

import dev.hangarmc.hangar.project.ProjectCreatedEvent;
import dev.hangarmc.hangar.project.factory.ProjectFactoryController.ProjectCreateRequest;
import org.junit.jupiter.api.Test;
import org.springframework.modulith.test.ApplicationModuleTest;
import org.springframework.modulith.test.Scenario;

import static org.assertj.core.api.Assertions.assertThat;

@ApplicationModuleTest
class ProjectFactoryTest {

    private final ProjectFactory projectFactory;

    ProjectFactoryTest(ProjectFactory projectFactory) {
        this.projectFactory = projectFactory;
    }

    @Test
    void testProjectCreation(Scenario scenario) {
        scenario.stimulate(() -> projectFactory.createProject(new ProjectCreateRequest("TestProject", "A test project")))
                .andWaitForEventOfType(ProjectCreatedEvent.class)
                .toArriveAndVerify(event -> {
                    assertThat(event).isNotNull();
                    assertThat(event.project()).isNotNull();
                    assertThat(event.project().name()).isEqualTo("TestProject");
                    assertThat(event.project().id()).isNotEqualTo(-1);
                });
    }
}
