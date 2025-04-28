package com.logic

class ExampleWordCounter implements Serializable {

    def steps 
    def message

    ExampleWordCounter(Map args) {
        this.steps = args.steps
        this.message = args.message 
    }

    def countDuplicateWords() {
        def arr_mess = this.message.toLowerCase().split(" ")  // ทำตัวพิมพ์เล็กหมดก่อน
        def wordCount = [:]  // สร้าง Map ว่าง

        // นับจำนวนแต่ละคำ
        arr_mess.each { word ->
            wordCount[word] = (wordCount[word] ?: 0) + 1
        }

        // สร้างไฟล์ใหม่
        steps.sh "rm -f record.txt"
        steps.sh "touch record.txt"

        // เขียนข้อมูลลงไฟล์
        wordCount.each { word, count ->
            steps.sh "echo ${word} = ${count} >> record.txt"
        }

        steps.sh "cat record.txt"
    }

}