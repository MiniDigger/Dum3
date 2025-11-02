import { defineNuxtModule, extendPages } from "nuxt/kit";

export default defineNuxtModule({
  meta: {
    name: "routing",
  },
  setup() {
    extendPages((pages) => {
      pages.forEach((page) => {
        page.name = _parsePagePath(page.file);
      });
    });
  },
});

export function _parsePagePath(path?: string): string | undefined {
  if (!path) return undefined;
  const split = path.split("/");
  const fileName = split[split.length - 1];
  return fileName?.replace(".page.vue", "");
}
