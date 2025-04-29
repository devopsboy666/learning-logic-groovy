package com.logic

class ConfigurationScan implements Serializable {

    def steps
    def plugins = []

    ConfigurationScan(Map args) {
        this.steps = args.steps
        this.plugins = args.plugins ?: ['test']
    }

    def test() {
        steps.sh "echo Method test doing...."
    }

    def superscan() {
        steps.sh "echo superscan doing..."
    }

    def scan() {
        this.plugins.each { methodName ->
            steps.sh "echo call method ${methodName}" 
            this."${methodName}"()
        }
    }

}