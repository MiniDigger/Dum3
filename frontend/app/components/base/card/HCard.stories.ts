import type { Meta, StoryObj } from '@storybook/vue3';
import HCard from './HCard.vue';

const meta: Meta<typeof HCard> = {
    title: 'Components/Base/HCard',
    component: HCard,
    tags: ['autodocs'],
    argTypes: {
        width: { control: 'text' },
    },
};

export default meta;
type Story = StoryObj<typeof HCard>;

export const Default: Story = {
    args: {},
    render: (args) => ({
        components: { HCard },
        setup() {
            return { args };
        },
        template: `
      <HCard v-bind="args">
        <p>This is the default card content.</p>
      </HCard>
    `,
    }),
};

export const WithHeader: Story = {
    args: {},
    render: (args) => ({
        components: { HCard },
        setup() {
            return { args };
        },
        template: `
      <HCard v-bind="args">
        <template #header>
          <h3>Card Title</h3>
        </template>
        <p>This card has a header and content.</p>
      </HCard>
    `,
    }),
};

export const HeaderOnly: Story = {
    args: {},
    render: (args) => ({
        components: { HCard },
        setup() {
            return { args };
        },
        template: `
      <HCard v-bind="args">
        <template #header>
          <h3>Header Only</h3>
        </template>
      </HCard>
    `,
    }),
};

export const CustomWidth: Story = {
    args: {
        width: '400px',
    },
    render: (args) => ({
        components: { HCard },
        setup() {
            return { args };
        },
        template: `
      <HCard v-bind="args">
        <template #header>
          <h3>Custom Width Card</h3>
        </template>
        <p>This card has a custom width of 400px.</p>
      </HCard>
    `,
    }),
};

export const WithMultipleElements: Story = {
    args: {},
    render: (args) => ({
        components: { HCard },
        setup() {
            return { args };
        },
        template: `
      <HCard v-bind="args">
        <template #header>
          <h3>Card with Multiple Elements</h3>
        </template>
        <p>First paragraph of content.</p>
        <p>Second paragraph of content.</p>
        <ul>
          <li>List item 1</li>
          <li>List item 2</li>
          <li>List item 3</li>
        </ul>
      </HCard>
    `,
    }),
};
