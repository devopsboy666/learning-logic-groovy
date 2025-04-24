package com.logic

class Example2CheckWorkd implements Serializable {

    def steps 
    def words
    def wordsCount

    Example2CheckWorkd(Map args){
        this.steps = args.steps
        this.words = args.words
    }

    def countWord() {
        this.wordsCount = this.words.split(" ")
        steps.sh "echo ${this.wordsCount}"
        steps.sh "echo ${this.words} = ${this.wordsCount.size()}"
    }
}