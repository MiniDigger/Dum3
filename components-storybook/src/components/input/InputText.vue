<script lang="ts" setup>
const { type = "text" } = defineProps<{
  /**
   * this is a test
   */
  type: "text" | "password" | "email";
  label?: string;
}>()

try {
  console.log("ddd")
} catch (error) {
  console.error(error);
}

const model = defineModel<string>();
</script>

<template>
  <label class="input">
    <span class="input__label">{{ label }}</span>
    <input v-model="model" class="input__input" :type/>
  </label>
</template>

<style lang="scss" scoped>
@use "@/style/util/base" as base;

.input {
  display: flex;
  background-color: base.$background;

  &__label {
    flex: 0;
    color: base.$on-background;

    &:hover {
      color: base.$info;
    }
  }

  &__input {
    flex: 1;
  }
}
</style>
