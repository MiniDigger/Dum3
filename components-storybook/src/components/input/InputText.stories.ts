import type { Meta, StoryObj } from '@storybook/vue3-vite';

import InputText from './InputText.vue';

const meta: Meta<typeof InputText> = {
    title: "Input/InputText",
    component: InputText,
};

export default meta;
type Story = StoryObj<typeof meta>;

const render = (args: (typeof meta)["args"]) => ({
    components: { InputText },
    setup() {
        return { args };
    },
    template: '<InputText v-bind="args" />',
}) ;

export const Text: Story = {
    render,
    args: {
        type: "text",
        label: "Label"
    }
};

export const EMail: Story = {
    render,
    args: {
        type: "email",
        label: "Label"
    }
};

