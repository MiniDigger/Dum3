import vue from '@vitejs/plugin-vue'
import {defineConfig} from 'vite'
import eslintPlugin from 'vite-plugin-eslint';
import oxlintPlugin from "vite-plugin-oxlint";
import {resolve} from "node:path";

// https://vite.dev/config/
export default defineConfig({
    plugins: [vue(), oxlintPlugin(), eslintPlugin()],
    resolve: {
        alias: {
            '@': resolve(__dirname, './src'),
        },
    },
})
