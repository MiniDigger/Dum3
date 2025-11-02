package dev.hangarmc.hangar.project.factory;

import dev.hangarmc.hangar.HangarConfigs;
import dev.hangarmc.hangar.HangarDBConfigs;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@HangarDBConfigs
@WebMvcTest(ProjectFactoryController.class)
class ProjectFactoryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private ProjectFactory projectFactory;

    @Test
    void createProject_happyDay() throws Exception {
        String body = "{\"name\":\"my-project\",\"description\":\"a test project\"}";

        mockMvc.perform(post("/api/internal/project/factory/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(body))
                .andExpect(status().isOk());

        var captor = ArgumentCaptor.forClass(NewProjectForm.class);
        verify(projectFactory).createProject(captor.capture());

        var newProjectForm = captor.getValue();
        assertEquals("my-project", newProjectForm.getName());
        assertEquals("a test project", newProjectForm.getDescription());
    }

    @Test
    void createProject_missingDescription() throws Exception {
        String body = "{\"name\":\"only-name\"}";

        mockMvc.perform(post("/api/internal/project/factory/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(body))
                .andExpect(status().isOk());

        var captor = ArgumentCaptor.forClass(NewProjectForm.class);
        verify(projectFactory).createProject(captor.capture());

        var newProjectForm = captor.getValue();
        assertEquals("only-name", newProjectForm.getName());
    }

    @Test
    void createProject_invalidJson() throws Exception {
        String body = "{\"name\":"; // malformed JSON

        mockMvc.perform(post("/api/internal/project/factory/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(body))
                .andExpect(status().isBadRequest());

        verifyNoInteractions(projectFactory);
    }

}
