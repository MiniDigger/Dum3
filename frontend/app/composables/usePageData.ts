export default function usePageData(path: string) {
  return computed(() => path.split(".")?.[1]);
}
