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
    args: {
        width: '10rem',
    },
    render: (args) => ({
        components: { HDropdownMenu, HButton },
        setup() {
            return { args };
        },
        template: `
          <HDropdownMenu v-bind="args">
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
    args: {
        label: 'Open Top',
        side: 'top',
        width: '10rem',
    },
    render: (args) => ({
        components: { HDropdownMenu, HButton },
        setup() {
            return { args };
        },
        template: `
          <HDropdownMenu v-bind="args">
            <template #default>
              <HButton onlyHover textAlign="left" buttonType="secondary">Option 1</HButton>
              <HButton onlyHover textAlign="left" buttonType="secondary">Option 2</HButton>
            </template>
          </HDropdownMenu>
        `,
    }),
};

export const SideBottom: Story = {
    args: {
        label: 'Open Bottom',
        side: 'bottom',
        width: '10rem',
    },
    render: (args) => ({
        components: { HDropdownMenu, HButton },
        setup() {
            return { args };
        },
        template: `
          <HDropdownMenu v-bind="args">
            <template #default>
              <HButton onlyHover textAlign="left" buttonType="secondary">Option 1</HButton>
              <HButton onlyHover textAlign="left" buttonType="secondary">Option 2</HButton>
            </template>
          </HDropdownMenu>
        `,
    }),
};

export const SideLeft: Story = {
    args: {
        label: 'Open Left',
        side: 'left',
        width: '10rem',
    },
    render: (args) => ({
        components: { HDropdownMenu, HButton },
        setup() {
            return { args };
        },
        template: `
          <HDropdownMenu v-bind="args">
            <template #default>
              <HButton onlyHover textAlign="left" buttonType="secondary">Option 1</HButton>
              <HButton onlyHover textAlign="left" buttonType="secondary">Option 2</HButton>
            </template>
          </HDropdownMenu>
        `,
    }),
};

export const SideRight: Story = {
    args: {
        label: 'Open Right',
        side: 'right',
        width: '10rem',
    },
    render: (args) => ({
        components: { HDropdownMenu, HButton },
        setup() {
            return { args };
        },
        template: `
          <HDropdownMenu v-bind="args">
            <template #default>
              <HButton onlyHover textAlign="left" buttonType="secondary">Option 1</HButton>
              <HButton onlyHover textAlign="left" buttonType="secondary">Option 2</HButton>
            </template>
          </HDropdownMenu>
        `,
    }),
};

export const AlignStart: Story = {
    args: {
        label: 'Align Start',
        align: 'start',
        width: '10rem',
    },
    render: (args) => ({
        components: { HDropdownMenu, HButton },
        setup() {
            return { args };
        },
        template: `
          <HDropdownMenu v-bind="args">
            <template #default>
              <HButton onlyHover textAlign="left" buttonType="secondary">Option 1</HButton>
              <HButton onlyHover textAlign="left" buttonType="secondary">Option 2</HButton>
            </template>
          </HDropdownMenu>
        `,
    }),
};

export const AlignCenter: Story = {
    args: {
        label: 'Align Center',
        align: 'center',
        width: '10rem',
    },
    render: (args) => ({
        components: { HDropdownMenu, HButton },
        setup() {
            return { args };
        },
        template: `
          <HDropdownMenu v-bind="args">
            <template #default>
              <HButton onlyHover textAlign="left" buttonType="secondary">Option 1</HButton>
              <HButton onlyHover textAlign="left" buttonType="secondary">Option 2</HButton>
            </template>
          </HDropdownMenu>
        `,
    }),
};

export const AlignEnd: Story = {
    args: {
        align: 'end',
        width: '10rem',
        label: 'Align End'
    },
    render: (args) => ({
        components: { HDropdownMenu, HButton },
        setup() {
            return { args };
        },
        template: `
          <HDropdownMenu v-bind="args">
            <template #default>
              <HButton onlyHover textAlign="left" buttonType="secondary">Option 1</HButton>
              <HButton onlyHover textAlign="left" buttonType="secondary">Option 2</HButton>
            </template>
          </HDropdownMenu>
        `,
    }),
};
