<script lang="ts" setup>
import InputText from "./InputText.vue";
import { ref } from "vue";

const model = ref("Hello World");
</script>

<template>
  <Story>
    <InputText v-model="model" />

<!--    <template #controls>-->
<!--      <HstText title="default slot" v-model="text" />-->
<!--    </template>-->
  </Story>
</template>
