package com.logic

class OddNumber implements Serializable {

    def steps
    def number
    def str_number

    OddNumber(Map args) {
        this.steps = args.steps ?: this
        this.str_number = args.number
        this.number = str_number.toInteger() ?: -1 

        if( this.number < 3) {
            error("Number much > 3")
        } 
    }

    boolean isOddNumber() {
        if( this.number % 2 == 1) {
            steps.sh "echo Number ${this.number} is Odd Number"
            return true
        } else {
            error("Number much be Odd Number")
            return false
        }
    }

    int getOddNumber() {
        return this.number
    }
}