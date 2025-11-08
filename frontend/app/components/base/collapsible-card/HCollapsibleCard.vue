<script setup lang="ts">

const {
  width = '100%',
  open = false,
} = defineProps<{
  open?: boolean;
  width?: string;
}>()

const openState = ref(open)

const openCard = () => {
  openState.value = !openState.value
}
</script>

<template>
  <HCard :width="width">
    <template #header>
      <div class="header" @click="openCard">
        <slot name="header"/>
        <HButton
          buttonType="primary"
          rounded
          onlyHover
          :icon="openState ? 'lucide:chevron-down' : 'lucide:chevron-up'"
        />
      </div>
    </template>
    <Transition name="collapse">
      <div v-if="openState">
        <slot/>
      </div>
    </Transition>
  </HCard>
</template>


<style scoped lang="scss">

.header {
  display: flex;
  justify-content: space-between;
  align-items: center;
}
</style>