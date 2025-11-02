import type { Meta, StoryObj } from "@storybook/vue3-vite";

import Homepage from "./Homepage.vue";

const meta: Meta<typeof Homepage> = {
    component: Homepage,
    title: "Homepage",
};

export default meta;
type Story = StoryObj<typeof meta>;

const render = (args: (typeof meta)["args"]) => ({
    components: { Homepage },
    setup() {
        return { args };
    },
    template: '<Homepage v-bind="args" />',
});

export const Default: Story = {
    args: {
        software: "Paper",
    },
    render,
};

