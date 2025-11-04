<script lang="ts" setup>
import User from "~/pages/user/User.vue";

const route = useRoute("User");

const { data, error, pending } = await useAsyncData(
  "user",
  (_nuxtApp, { signal }) => {
    return Promise.resolve({
      name: `User ${route.params.user}`,
    });
    // return $fetch('/users', {
    //   query: {
    //     id: userId,
    //   },
    //   signal,
    // });
  },
  {
    watch: [() => route.params.user],
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
