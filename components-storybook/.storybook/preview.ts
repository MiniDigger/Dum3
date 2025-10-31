import type {Preview} from '@storybook/vue3-vite'
import {withThemeByDataAttribute} from "@storybook/addon-themes";

import "@/style/main.scss"

const preview: Preview = {
    decorators: [
        withThemeByDataAttribute({
            attributeName: "theme", defaultTheme: "light", themes: {
                dark: "dark", light: "light",
            }
        }),
    ], parameters: {
        backgrounds: {
            disable: true
        }, controls: {
            matchers: {
                color: /(background|color)$/i,
                date: /Date$/i,
            },
        }
    }, tags: ['autodocs'],
};

export default preview;
