package com.logic

import com.plugins.ScanHardCode

class ConfigurationScan implements Serializable {

    def steps
    def plugins = []
    ScanHardCode scanCode

    ConfigurationScan(Map args) {
        this.steps = args.steps
        this.plugins = args.plugins ?: []
        this.scanCode = new ScanHardCode([steps: args.steps])
    }

    def test() {
        steps.sh "echo Method test doing...."
    }

    def superscan() {
        steps.sh "echo superscan doing..."
    }

    def scan() {
        // try {
        //     this.plugins.each { methodName -> 
        //         if (this.metaClass.respondsTo(this, methodName)) {
        //             this.scanCode."${methodName}"('/test/configMap.yaml')
        //         } else {
        //             throw new RuntimeException("No Plugin ${methodName}")
        //         }
        //     }
        // } catch (Exception e) {
        //     steps.error(e.message)
        // }
        // scanCode."${methodName}"('/test/configMap.yaml')
        scanCode.checkHardCode('/test/configMap.yaml')
    }

}