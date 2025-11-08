<script setup lang="ts">
import { ref } from 'vue';
import HDropdownMenu from "~/components/base/dropdown-menu/HDropdownMenu.vue";

const {
  side = 'bottom',
  align = 'start',
  items = [],
  placeholder = 'Select an option',
  width = undefined,
  scrollable = false,
  modelValue = null,
  textAlign = 'left',
  autoClose = true,
} = defineProps<{
  side?: 'top' | 'right' | 'bottom' | 'left';
  align?: 'start' | 'center' | 'end';
  items?: string[];
  placeholder?: string;
  width?: string;
  scrollable?: boolean;
  modelValue?: string | null;
  textAlign?: 'left' | 'center' | 'right';
  autoClose?: boolean;
}>();

const toggleState = ref(false);

const emit = defineEmits<{
  'update:modelValue': [item: string];
  select: [item: string];
}>();

const handleItemClick = (item: string) => {
  emit('update:modelValue', item);
  emit('select', item);
};
</script>

<template>
  <HDropdownMenu :label="modelValue || placeholder" v-model:open="toggleState" :width="width" :autoClose="autoClose" :side="side" :align="align">
    <template #default>
      <div
        class="list"
        :class="{ 'is-scrollable': scrollable }"
      >
        <HButton
          v-for="item in items"
          :key="item"
          :textAlign="textAlign"
          :onlyHover="item !== modelValue"
          :buttonType="item === modelValue ? 'primary' : 'secondary'"
          @click="handleItemClick(item)"
        >
          {{ item }}
        </HButton>
      </div>
    </template>
  </HDropdownMenu>
</template>

<style lang="scss" scoped>
.list {
  display: flex;
  flex-direction: column;
  gap: 0.25rem;
}

.is-scrollable {
  max-height: 240px;
  overflow-y: auto; // Keep vertical scrolling
  padding-block: 2px;
  padding-left: 2px;
  padding-right: 8px;
}
</style>