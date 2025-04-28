package com.logic

class MinToMax implements Serializable {

    def steps
    def numbers

    MinToMax(Map args) {
        this.steps = args.steps
        this.numbers = args.numbers
    }

    def sortNumbers() {
        def tmp
        def length = this.numbers.size()
        for (int i=0; i<length; i++) {
            for (int j=i; j>0; j--) {
                if (this.numbers[j] < this.numbers[j-1]) {
                    tmp = this.numbers[j-1]
                    this.numbers[j-1] = this.numbers[j]
                    this.numbers[j] = tmp
                }
            }
        }
        steps.sh "echo Sort = ${this.numbers}"
    }
}