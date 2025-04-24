package com.logic

class Triangle implements Serializable {

    def steps
    def number

    Triangle(Map args) {
        this.steps = args.steps
        this.number = args.number
    }

    def createTriangle() {
        def center = ( this.number / 2 )
        def high = center + 1
        def rows = 1
        
        steps.sh "touch triangle.txt"

        for ( int h=1; h<=high; h++) {
            
            for (int s=h; s<=center; s++) {
                steps.sh "echo -n \" \" >> triangle.txt"
            }
            
            for (int r=1; r<=rows; r++) {
                steps.sh "echo -n '*' >> triangle.txt"
            }
            
            rows = rows + 2
            steps.sh "echo >> triangle.txt"
        }

        steps.sh "cat triangle.txt"
    }
}