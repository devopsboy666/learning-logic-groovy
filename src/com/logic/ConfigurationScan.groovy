package com.logic

class ConfigurationScan implements Serializable {

    def steps
    def methodToCall = []

    ConfigurationScan(Map args) {
        this.steps = args.steps
        this.methodsToCall = args.plugins ?: []
    }

    def test() {
        steps.sh "echo Method test() doing...."
    }

    def superscan() {
        steps.sh "echo superscan() doing..."
    }

    def scan() {
        try {
            this.methodsToCall.each { methodName -> 
                if (this.metaClass.respondsTo(this, methodName)) {
                    this."${methodName}"()
                } else {
                    throw new RuntimeException("Not Found Plugin ${methodName}")
                }
            }
        } catch (Exception e) {
            steps.sh "echo Error -> ${e.message}"
        }
    }

}