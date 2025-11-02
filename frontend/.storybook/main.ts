import type { StorybookConfig } from "@storybook-vue/nuxt";

const config: StorybookConfig = {
  addons: [
    "@storybook/addon-docs",
    "@storybook/addon-vitest",
    "@storybook/addon-a11y",
    "@storybook/addon-themes",
    "storybook-addon-pseudo-states",
  ],
  framework: {
    name: "@storybook-vue/nuxt",
    options: {
      docgen: {
        plugin: "vue-component-meta",
        tsconfig: "tsconfig.app.json",
      },
    },
  },
  stories: ["../app/**/*.stories.ts"],
};
export default config;
