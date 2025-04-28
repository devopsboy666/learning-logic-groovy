package com.logic

class ExampleWordCounter implements Serializable {

    def steps 
    def message

    ExampleWordCounter(Map args) {
        this.steps = args.steps
        this.message = args.message 
    }

    def countDuplicateWords() {

        def arr_mess = this.message.split(" ")
        def length = arr_mess.size()
        def arr_count = []
        def count
        def map_count = [:]
        def newLength

        for (int i=0; i<length; i++) {
            count = 0
            for (int j=i+1; j<length; j++) {
                if (arr_mess[i] == arr_mess[j]) {
                    steps.sh "echo arr_mess i = ${arr_mess[i]}"
                    steps.sh "echo arr_mess j = ${arr_mess[j]}"
                    count = count + 1
                }
            }
            map_count["word"] = arr_mess[i]
            map_count["count"] = count
            steps.sh "echo This Map ${map_count["word"]} = ${map_count["count"]}"
            arr_count << map_count
        } 

        newLength = arr_count.size()
        steps.sh "touch record.txt"
        
        for (int i=0; i<newLength; i++) {
            steps.sh "echo ${arr_count[i].word} = ${arr_count[i].count} >> record.txt" 
        }

        steps.sh "cat record.txt"
    }

}