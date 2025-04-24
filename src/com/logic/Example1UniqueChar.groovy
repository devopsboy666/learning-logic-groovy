package com.logic

class Example1UniqueChar implements Serializable {
    def steps
    def message 

    Example1UniqueChar(Map args) {
        this.steps = args.steps
        this.message = args.message
    }

    def showString() {
        steps.sh "echo ${this.message[0]}"
    }
}