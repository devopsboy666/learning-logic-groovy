package com.logic

class Example1UniqueChar implements Serializable {
    def steps
    def message 

    Example1UniqueChar(Map args) {
        this.steps = args.steps
        this.message = args.message
    }

    boolean fineUnique() {
        for ( int i=0; i < this.message.length(); i++ ) {
            steps.sh "echo=============================================================="
            steps.sh "echo Check index ${i} Charactor is ${this.message[i]}"
            for ( int j=i+1; j < this.message.length(); j++ ) {
                steps.sh "echo Show length index j ${this.message.length()-i}"
                steps.sh "echo Check index ${j} Charactor is ${this.message[j]}"
                if ( this.message[i] == this.message[j] ) {
                    return false
                }
            }
        }

        return true
    }

    def showString() {
        steps.sh "echo ${this.message[0]}"
        steps.sh "echo ${this.message.length()}"
    }
}