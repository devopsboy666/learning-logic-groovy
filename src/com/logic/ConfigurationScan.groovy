package com.logic

class ConfigurationScan implements Serializable {

    def steps
    def plugins = []
    def scanMethods = [:]

    ConfigurationScan(Map args) {
        this.steps = args.steps
        this.plugins = args.plugins ?: []
        steps.sh "echo ${plugins}"
    }

    def test() {
        steps.sh "echo Method test() doing...."
    }

    def superscan() {
        steps.sh "echo superscan() doing..."
    }

    def scan() {
        try {
            this.plugins.each { methodName ->
                def action = this.scanMethods[methodName]
                if (action != null) {
                    action.call()
                } else {
                    throw new RuntimeException("Not Found Plugin ${methodName}")
                }
            }
        } catch (Exception e) {
            steps.sh "echo Error -> ${e.message}"
        }
    }

}