<script lang="ts" setup>
defineProps<{
  version: {
    id: number;
    name: string;
  };
}>();
</script>

<template>
  <div class="version">Version Page {{ version.name }}</div>
</template>

<style lang="scss" scoped>
.version {
}
</style>
