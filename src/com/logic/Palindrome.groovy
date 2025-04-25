package com.logic

class Palindrome implements Serializable {
    
    def steps 
    def message

    Palindrome(Map args) {
        this.steps = args.steps ?: this
        this.message = args.message ?: ""

        if(this.message == "") {
            error("Message is empty....")
        } 
    }

    boolean swapMessage() {
        def end = this.message.length() - 1
        def swap = ""
        for (int i=end; i<=0; i--) { 
            swap = swap + this.message[i]
        }

        if (swap == this.message) {
            return true
        }

        return false
    }

    checkPalindrome() {
        def isTrue = this.swapMessage()
        if (isTrue) {
            steps.sh "echo The message ${this.message} is Palindrome"
        } else {
            steps.sh "echo ${steps.message} is not Palindrome"
        }
    }
}