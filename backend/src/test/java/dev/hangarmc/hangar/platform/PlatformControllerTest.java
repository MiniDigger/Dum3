package dev.hangarmc.hangar.platform;

import dev.hangarmc.hangar.HangarConfigs;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@HangarConfigs
@WebMvcTest(controllers = PlatformController.class)
class PlatformControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private PlatformService platformService;

    @MockitoBean
    private PlatformDao platformDao;

    @Test
    void refreshShouldReturnDaoResult() throws Exception {
        when(platformService.populate()).thenReturn(5);

        mockMvc.perform(post("/api/internal/platform/refresh").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("5"));
    }
}
