import type { Meta, StoryObj } from '@storybook/vue3';
import HDropdownMenu from './HDropdownMenu.vue';
import HButton from '../button/HButton.vue';

const meta = {
    title: 'Components/Base/HDropdownMenu',
    component: HDropdownMenu,
    tags: ['autodocs'],
    parameters: {
        layout: 'centered',
    },
} satisfies Meta<typeof HDropdownMenu>;

export default meta;
type Story = StoryObj<typeof meta>;

export const Default: Story = {
    render: () => ({
        components: { HDropdownMenu, HButton },
        template: `
          <HDropdownMenu>
            <template #trigger>
              <HButton buttonType="secondary">Menu</HButton>
            </template>
            <template #default>
              <HButton onlyHover textAlign="left" buttonType="secondary">Option 1</HButton>
              <HButton onlyHover textAlign="left" buttonType="secondary">Option 2</HButton>
              <HButton onlyHover textAlign="left" buttonType="secondary">Option 3</HButton>
            </template>
          </HDropdownMenu>
        `,
    }),
};

export const SideTop: Story = {
    render: () => ({
        components: { HDropdownMenu, HButton },
        template: `
          <HDropdownMenu side="top" width="10rem">
            <template #trigger>
              <HButton buttonType="secondary">Open Top</HButton>
            </template>
            <template #default>
                <HButton onlyHover textAlign="left" buttonType="secondary">Option 1</HButton>
                <HButton onlyHover textAlign="left" buttonType="secondary">Option 2</HButton>
            </template>
          </HDropdownMenu>
        `,
    }),
};

export const SideBottom: Story = {
    render: () => ({
        components: { HDropdownMenu, HButton },
        template: `
          <HDropdownMenu side="bottom" width="10rem">
            <template #trigger>
              <HButton buttonType="secondary">Open Bottom</HButton>
            </template>
            <template #default>
                <HButton onlyHover textAlign="left" buttonType="secondary">Option 1</HButton>
                <HButton onlyHover textAlign="left" buttonType="secondary">Option 2</HButton>
            </template>
          </HDropdownMenu>
        `,
    }),
};

export const SideLeft: Story = {
    render: () => ({
        components: { HDropdownMenu, HButton },
        template: `
          <HDropdownMenu side="left" width="10rem">
            <template #trigger>
              <HButton buttonType="secondary">Open Left</HButton>
            </template>
            <template #default>
                <HButton onlyHover textAlign="left" buttonType="secondary">Option 1</HButton>
                <HButton onlyHover textAlign="left" buttonType="secondary">Option 2</HButton>
            </template>
          </HDropdownMenu>
        `,
    }),
};

export const SideRight: Story = {
    render: () => ({
        components: { HDropdownMenu, HButton },
        template: `
          <HDropdownMenu side="right" width="10rem">
            <template #trigger>
              <HButton buttonType="secondary">Open Right</HButton>
            </template>
            <template #default>
                <HButton onlyHover textAlign="left" buttonType="secondary">Option 1</HButton>
                <HButton onlyHover textAlign="left" buttonType="secondary">Option 2</HButton>
            </template>
          </HDropdownMenu>
        `,
    }),
};

export const AlignStart: Story = {
    render: () => ({
        components: { HDropdownMenu, HButton },
        template: `
          <HDropdownMenu align="start" width="10rem">
            <template #trigger>
              <HButton buttonType="secondary">Align Start</HButton>
            </template>
            <template #default>
                <HButton onlyHover textAlign="left" buttonType="secondary">Option 1</HButton>
                <HButton onlyHover textAlign="left" buttonType="secondary">Option 2</HButton>
            </template>
          </HDropdownMenu>
        `,
    }),
};

export const AlignCenter: Story = {
    render: () => ({
        components: { HDropdownMenu, HButton },
        template: `
          <HDropdownMenu align="center" width="10rem">
            <template #trigger>
              <HButton buttonType="secondary">Align Center</HButton>
            </template>
            <template #default>
                <HButton onlyHover textAlign="left" buttonType="secondary">Option 1</HButton>
                <HButton onlyHover textAlign="left" buttonType="secondary">Option 2</HButton>
            </template>
          </HDropdownMenu>
        `,
    }),
};

export const AlignEnd: Story = {
    render: () => ({
        components: { HDropdownMenu, HButton },
        template: `
          <HDropdownMenu align="end" width="10rem">
            <template #trigger>
              <HButton buttonType="secondary">Align End</HButton>
            </template>
            <template #default>
                <HButton onlyHover textAlign="left" buttonType="secondary">Option 1</HButton>
                <HButton onlyHover textAlign="left" buttonType="secondary">Option 2</HButton>
            </template>
          </HDropdownMenu>
        `,
    }),
};
