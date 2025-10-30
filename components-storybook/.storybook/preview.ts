import type {Preview} from '@storybook/vue3-vite'
import {withThemeByDataAttribute} from "@storybook/addon-themes";

import "@/style/main.scss"

const preview: Preview = {
    parameters: {
        controls: {
            matchers: {
                color: /(background|color)$/i,
                date: /Date$/i,
            },
        },
        backgrounds: {
            disable: true
        }
    },
    decorators: [
        withThemeByDataAttribute({
            themes: {
                light: "light",
                dark: "dark",
            },
            defaultTheme: "light",
            attributeName: "theme"
        }),
    ],
    tags: ['autodocs'],
};

export default preview;
