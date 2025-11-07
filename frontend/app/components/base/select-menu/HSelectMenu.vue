<script setup lang="ts">
import { ref } from 'vue';
import HDropdownMenu from "~/components/base/dropdown-menu/HDropdownMenu.vue";

const {
  side = 'bottom',
  align = 'start',
  items = [],
  placeholder = 'Select an option',
  modelValue = null,
} = defineProps<{
  side?: 'top' | 'right' | 'bottom' | 'left';
  align?: 'start' | 'center' | 'end';
  items?: string[];
  placeholder?: string;
  modelValue?: string | null;
}>();

const toggleState = ref(false);

const emit = defineEmits<{
  'update:modelValue': [item: string];
  select: [item: string];
}>();

const handleItemClick = (item: string) => {
  emit('update:modelValue', item);
  emit('select', item);
  toggleState.value = false;
};
</script>

<template>
  <HDropdownMenu v-model:open="toggleState" :side="side" :align="align">
    <template #trigger>
      <slot name="trigger">
        <HButton>{{ modelValue || placeholder }}</HButton>
      </slot>
    </template>

    <template #default>
      <HButton
          v-for="item in items"
          :key="item"
          :onlyHover="item != modelValue"
          :buttonType="item === modelValue ? 'primary' : 'secondary'"
          @click="handleItemClick(item)"
      >
        {{ item }}
      </HButton>
    </template>
  </HDropdownMenu>
</template>
