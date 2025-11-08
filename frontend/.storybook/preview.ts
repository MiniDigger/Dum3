import type { Preview } from "@storybook/vue3-vite";
import { withThemeByDataAttribute } from "@storybook/addon-themes";

import "@/style/main.scss";

const preview: Preview = {
  decorators: [
    withThemeByDataAttribute({
      attributeName: "theme",
      defaultTheme: "light",
      themes: {
        dark: "dark",
        light: "light",
      },
    }),
      (story) => ({
          components: { story },
          setup() {
              return {};
          },
          template: `
    <div style="
      display: flex; 
      align-items: center; 
      justify-content: center;
      background-color: var(--color-background-main);
      margin: 0;
      padding: 5rem;
      height: 100vh;
      width: 100%;
    ">
      <story />
    </div>
  `,
      }),
  ],
  parameters: {
    backgrounds: {
      disable: true,
    },
    controls: {
      matchers: {
        color: /(background|color)$/i,
        date: /Date$/i,
      },
    },
  },
  tags: ["autodocs"],
};

export default preview;
