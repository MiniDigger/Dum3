<script setup lang="ts">

const {
  side = 'bottom',
  align = 'start',
  width = '100%',
  open = false,
} = defineProps<{
  side?: 'top' | 'right' | 'bottom' | 'left';
  align?: 'start' | 'center' | 'end';
  width?: string;
  open?: boolean;
}>()

const toggleState = ref(open);
</script>

<template>
  <DropdownMenuRoot v-model:open="toggleState">
    <DropdownMenuTrigger as-child>
      <slot name="trigger" />
    </DropdownMenuTrigger>

    <DropdownMenuPortal>
      <DropdownMenuContent :sideOffset=4 :side="side" :align="align" avoidCollisions loop>
        <HCard :width="width">
          <div class="content">
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