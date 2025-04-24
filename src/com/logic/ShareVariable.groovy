package com.logic

class ShareVariable implements Serializable {

    def steps 
    def number

    ShareVariable(Map args) {
        this.steps = args.steps
    }

    def setNumber(int number) {
        this.number = number
    }
    
    int getNumber() {
        return this.number
    }
}