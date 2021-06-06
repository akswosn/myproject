
const path = require("path");

//spring boot resources/static 빌드 하도록 수정
module.exports = {
    runtimeCompiler: true,
    outputDir: path.resolve(__dirname, "../src/main/resources/static")
}