import {_parsePagePath} from "./routing";
import {expect, test, describe} from "vitest";

describe("routeing tests", () => {
    test("test path parsing", () => {
        expect(_parsePagePath("index.page.vue")).toEqual("index");
        expect(_parsePagePath("about.page.vue")).toEqual("about");
        expect(_parsePagePath("user/profile.page.vue")).toEqual("profile");
        expect(_parsePagePath("dashboard/settings.page.vue")).toEqual("settings");
        expect(_parsePagePath("nested/level1/level2/page.page.vue")).toEqual("page");
    })
});
