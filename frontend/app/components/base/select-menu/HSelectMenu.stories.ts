import type { Meta, StoryObj } from '@storybook/vue3';
import { ref } from 'vue';
import HSelectMenu from './HSelectMenu.vue';

const meta: Meta<typeof HSelectMenu> = {
    title: 'Components/Base/HSelectMenu',
    component: HSelectMenu,
    tags: ['autodocs'],
    argTypes: {
        side: {
            control: 'select',
            options: ['top', 'right', 'bottom', 'left'],
            description: 'Position of the dropdown relative to the trigger',
        },
        align: {
            control: 'select',
            options: ['start', 'center', 'end'],
            description: 'Alignment of the dropdown',
        },
        items: {
            control: 'object',
            description: 'Array of selectable items',
        },
        placeholder: {
            control: 'text',
            description: 'Placeholder text when no item is selected',
        },
        modelValue: {
            control: 'text',
            description: 'Currently selected value',
        },
    },
};

export default meta;
type Story = StoryObj<typeof HSelectMenu>;

export const Default: Story = {
    args: {
        items: ['Option 1', 'Option 2', 'Option 3'],
        placeholder: 'Select an option',
    },
    render: (args) => ({
        components: { HSelectMenu },
        setup() {
            const selectedValue = ref<string | null>(null);
            return { args, selectedValue };
        },
        template: `<HSelectMenu v-bind="args" v-model="selectedValue" />`,
    }),
};

export const WithSelectedValue: Story = {
    args: {
        items: ['Profile', 'Settings', 'Logout'],
        modelValue: 'Profile',
    },
    render: (args) => ({
        components: { HSelectMenu },
        setup() {
            const selectedValue = ref<string | null>(args.modelValue ?? null);
            return { args, selectedValue };
        },
        template: `<HSelectMenu v-bind="args" v-model="selectedValue" />`,
    }),
};

export const CustomPlaceholder: Story = {
    args: {
        items: ['Red', 'Green', 'Blue'],
        placeholder: 'Choose a color',
    },
    render: (args) => ({
        components: { HSelectMenu },
        setup() {
            const selectedValue = ref<string | null>(null);
            return { args, selectedValue };
        },
        template: `<HSelectMenu v-bind="args" v-model="selectedValue" />`,
    }),
};

export const PositionTop: Story = {
    args: {
        items: ['Item 1', 'Item 2', 'Item 3'],
        side: 'top',
    },
    render: (args) => ({
        components: { HSelectMenu },
        setup() {
            const selectedValue = ref<string | null>(null);
            return { args, selectedValue };
        },
        template: `<HSelectMenu v-bind="args" v-model="selectedValue" />`,
    }),
};

export const PositionRight: Story = {
    args: {
        items: ['Item 1', 'Item 2', 'Item 3'],
        side: 'right',
    },
    render: (args) => ({
        components: { HSelectMenu },
        setup() {
            const selectedValue = ref<string | null>(null);
            return { args, selectedValue };
        },
        template: `<HSelectMenu v-bind="args" v-model="selectedValue" />`,
    }),
};

export const AlignCenter: Story = {
    args: {
        items: ['Item 1', 'Item 2', 'Item 3'],
        align: 'center',
    },
    render: (args) => ({
        components: { HSelectMenu },
        setup() {
            const selectedValue = ref<string | null>(null);
            return { args, selectedValue };
        },
        template: `<HSelectMenu v-bind="args" v-model="selectedValue" />`,
    }),
};

export const Interactive: Story = {
    args: {
        items: ['Apple', 'Banana', 'Cherry', 'Date', 'Elderberry'],
    },
    render: (args) => ({
        components: { HSelectMenu },
        setup() {
            const selectedValue = ref<string | null>(null);
            return { args, selectedValue };
        },
        template: `
          <div>
            <HSelectMenu v-bind="args" v-model="selectedValue" />
            <p style="margin-top: 1rem">Selected value: <strong>{{ selectedValue || 'None' }}</strong></p>
          </div>
        `,
    }),
};

export const ScrollableList: Story = {
    args: {
        scrollable: true,
        items: Array.from({ length: 20 }, (_, i) => `Option ${i + 1}`),
        placeholder: "Select from many options",
        width: '300px'
    },
    render: (args) => ({
        components: { HSelectMenu },
        setup() {
            const selectedValue = ref<string | null>(null);
            return { args, selectedValue };
        },
        template: `<HSelectMenu align="center" v-bind="args" v-model="selectedValue" />`,
    }),
};

export const CustomWidth: Story = {
    args: {
        items: ['Option 1', 'Option 2', 'Option 3'],
        placeholder: 'Wide select menu',
        width: '300px'
    },
    render: (args) => ({
        components: { HSelectMenu },
        setup() {
            const selectedValue = ref<string | null>(null);
            return { args, selectedValue };
        },
        template: `<HSelectMenu v-bind="args" v-model="selectedValue" />`
    }),
};
