<script setup lang="ts">
import Version from "~/pages/project/version/Version.vue";

const route = useRoute("Version");

const versionId = computed(() => route.params.version?.split(".")?.[1]);

const {data, error, pending} = await useAsyncData("version", (_nuxtApp, {signal}) => {
      return Promise.resolve({
        id: Number(versionId.value),
        name: `Version ${versionId.value}`,
      })
      // return $fetch('/versions', {
      //   query: {
      //     id: versionId,
      //   },
      //   signal,
      // });
    }, {
      watch: [versionId],
    },
);

definePageMeta({
  path: "/p/:project/v/:version/",
});
</script>
<template>
  <div v-if="pending">Loading...</div>
  <div v-else-if="error">Error: {{ error.message }}</div>
  <Version v-else :version="data!" />
</template>
