// https://nuxt.com/docs/api/configuration/nuxt-config
export default defineNuxtConfig({
  compatibilityDate: "2025-07-15",
  devtools: { enabled: true },
  modules: [
    "@nuxt/icon",
    "@nuxt/test-utils/module",
    "@nuxt/fonts",
    "reka-ui/nuxt"
  ],
  pages: {
    pattern: "**/*.page.vue",
  },
  experimental: {
    typedPages: true,
  },
  components: [
    {
      path: '@/components',
      pathPrefix: false,
    },
  ],
  typescript: {
    tsConfig: {
      include: ["../.storybook/**/*"],
    }
  }
});