<script lang="ts" setup>
const { type = "text" } = defineProps<{
  /**
   * this is a test
   */
  type: "text" | "password" | "email";
  label: string;
}>()

const model = defineModel<string>();
</script>

<template>
  <label class="input">
    <span class="input__label">{{ label }}</span>
    <input class="input__input" v-model="model" :type/>
  </label>
</template>

<style lang="scss" scoped>
.input {
  display: flex;

  &__label {
    flex: 0;
  }

  &__input {
    flex: 1;
  }
}
</style>
