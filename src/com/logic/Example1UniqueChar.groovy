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
            for ( int j=i+1; j < this.message.length()-i; j++ ) {
                steps.sh "echo ${i} ${this.message[i]} --> ${j} ${this.message[j]}"
                if ( this.message[i] == this.message[j] ) {
                    return false
                }
            }
        }

        return true
    }

    def showString() {
        steps.sh "echo ${this.message[0]}"
    }
}