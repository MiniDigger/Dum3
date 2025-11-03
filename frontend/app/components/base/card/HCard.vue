<script setup lang="ts">

</script>

<template>
  <div class="card">
    <slot name="header" />
    <div v-if="$slots.default && $slots.header" class="card__divisor" />
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
  padding: 0.75rem;

  &__divisor {
    width: 100%;
    height: 0.25rem;
  }
}
</style>