package com.logic

class CharCounter implements Serializable {

    def steps
    def texts

    CharCounter(Map args) {
        this.steps = args.steps
        this.texts = args.texts
    }

    def countDuplicateChars() {
        def t = this.texts
        def charMap = [:]
        t.each { c -> 
            charMap[c] = (charMap[c] ?: 0) + 1
        }

        charMap.each { k, v ->
            steps.sh "echo ${k} = ${v}"
        }
    }

}