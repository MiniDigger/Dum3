package dev.hangarmc.hangar.project.factory;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProjectFactoryController.class)
class ProjectFactoryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private ProjectFactory projectFactory;

    @Test
    void createProject_postsFormAndCallsFactory() throws Exception {
        // Send as form parameters because the controller expects a bound object (no @RequestBody)
        mockMvc.perform(post("/api/internal/project/factory/create")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("name", "my-project")
                        .param("description", "a test project"))
                .andExpect(status().isOk());

        var captor = ArgumentCaptor.forClass(ProjectFactoryController.ProjectCreateRequest.class);
        verify(projectFactory).createProject(captor.capture());

        ProjectFactoryController.ProjectCreateRequest req = captor.getValue();
        assertEquals("my-project", req.name());
        assertEquals("a test project", req.description());
    }

}
