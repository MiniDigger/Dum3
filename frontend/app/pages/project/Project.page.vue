<script setup lang="ts">
import Project from "~/pages/project/Project.vue";
import ProjectLayout from "~/pages/project/ProjectLayout.vue";

const route = useRoute("Project");

const { data, error, pending } = await useAsyncData(
  "project",
  (_nuxtApp, { signal }) => {
    return Promise.resolve({
      id: -1,
      name: `Project ${route.params.project}`,
    });
    // return $fetch('/projects', {
    //   query: {
    //     id: projectId,
    //   },
    //   signal,
    // });
  },
  {
    watch: [() => route.params.project],
  }
);

definePageMeta({
  path: "/p/:project/",
});
</script>
<template>
  <div v-if="pending">Loading...</div>
  <div v-else-if="error">Error: {{ error.message }}</div>
  <ProjectLayout v-else>
    <Project :project="data!" />
  </ProjectLayout>
</template>
