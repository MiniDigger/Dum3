import type { Meta, StoryObj } from '@storybook/vue3';
import HButton from './HButton.vue';

const meta: Meta<typeof HButton> = {
    title: 'Base/HButton',
    component: HButton,
    tags: ['autodocs'],
    argTypes: {
        buttonType: {
            control: 'select',
            options: ['primary', 'secondary', 'danger', 'transparent', 'borderless'],
        },
        disabled: { control: 'boolean' },
        loading: { control: 'boolean' },
        rounded: { control: 'boolean' },
        icon: { control: 'text' },
        width: { control: 'text' },
        to: { control: 'text' },
        href: { control: 'text' },
    },
};

export default meta;
type Story = StoryObj<typeof HButton>;

export const Primary: Story = {
    args: {
        buttonType: 'primary',
        default: 'Primary Button',
    },
    render: (args) => ({
        components: { HButton },
        setup() {
            return { args };
        },
        template: '<HButton v-bind="args">{{ args.default }}</HButton>',
    }),
};

export const Secondary: Story = {
    args: {
        buttonType: 'secondary',
        default: 'Secondary Button',
    },
    render: (args) => ({
        components: { HButton },
        setup() {
            return { args };
        },
        template: '<HButton v-bind="args">{{ args.default }}</HButton>',
    }),
};

export const Danger: Story = {
    args: {
        buttonType: 'danger',
        default: 'Danger Button',
    },
    render: (args) => ({
        components: { HButton },
        setup() {
            return { args };
        },
        template: '<HButton v-bind="args">{{ args.default }}</HButton>',
    }),
};

export const Transparent: Story = {
    args: {
        buttonType: 'transparent',
        default: 'Transparent Button',
    },
    render: (args) => ({
        components: { HButton },
        setup() {
            return { args };
        },
        template: '<HButton v-bind="args">{{ args.default }}</HButton>',
    }),
};

export const Borderless: Story = {
    args: {
        buttonType: 'transparent',
        borderless: true,
        default: 'Borderless Button',
    },
    render: (args) => ({
        components: { HButton },
        setup() {
            return { args };
        },
        template: '<HButton v-bind="args">{{ args.default }}</HButton>',
    }),
};

export const WithIcon: Story = {
    args: {
        buttonType: 'primary',
        icon: 'lucide:star',
        default: 'Button with Icon',
    },
    render: (args) => ({
        components: { HButton },
        setup() {
            return { args };
        },
        template: '<HButton v-bind="args">{{ args.default }}</HButton>',
    }),
};

export const Rounded: Story = {
    args: {
        buttonType: 'primary',
        rounded: true,
        default: 'Rounded Button',
    },
    render: (args) => ({
        components: { HButton },
        setup() {
            return { args };
        },
        template: '<HButton v-bind="args">{{ args.default }}</HButton>',
    }),
};

export const RoundedWithIcon: Story = {
    args: {
        buttonType: 'secondary',
        rounded: true,
        icon: 'lucide:heart',
        default: 'Rounded with Icon',
    },
    render: (args) => ({
        components: { HButton },
        setup() {
            return { args };
        },
        template: '<HButton v-bind="args">{{ args.default }}</HButton>',
    }),
};

export const WithRouterLink: Story = {
    args: {
        buttonType: 'primary',
        to: '/example',
        default: 'Router Link Button',
    },
    render: (args) => ({
        components: { HButton },
        setup() {
            return { args };
        },
        template: '<HButton v-bind="args">{{ args.default }}</HButton>',
    }),
};

export const WithExternalLink: Story = {
    args: {
        buttonType: 'secondary',
        href: 'https://example.com',
        default: 'External Link Button',
    },
    render: (args) => ({
        components: { HButton },
        setup() {
            return { args };
        },
        template: '<HButton v-bind="args">{{ args.default }}</HButton>',
    }),
};

export const Loading: Story = {
    args: {
        buttonType: 'primary',
        loading: true,
        default: 'Loading',
    },
    render: (args) => ({
        components: { HButton },
        setup() {
            return { args };
        },
        template: '<HButton v-bind="args">{{ args.default }}</HButton>',
    }),
};

export const Disabled: Story = {
    args: {
        buttonType: 'primary',
        disabled: true,
        default: 'Disabled',
    },
    render: (args) => ({
        components: { HButton },
        setup() {
            return { args };
        },
        template: '<HButton v-bind="args">{{ args.default }}</HButton>',
    }),
};

export const CustomWidth: Story = {
    args: {
        buttonType: 'primary',
        width: '200px',
        default: 'Custom Width Button',
    },
    render: (args) => ({
        components: { HButton },
        setup() {
            return { args };
        },
        template: '<HButton v-bind="args">{{ args.default }}</HButton>',
    }),
};

export const IconOnlyRounded: Story = {
    args: {
        buttonType: 'primary',
        rounded: true,
        icon: 'lucide:settings',
    },
    render: (args) => ({
        components: { HButton },
        setup() {
            return { args };
        },
        template: '<HButton v-bind="args" />',
    }),
};

export const IconOnlySecondary: Story = {
    args: {
        buttonType: 'secondary',
        icon: 'lucide:more-vertical',
    },
    render: (args) => ({
        components: { HButton },
        setup() {
            return { args };
        },
        template: '<HButton v-bind="args" />',
    }),
};

export const IconOnlyBorderlessRounded: Story = {
    args: {
        buttonType: 'transparent',
        rounded: true,
        borderless: true,
        icon: 'lucide:x',
    },
    render: (args) => ({
        components: { HButton },
        setup() {
            return { args };
        },
        template: '<HButton v-bind="args" />',
    }),
};
