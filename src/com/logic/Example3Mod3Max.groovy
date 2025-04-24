package com.logic

class Example3Mod3Max implements Serializable {

    def steps
    def numList
    def resultList

    Example3Mod3Max(Map args) {
        this.steps = args.steps
        this.numList = args.numList 
    }

    def fineMod3() {
        for ( int i=0; i < this.numList.size(); i++) {
            if ( this.numList[i] % 3 == 0) {
                this.resultList << this.numList[i]
            }
        }
        steps.sh "echo ${this.resultList}"
    }

    int showMaxMod3() {
        def max = 0
        for (int i=0; i < this.resultList.size(); i++ ) {
            if ( this.resultList[i] > max ){
                max = this.resultList[i]
            }
        }

        return max
    }
}