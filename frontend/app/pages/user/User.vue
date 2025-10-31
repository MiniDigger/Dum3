<script lang="ts" setup>

defineProps<{
  user: {
    name: string;
  }
}>()
</script>

<template>
  <div>User Page {{ user.name }}</div>
</template>
