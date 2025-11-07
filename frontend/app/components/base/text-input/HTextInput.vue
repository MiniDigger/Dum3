<script setup lang="ts">
import { ref } from 'vue';

const {
  modelValue = "",
  placeholder = "",
  icon = undefined
} = defineProps<{
  modelValue?: string;
  placeholder?: string;
  icon?: string;
}>();

const emit = defineEmits<{
  'update:modelValue': [value: string];
}>();

const input = ref(modelValue);

const handleInput = () => {
  emit('update:modelValue', input.value);
};

const clearInput = () => {
  input.value = '';
  emit('update:modelValue', '');
};
</script>

<template>
  <div class="field field__wrapper">
    <Icon v-if="icon" :name="icon" class="icon" />
    <input
        v-model="input"
        name="query"
        class="field field__input"
        type="text"
        :placeholder="placeholder"
        @input="handleInput"
    />
    <HButton
        v-if="input.length > 0"
        rounded
        onlyHover
        buttonType="secondary"
        icon="lucide:x"
        class="icon icon__close"
        @click="clearInput"
    />
  </div>

</template>

<style scoped lang="scss">
@use "@/style/util/base" as base;

.field {
  transition: all 0.35s;
  border-radius: 0.35rem;

  &__wrapper {
    display: flex;
    align-items: center;
    gap: 0.5rem;
    padding: 0 0.5rem;
    width: 100%;
    background-color: base.$secondary-alt;
    border: 1px solid base.$background-main;
    height: 2.75rem;

    &:hover,
    &:has(.field__input:focus) {
      border: 1px solid base.$secondary;
      transform: scale(1.0025);
    }
  }

  &__input {
    outline: none;
    padding: 0;
    flex: 1;
    min-width: 7.5rem;
    border: 1px solid transparent;
    overflow: hidden;
    text-overflow: ellipsis;
    white-space: nowrap;
    background-color: transparent;
    color: white;
  }
}

.icon {
  color: base.$secondary;
  flex-shrink: 0;

  &__close:hover {
    color: white;
  }
}
</style>
