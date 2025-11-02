<script setup lang="ts">
import "@/style/main.scss"

</script>
<template>
  <div>
    <NuxtRouteAnnouncer />
    <Suspense>
      <NuxtPage />
    </Suspense>
  </div>
</template>
