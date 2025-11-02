import type { Meta, StoryObj } from '@storybook/vue3';
import HButton from './HButton.vue';

const meta: Meta<typeof HButton> = {
    title: 'Base/HButton',
    component: HButton,
    tags: ['autodocs'],
    argTypes: {
        buttonType: {
            control: 'select',
            options: ['primary', 'secondary', 'danger', 'transparent'],
        },
        disabled: {
            control: 'boolean',
        },
        loading: {
            control: 'boolean',
        },
        to: {
            control: 'text',
        },
        href: {
            control: 'text',
        },
        width: {
            control: 'text',
        },
        onClick: { action: 'clicked' },
    },
};

export default meta;
type Story = StoryObj<typeof HButton>;

export const Primary: Story = {
    args: {
        buttonType: 'primary',
        disabled: false,
        loading: false,
    },
    render: (args) => ({
        components: { HButton },
        setup() {
            return { args };
        },
        template: '<HButton v-bind="args">Primary Button</HButton>',
    }),
};

export const Secondary: Story = {
    args: {
        buttonType: 'secondary',
    },
    render: (args) => ({
        components: { HButton },
        setup() {
            return { args };
        },
        template: '<HButton v-bind="args">Secondary Button</HButton>',
    }),
};

export const Danger: Story = {
    args: {
        buttonType: 'danger',
    },
    render: (args) => ({
        components: { HButton },
        setup() {
            return { args };
        },
        template: '<HButton v-bind="args">Danger Button</HButton>',
    }),
};

export const Transparent: Story = {
    args: {
        buttonType: 'transparent',
    },
    render: (args) => ({
        components: { HButton },
        setup() {
            return { args };
        },
        template: '<HButton v-bind="args">Transparent Button</HButton>',
    }),
};

export const Disabled: Story = {
    args: {
        disabled: true,
    },
    render: (args) => ({
        components: { HButton },
        setup() {
            return { args };
        },
        template: '<HButton v-bind="args">Disabled Button</HButton>',
    }),
};

export const Loading: Story = {
    args: {
        loading: true,
    },
    render: (args) => ({
        components: { HButton },
        setup() {
            return { args };
        },
        template: '<HButton v-bind="args">Loading Button</HButton>',
    }),
};

export const LinkToPage: Story = {
    args: {
        to: '/example',
    },
    render: (args) => ({
        components: { HButton },
        setup() {
            return { args };
        },
        template: '<HButton v-bind="args">Router Link</HButton>',
    }),
};

export const ExternalLink: Story = {
    args: {
        href: 'https://example.com',
    },
    render: (args) => ({
        components: { HButton },
        setup() {
            return { args };
        },
        template: '<HButton v-bind="args">External Link</HButton>',
    }),
};

export const FixedWidth: Story = {
    args: {
        buttonType: 'primary',
        width: '100%',
        disabled: false,
        loading: false,
    },
    render: (args) => ({
        components: { HButton },
        setup() {
            return { args };
        },
        template: '<HButton v-bind="args">Primary Button</HButton>',
    }),
};
