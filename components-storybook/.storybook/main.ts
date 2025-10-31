import type {StorybookConfig} from '@storybook/vue3-vite';

const config: StorybookConfig = {
    addons: [
        "@storybook/addon-docs",
        "@storybook/addon-vitest",
        "@storybook/addon-a11y",
        "@storybook/addon-themes",
        "storybook-addon-pseudo-states",
    ], framework: {
        name: "@storybook/vue3-vite",
        options: {
            docgen: {
                plugin: "vue-component-meta",
                tsconfig: "tsconfig.app.json",
            },
        },
    }, stories: [
        "../src/**/*.stories.ts"
    ]
};
export default config;
