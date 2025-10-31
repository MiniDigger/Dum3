import eslint from '@eslint/js';
import eslintConfigPrettier from 'eslint-config-prettier';
import eslintPluginVue from 'eslint-plugin-vue';
import oxlint from 'eslint-plugin-oxlint';
import globals from 'globals';
import typescriptEslint from 'typescript-eslint';

export default typescriptEslint.config(
    {ignores: ['*.d.ts', '**/coverage', '**/dist']},
    {
        extends: [
            eslint.configs.recommended,
            ...typescriptEslint.configs.recommended,
            ...eslintPluginVue.configs['flat/recommended'],
            ...oxlint.buildFromOxlintConfigFile(".oxlintrc.json"),
        ],
        files: ['**/*.{ts,vue}'],
        languageOptions: {
            ecmaVersion: 'latest', globals: globals["shared-node-browser"], parserOptions: {
                parser: typescriptEslint.parser,
            }, sourceType: 'module',
        },
        rules: {
            // your rules
        },
    },
    eslintConfigPrettier,
);
