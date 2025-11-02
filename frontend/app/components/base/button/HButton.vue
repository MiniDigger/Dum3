<script lang="ts" setup>
import type { RouteLocationRaw } from "vue-router";
import { NuxtLink } from "#components";

withDefaults(
    defineProps<{
      disabled?: boolean;
      buttonType?: "primary" | "secondary" | "danger" | "transparent";
      loading?: boolean;
      to?: string | RouteLocationRaw | object;
      href?: string;
      width?: string;
    }>(),
    {
      disabled: false,
      buttonType: "primary",
      loading: false,
      to: undefined,
      href: undefined,
      width: undefined,
    }
);
defineEmits<{
  click: [event: MouseEvent];
}>();
</script>

<template>
  <component
      :is="to ? NuxtLink : href ? 'a' : 'button'"
      :class="[
        `button button__${buttonType}`,
        {
          'button__disabled': disabled || loading
        },
      ]"
      :disabled="disabled || loading"
      :to="to"
      :href="href"
      v-bind="$attrs"
      @click="$emit('click', $event)"
  >
    <Icon
        v-if="loading"
        class="button__icon button__loading"
        name="lucide:loader-circle"
    />
    <slot />
    <Icon
        v-if="to"
        class="button__icon"
        name="lucide:arrow-right"
    />
    <Icon
        v-else-if="href"
        class="button__icon"
        name="lucide:external-link"
    />
  </component>
</template>

<style lang="scss" scoped>
@use "@/style/util/base" as base;

.button {
  all: unset;
  cursor: pointer;
  padding: 0.5rem 0.75rem;
  display: inline-flex;
  border-radius: 0.5rem;
  align-items: center;
  justify-content: center;
  transition: transform 350ms cubic-bezier(0.4, 0, 0.2, 1);
  color: white;
  will-change: transform;

  &:hover:not(.button__disabled) {
    transform: scale(1.01);
  }

  &:active:not(.button__disabled) {
    transform: scale(0.99);
  }

  &__primary {
    background-color: base.$primary-alt;
    border: 1px solid base.$primary;

    &:hover {
      background-color: base.$primary-highlighted;
    }
  }

  &__secondary {
    background-color: base.$secondary-alt;
    border: 1px solid base.$secondary;

    &:hover {
      background-color: base.$secondary-highlighted;
    }
  }

  &__danger {
    background-color: base.$danger-alt;
    border: 1px solid base.$danger;

    &:hover {
      background-color: base.$danger-highlighted;
    }
  }

  &__transparent {
    background-color: transparent;
    border: 1px solid base.$secondary;

    &:hover {
      background-color: base.$secondary-alt;
    }
  }

  &__disabled {
    cursor: not-allowed;
    filter: brightness(0.7);
  }

  &__icon {
    margin-left: 0.3rem;
  }

  &__loading {
    margin-right: 0.3rem;
    animation: spin 1s linear infinite;
  }
}

@keyframes spin {
  from {
    transform: rotate(0deg);
  }
  to {
    transform: rotate(360deg);
  }
}
</style>