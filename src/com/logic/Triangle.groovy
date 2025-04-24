package com.logic

class Triangle implements Serializable {

    def steps
    def number

    Triangle(Map args) {
        this.steps = args.steps
        this.number = args.number
    }

    def createTriangle() {       
        def fileName = "triangle.txt"
        steps.sh "touch ${fileName}"
        this.triangleLogic(fileName)
    }

    def triangleLogic(String fileName) {
        def center = ( this.number / 2 )
        def high = center + 1
        def rows = 1
        for ( int h=1; h<=high; h++) {  
            for ( int s=h; s<=center; s++ ) {
                steps.sh "echo -n \" \" >> ${fileName}"
            }
            for ( int r=1; r<=rows; r++ ) {
                steps.sh "echo -n '*' >> ${fileName}"
            }
            rows = rows + 2
            steps.sh "echo >> ${fileName}"
        }
        steps.sh "cat ${fileName}"
    }

    def invertedTriangle() {
        def fileName = "inverted.txt"
        steps.sh "touch ${fileName}"
        this.invertedLogic(fileName, this.number)
    }

    def invertedLogic(String fileName, int row) {
        def center = ( row / 2 )
        def high = center + 1
        def rows = row
        for ( int h=high; h>=1; h--) {  
            for ( int s=h; s<=center; s++ ) {
                steps.sh "echo -n \" \" >> ${fileName}"
            }
            for ( int r=1; r<=rows; r++ ) {
                steps.sh "echo -n '*' >> ${fileName}"
            }
            rows = rows - 2
            steps.sh "echo >> ${fileName}"    
        }
        steps.sh "cat ${fileName}"
    }

    def invertedDiamond(String fileName, int row) {
        def center = ( row / 2 )
        def high = center + 1
        def rows = row
        for ( int h=high; h>=1; h--) {  
            for ( int s=h; s<center; s++ ) {
                steps.sh "echo -n \" \" >> ${fileName}"
            }
            for ( int r=1; r<=rows; r++ ) {
                steps.sh "echo -n '*' >> ${fileName}"
            }
            rows = rows - 2
            steps.sh "echo >> ${fileName}"    
        }
        steps.sh "cat ${fileName}"
    }

    def createDiamond() {
        def fileName = "diamond.txt"
        steps.sh "touch ${fileName}"
        this.triangleLogic(fileName)
        this.invertedDiamond(fileName, this.number - 2)
    }
}