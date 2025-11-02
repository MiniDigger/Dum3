<script lang="ts" setup>
import User from "~/pages/user/User.vue";
import usePageData from "~/composables/usePageData";

const route = useRoute("User");

const userId = usePageData(route.params.user);

const { data, error, pending } = await useAsyncData(
  "user",
  (_nuxtApp, { signal }) => {
    return Promise.resolve({
      name: `User ${userId.value}`,
    });
    // return $fetch('/users', {
    //   query: {
    //     id: userId,
    //   },
    //   signal,
    // });
  },
  {
    watch: [userId],
  }
);

definePageMeta({
  path: "/u/:user/",
});
</script>

<template>
  <!-- todo error handling? maybe as its own component? or does the global suspense cover it? -->
  <div>
    <div v-if="pending">Loading...</div>
    <div v-else-if="error">Error: {{ error.message }}</div>
    <User
      v-else
      :user="data!"
    />
  </div>
</template>
