<script setup lang="ts">

const {
  side = 'bottom',
  align = 'start',
  width = '100%',
  open = false,
  autoClose = true,
  label = 'Open Menu',
  triggerType = 'secondary',
} = defineProps<{
  side?: 'top' | 'right' | 'bottom' | 'left';
  align?: 'start' | 'center' | 'end';
  width?: string;
  open?: boolean;
  autoClose?: boolean;
  label?: string;
  triggerType?: 'primary' | 'secondary' | 'danger' | 'transparent';
}>()

const emit = defineEmits<{
  'update:open': [value: boolean];
}>();

const toggleState = ref(open);

watch(() => open, (newValue) => {
  toggleState.value = newValue;
});

watch(toggleState, (newValue) => {
  emit('update:open', newValue);
});

const handleContentClick = () => {
  if (autoClose) {
    toggleState.value = false;
  }
};
</script>

<template>
  <DropdownMenuRoot v-model:open="toggleState">
    <DropdownMenuTrigger as-child>
      <HButton
          :buttonType="triggerType"
          distancedIcon
          textAlign="left"
          :icon="toggleState ? 'lucide:chevron-down' : 'lucide:chevron-up'"
          iconSide="right"
          :width="width"
      >
        {{ label }}
      </HButton>
    </DropdownMenuTrigger>

    <DropdownMenuPortal>
      <DropdownMenuContent :sideOffset=4 :side="side" :align="align" avoidCollisions loop>
        <HCard>
          <div :style="{ width }"  class="content" @click="handleContentClick">
            <slot />
          </div>
        </HCard>
      </DropdownMenuContent>
    </DropdownMenuPortal>
  </DropdownMenuRoot>
</template>

<style scoped lang="scss">

.content {
  display: flex;
  flex-direction: column;
  gap: 0.25rem;
}
</style>