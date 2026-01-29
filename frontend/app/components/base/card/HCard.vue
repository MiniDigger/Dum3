<script setup lang="ts">

const {
  width = '100%',
} = defineProps<{
  width?: string;
}>()
</script>

<template>
  <div class="card" :style="{ width: width }">
    <slot name="header" />
    <slot />
  </div>
</template>

<style scoped lang="scss">
@use "@/style/util/base" as base;

.card {
  background-color: base.$background-surface;
  border: 1px solid base.$secondary;
  border-radius: 0.75rem;
  color: white;
  padding: 0.5rem;

  &__divisor {
    width: 100%;
    height: 0.25rem;
  }
}
</style>