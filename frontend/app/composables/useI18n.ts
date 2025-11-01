export default function useI18n() {
    return {
        // TODO i18n
        // maybe automatically scan for default values and create a translation file to submit to crowdin
        // check how definePageMeta and similar compiler macros work
        t: (key: string, defaultValue: string) => defaultValue,
    }
}
