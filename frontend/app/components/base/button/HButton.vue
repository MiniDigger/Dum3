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
  iconSide = 'left',
  width = undefined,
  distancedIcon = false,
  onlyHover = false,
  textAlign = 'center',
} = defineProps<{
  disabled?: boolean;
  buttonType?: "primary" | "secondary" | "danger" | "transparent";
  loading?: boolean;
  to?: string | RouteLocationRaw | object;
  href?: string;
  rounded?: boolean;
  icon?: string;
  distancedIcon?: boolean;
  iconSide?: 'left' | 'right';
  width?: string;
  onlyHover?: boolean;
  textAlign?: 'left' | 'center' | 'right';
}>()

defineEmits<{
  click: [event: MouseEvent];
}>();

defineOptions({
  inheritAttrs: false
});
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
          'button__borderless': onlyHover,
          'icon__distanced': distancedIcon,
        },
        $attrs.class
      ]"
      :style="{
        width: width ? width : undefined,
        justifyContent: textAlign,
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
        v-if="(icon || to || href) && iconSide === 'left'"
        :class="{
          'icon__left': $slots.default,
        }"
        :name="to ? 'lucide:arrow-right' : href ? 'lucide:external-link' : icon ? icon : ''"
    />
    <slot />
    <Icon
      v-if="(icon || to || href) && iconSide === 'right'"
      :class="{
        'icon__right': $slots.default,
      }"
      :name="to ? 'lucide:arrow-right' : href ? 'lucide:external-link' : icon ? icon : ''"
    />
  </component>
</template>

<style lang="scss" scoped>
@use "@/style/util/base" as base;

.icon {
  &__distanced {
    width: 100%;
    justify-content: space-between !important;
  }
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
  border-radius: 0.35rem;
  transition: all 0.25s;
  align-items: center;
  justify-items: center;
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
    line-height: 0;
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