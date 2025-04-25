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
        steps.sh "echo end = ${end}"
        for (int i=end; i<=0; i--) { 
            steps.sh "echo this.message[i] is $this.message[i]"    
            swap = swap + this.message[i]
        }
        steps.sh "echo swap is ${swap}"
        if (swap == this.message) {
            return true
        }

        return false
    }

    def checkPalindrome() {
        def isTrue = this.swapMessage()
        if (isTrue) {
            steps.sh "echo The message ${this.message} is Palindrome"
        } else {
            steps.sh "echo ${steps.message} is not Palindrome"
        }
    }
}