package dev.hangarmc.hangar.project.factory;

import dev.hangarmc.hangar.project.settings.ProjectSettingsForm;

public class NewProjectForm extends ProjectSettingsForm {

    private final String name;

    public NewProjectForm(String name, String description) {
        super(description);
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
