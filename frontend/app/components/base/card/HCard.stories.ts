import type { Meta, StoryObj } from '@storybook/vue3';
import HCard from './HCard.vue';

const meta: Meta<typeof HCard> = {
    title: 'Base/HCard',
    component: HCard,
    tags: ['autodocs'],
    argTypes: {},
};

export default meta;
type Story = StoryObj<typeof HCard>;

export const Default: Story = {
    render: () => ({
        components: { HCard },
        template: `
      <HCard>
        <template #header>
          <h2>Card Title</h2>
        </template>
        <template #default>
          <p>This is the main content of the card.</p>
        </template>
      </HCard>
    `,
    }),
};

export const HeaderOnly: Story = {
    render: () => ({
        components: { HCard },
        template: `
      <HCard>
        <template #header>
          <h2>Card with Header Only</h2>
        </template>
      </HCard>
    `,
    }),
};

export const ContentOnly: Story = {
    render: () => ({
        components: { HCard },
        template: `
      <HCard>
        <p>Card with content only, no header.</p>
      </HCard>
    `,
    }),
};

export const LongContent: Story = {
    render: () => ({
        components: { HCard },
        template: `
      <HCard>
        <template #header>
          <h2>Long Content Example</h2>
        </template>
        <template #default>
          <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
          <p>Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
        </template>
      </HCard>
    `,
    }),
};
