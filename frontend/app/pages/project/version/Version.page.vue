<script setup lang="ts">
import Version from "~/pages/project/version/Version.vue";

const route = useRoute("Version");

const { data, error, pending } = await useAsyncData(
  "version",
  (_nuxtApp, { signal }) => {
    return Promise.resolve({
      id: -1,
      name: `Version ${route.params.version}`,
    });
    // return $fetch('/versions', {
    //   query: {
    //     id: versionId,
    //   },
    //   signal,
    // });
  },
  {
    watch: [() => route.params.version],
  }
);

definePageMeta({
  path: "/p/:project/v/:version/",
});
</script>
<template>
  <div v-if="pending">Loading...</div>
  <div v-else-if="error">Error: {{ error.message }}</div>
  <Version
    v-else
    :version="data!"
  />
</template>
