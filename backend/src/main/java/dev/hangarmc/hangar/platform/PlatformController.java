package dev.hangarmc.hangar.platform;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api/internal/platform")
class PlatformController {

    private final PlatformService platformService;

    PlatformController(PlatformService platformService) {
        this.platformService = platformService;
    }

    @PostMapping("/refresh")
    public int refreshPlatforms() {
        return this.platformService.populate();
    }
}
