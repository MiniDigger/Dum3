import type { Meta, StoryObj } from '@storybook/vue3';
import HTextInput from './HTextInput.vue';

const meta: Meta<typeof HTextInput> = {
    title: 'Components/Base/HTextInput',
    component: HTextInput,
    tags: ['autodocs'],
    argTypes: {
        modelValue: {
            control: 'text',
            description: 'The input value (v-model)'
        },
        placeholder: {
            control: 'text',
            description: 'Placeholder text'
        },
        icon: {
            control: 'text',
            description: 'Icon name (e.g., "lucide:search")'
        }
    },
    args: {
        modelValue: '',
        placeholder: 'Enter text...',
        icon: undefined
    }
};

export default meta;
type Story = StoryObj<typeof HTextInput>;

export const Default: Story = {
    args: {
        placeholder: 'Search...'
    }
};

export const WithIcon: Story = {
    args: {
        placeholder: 'Search...',
        icon: 'lucide:search'
    }
};

export const WithValue: Story = {
    args: {
        modelValue: 'Sample text',
        placeholder: 'Search...',
        icon: 'lucide:search'
    }
};

export const EmailInput: Story = {
    args: {
        placeholder: 'Enter your email',
        icon: 'lucide:mail'
    }
};

export const UserInput: Story = {
    args: {
        placeholder: 'Enter username',
        icon: 'lucide:user'
    }
};

export const NoIcon: Story = {
    args: {
        placeholder: 'Type something...'
    }
};

export const LongPlaceholder: Story = {
    args: {
        placeholder: 'This is a very long placeholder text that might be truncated',
        icon: 'lucide:search'
    }
};
