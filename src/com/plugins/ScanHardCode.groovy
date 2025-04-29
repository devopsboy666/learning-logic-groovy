package com.plugins

class ScanHardCode implements Serializable {

    def steps 
    def hardcodePatterns = [
        ~/password\s*:\s*.+/,
        ~/secret\s*:\s*.+/,
        ~/token\s*:\s*.+/,
        ~/url\s*:\s*http[s]?:\/\/.+/,
        ~/endpoint\s*:\s*.+/
    ]


    ScanHardCode(Map args) {
        this.steps = args.steps
    }

    def checkHardCode(String path) {

        def violations = [] 
        def content = steps.readFile(path)

        content.split('\n').eachWithIndex { line, idx ->
            hardcodePatterns.each { pattern ->
                if ((line =~ pattern) && !line.contains('${')) {
                    violations << "Line ${idx + 1}: '${line.trim()}'"
                }
            }
        }
        def err_message = "========================================================\n" +
                "❌ Hard-coded values detected:\n" +
                violations.join('\n') + "\n" +
                "==============================================================="

        if (violations) {
            steps.error(err_message)
        } else {
            steps.echo "✅ No hard-coded values found."
        }

    }

}