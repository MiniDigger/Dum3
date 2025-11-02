import type { Meta, StoryObj } from "@storybook/vue3-vite";

import InputText from "./InputText.vue";

const meta: Meta<typeof InputText> = {
  component: InputText,
  title: "Input/InputText",
};

export default meta;
type Story = StoryObj<typeof meta>;

const render = (args: (typeof meta)["args"]) => ({
  components: { InputText },
  setup() {
    return { args };
  },
  template: '<InputText v-bind="args" />',
});

export const Text: Story = {
  args: {
    label: "Label",
    type: "text",
  },
  render,
};

export const EMail: Story = {
  args: {
    label: "Label",
    type: "email",
  },
  render,
};
