<script lang="ts" setup>

defineProps<{
  software?: string;
}>()
</script>

<template>
  <div>
    Home
    <template v-if="software">{{ software }}</template>
  </div>
</template>
