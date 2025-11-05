import type { Meta, StoryObj } from '@storybook/vue3';
import HCollapsibleCard from './HCollapsibleCard.vue';

const meta: Meta<typeof HCollapsibleCard> = {
    title: 'Base/HCollapsibleCard',
    component: HCollapsibleCard,
    tags: ['autodocs'],
    argTypes: {
        open: {
            control: 'boolean',
            description: 'Whether the card is initially open',
            defaultValue: false,
        },
        width: {
            control: 'text',
            description: 'Width of the card',
            defaultValue: '100%',
        },
    },
};

export default meta;
type Story = StoryObj<typeof HCollapsibleCard>;

export const Default: Story = {
    args: {
        open: false,
        width: '100%',
    },
    render: (args) => ({
        components: { HCollapsibleCard },
        setup() {
            return { args };
        },
        template: `
          <HCollapsibleCard v-bind="args">
            <template #header>
              <h3>Collapsible Card</h3>
            </template>
            <p>This content can be collapsed and expanded.</p>
          </HCollapsibleCard>
        `,
    }),
};

export const InitiallyOpen: Story = {
    args: {
        open: true,
        width: '100%',
    },
    render: (args) => ({
        components: { HCollapsibleCard },
        setup() {
            return { args };
        },
        template: `
          <HCollapsibleCard v-bind="args">
            <template #header>
              <h3>Initially Open</h3>
            </template>
            <p>This card starts in the open state.</p>
          </HCollapsibleCard>
        `,
    }),
};

export const WithContent: Story = {
    args: {
        open: false,
        width: '100%',
    },
    render: (args) => ({
        components: { HCollapsibleCard },
        setup() {
            return { args };
        },
        template: `
          <HCollapsibleCard v-bind="args">
            <template #header>
              <h3>Details</h3>
            </template>
            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
            <p>Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
          </HCollapsibleCard>
        `,
    }),
};

export const CustomWidth: Story = {
    args: {
        open: false,
        width: '400px',
    },
    render: (args) => ({
        components: { HCollapsibleCard },
        setup() {
            return { args };
        },
        template: `
          <HCollapsibleCard v-bind="args">
            <template #header>
              <h3>Custom Width Card</h3>
            </template>
            <p>This card has a custom width of 400px.</p>
          </HCollapsibleCard>
        `,
    }),
};
