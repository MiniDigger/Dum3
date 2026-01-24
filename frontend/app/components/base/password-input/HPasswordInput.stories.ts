import type { Meta, StoryObj } from '@storybook/vue3';
import HPasswordInput from './HPasswordInput.vue';

const meta: Meta<typeof HPasswordInput> = {
    title: 'Components/Base/HPasswordInput',
    component: HPasswordInput,
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
            description: 'Icon name (e.g., "lucide:lock")'
        }
    },
    args: {
        modelValue: '',
        placeholder: 'Enter password...',
        icon: undefined
    }
};

export default meta;
type Story = StoryObj<typeof HPasswordInput>;

export const Default: Story = {
    args: {
        placeholder: 'Enter password...'
    }
};

export const WithIcon: Story = {
    args: {
        placeholder: 'Enter password...',
        icon: 'lucide:lock'
    }
};

export const WithValue: Story = {
    args: {
        modelValue: 'secretpassword123',
        placeholder: 'Enter password...',
        icon: 'lucide:lock'
    }
};

export const KeyIcon: Story = {
    args: {
        placeholder: 'Enter your secret key',
        icon: 'lucide:key'
    }
};

export const NoIcon: Story = {
    args: {
        placeholder: 'Type your password...'
    }
};

export const LongPlaceholder: Story = {
    args: {
        placeholder: 'Enter your super secret password here',
        icon: 'lucide:lock'
    }
};

