<script lang="ts" setup>
import type { RouteLocationRaw } from "vue-router";
import { NuxtLink } from "#components";

const {
  disabled = false,
  buttonType = "primary",
  loading = false,
  to = undefined,
  href = undefined,
  rounded = false,
  icon = undefined,
  width = undefined,
  borderless = false,
} = defineProps<{
  disabled?: boolean;
  buttonType?: "primary" | "secondary" | "danger" | "transparent";
  loading?: boolean;
  to?: string | RouteLocationRaw | object;
  href?: string;
  rounded?: boolean;
  icon?: string;
  width?: string;
  borderless?: boolean;
}>()

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
          'button__disabled': disabled || loading,
          'button__rounded': rounded,
          'button__icon-only': icon && !$slots.default,
          'button__borderless': borderless,
        },
      ]"
      :style="{
        width: width ? width : undefined
      }"
      :disabled="disabled || loading"
      :to="to"
      :href="href"
      v-bind="$attrs"
      @click="$emit('click', $event)"
  >
    <Icon
        v-if="loading"
        class="button__loading icon__left"
        name="lucide:loader-circle"
    />
    <Icon
        v-if="icon"
        :class="{
          'icon__left': $slots.default,
        }"
        :name="icon"
    />
    <slot />
    <Icon
        v-if="to"
        class="icon__right"
        name="lucide:arrow-right"
    />
    <Icon
        v-else-if="href"
        class="icon__right"
        name="lucide:external-link"
    />
  </component>
</template>

<style lang="scss" scoped>
@use "@/style/util/base" as base;

.icon {
  &__right {
    margin-left: 0.3rem;
  }

  &__left {
    margin-right: 0.3rem;
  }
}
.button {
  user-select: none;
  all: unset;
  cursor: pointer;
  padding: 0.3rem 0.5rem;
  display: inline-flex;
  border-radius: 0.5rem;
  align-items: center;
  justify-content: center;
  transition: transform 250ms cubic-bezier(0.4, 0, 0.2, 1),
              background-color 250ms cubic-bezier(0.4, 0, 0.2, 1),
              border-color 250ms cubic-bezier(0.4, 0, 0.2, 1);
  color: white;
  will-change: transform;

  &:hover:not(.button__disabled) {
    transform: scale(1.01);
  }

  &:active:not(.button__disabled) {
    transform: scale(0.99);
  }

  &__rounded {
    border-radius: 9999px;
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

  &__borderless {
    background-color: transparent;
    border: 1px solid transparent;

    &.button__danger:hover {
      background-color: base.$danger-highlighted;
      border: 1px solid base.$danger;
    }

    &.button__primary:hover {
      background-color: base.$primary-highlighted;
      border: 1px solid base.$primary;
    }

    &.button__secondary:hover,
    &.button__transparent:hover {
      background-color: base.$secondary-highlighted;
      border: 1px solid base.$secondary;
    }
  }

  &__disabled {
    cursor: not-allowed;
    filter: brightness(0.7);
  }

  &__loading {
    margin-top: 2px;
    animation: spin 1s linear infinite;
  }

  &__icon-only {
    padding: 0.3rem;
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