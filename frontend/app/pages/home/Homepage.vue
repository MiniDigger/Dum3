<script lang="ts" setup>
import useI18n from "~/composables/useI18n";

defineProps<{
  software?: string;
}>();

const { t } = useI18n();
</script>

<template>
  <div>
    <h1>{{ t("homepage.title", "Dum v3") }}</h1>
    <template v-if="software">{{ software }}</template>
  </div>
</template>
