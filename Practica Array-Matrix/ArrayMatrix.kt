
// TO compile:  kotlinc HelloWorld.kt -include-runtime -d HelloWorld.jar
    // TO run java -jar HelloWorld.jar provinces.txt
fun main(args: Array<String>) {
  // var arr = IntArray(50000)
  // println("Tamaño del arreglo: " + arr.size)

  // -----------------------------
  // Llenar arreglo de 0..n con una constante"
  // fillArrayZeroToN(arr); 
  
  // -----------------------------
  // Llenar arreglo de n..0 con una constante"
  // fillArrayNtoZero(arr);

  // -----------------------------
  // Lectura e impresion de celdas
    //Todas las celdas
    
    

    //Celdas multiplos de 10
    // printMultipleOfTen(arr);

    //Celdas multiplos de 100
    // printMultipleOfOneHundred(arr)

    //Celdas multiplos de 1000
    // printMultipleOfOneThousand(arr);

val rows = 75;
val cols = 75;
var matrix=Array(rows, {IntArray(cols)})

// println("\nLlenar la tabla con orden (f, c)");
// fillMatrixRowColumn(matrix);


// println("\nLeer la tabla con orden (f, c)")
// println("Todas")
// printAllCellsRowColumn(matrix);

// println("\nCuando sean multiplos de 10");
// printMultipleOfTenRowColumn(matrix);

// println("\nCuando sean multiplos de 100")
// printMultipleOfHundredRowColumn(matrix);

// println("\nCuando sean multiplos de 1000")
// printMultipleOfThousandRowColumn(matrix);

println("\nLlenar la tabla con orden (c, f)")
fillMatrixColumnRow(matrix);
for (i in 1..5) {
      printMultipleOfThousandColumnRow(matrix);
}

// println("\nTodas")
// printAllCellsColumnRow(matrix);

// println("\nCuando sean multiplos de 10")
// printMultipleOfTenColumnRow(matrix);

// println("\nCuando sean multiplos de 100")
// printMultipleOfHundredColumnRow(matrix);

// println("\nCuando sean multiplos de 100")
// printMultipleOfThousandColumnRow(matrix);

}

fun fillArrayZeroToN(arr: IntArray): Unit {
  println("\nLlenar arreglo de 0..n con una constante")
 var startTime = System.currentTimeMillis();
  for (i in 0..arr.size - 1) {
    arr[i] = 42;
  }
  var endTime = System.currentTimeMillis();
  println("\nLlenar arreglo de 0..n con una constante")
  println("Tiempo: " + (endTime-startTime) + "ms.")
}

fun fillArrayNtoZero(arr: IntArray): Long {
  println("\nLlenar arreglo de n..0 con una constante")
  var startTime = System.currentTimeMillis();
  for (i in arr.size-1 downTo 0) {
    arr[i] = 42;
  }
  var endTime = System.currentTimeMillis();
  println("\nLlenar arreglo de n..0 con una constante")
  println("Tiempo: " + (endTime-startTime) + "ms.")
  return (endTime-startTime);
}

fun printAllCells(arr: IntArray): Long {
  println("\nImpresion de todas las celdas.")
  var startTime = System.currentTimeMillis();
  for (i in 0..arr.size-1) {
    var cur = arr[i];
    println("$cur")
  }
  var endTime = System.currentTimeMillis();
  println("\nImpresion de todas las celdas.")
  println("Tiempo: " + (endTime-startTime) + "ms.")
  return (endTime-startTime);
}

fun printMultipleOfTen(arr: IntArray): Unit {
  println("Impresion de celdas multiplos de 10.")
  var startTime = System.currentTimeMillis();
  for (i in 0..arr.size-1) {
    var cur = arr[i];
    if(i%10==0){
      println("$cur")
    }
  }
  var endTime = System.currentTimeMillis();
  println("Impresion de celdas multiplos de 10.")
  println("Tiempo: " + (endTime-startTime) + "ms.")
}

fun printMultipleOfOneHundred(arr: IntArray): Unit {
  println("Impresion de celdas multiplos de 100.")
  var startTime = System.currentTimeMillis();
  for (i in 0..arr.size-1) {
    var cur = arr[i];
    if(i%100==0){
      println("$cur, ")
    }
  }
  var endTime = System.currentTimeMillis();
  println("Impresion de celdas multiplos de 100.")
  println("Tiempo: " + (endTime-startTime) + "ms.")
}

fun printMultipleOfOneThousand(arr: IntArray): Unit {
  println("Impresion de celdas multiplos de 1000.")
  var startTime = System.currentTimeMillis();
  for (i in 0..arr.size-1) {
    var cur = arr[i];
    if(i%1000==0){
      print("$cur, ")
    }
  }
  var endTime = System.currentTimeMillis();
  println("Impresion de celdas multiplos de 1000.")
  println("Tiempo: " + (endTime-startTime) + "ms.")
}

fun fillMatrixRowColumn(matrix: Array<IntArray>): Unit {
  println("\nLlenar matriz en orden fila columna")
    var rows = matrix.size;
    var cols = matrix[0].size;

    var startTime = System.currentTimeMillis();
    for (i in 0..rows-1) {
        for (j in 0..cols-1) {
            matrix[i][j] = 42;
         }
    }
    var endTime = System.currentTimeMillis();
    println("\nLlenar matriz en orden fila columna")
    println("Tiempo: " + (endTime-startTime) + "ms.")
}

fun printAllCellsRowColumn(matrix: Array<IntArray>): Unit {
  println("\nImpresion de todas las celdas de matriz, orden fila-columna.")
  var rows = matrix.size;
  var cols = matrix[0].size;

  var startTime = System.currentTimeMillis();  
  for (r in 0..rows-1) {
      for (c in 0..cols-1) {
          var cur = matrix[r][c];
          print("$cur | ")
      }
      println()
  }
  var endTime = System.currentTimeMillis();
  println("\nImpresion de todas las celdas de matriz, orden fila-columna.")
  println("Tiempo: " + (endTime-startTime) + "ms.")
}

fun printMultipleOfTenRowColumn(matrix: Array<IntArray>): Unit {
  println("\nImpresion de celdas multiplos de 10, matriz, orden fila-columna.")
  var rows = matrix.size;
  var cols = matrix[0].size;

  var startTime = System.currentTimeMillis();
  var counter = 0;  
  for (r in 0..rows-1) {
      for (c in 0..cols-1) {
        var cur = matrix[r][c];
          if(counter % 10==0){
              println("$cur | ");
            }
      }
  }
  var endTime = System.currentTimeMillis();
  println("\nImpresion de celdas multiplos de 10, matriz, orden fila-columna.")
  println("Tiempo: " + (endTime-startTime) + "ms.")
}

fun printMultipleOfHundredRowColumn(matrix: Array<IntArray>): Unit {
 println("\nImpresion de celdas multiplos de 100, matriz, orden fila-columna.")
 var rows = matrix.size;
  var cols = matrix[0].size;

  var startTime = System.currentTimeMillis();
  var counter = 0;  
  for (r in 0..rows-1) {
      for (c in 0..cols-1) {
        var cur = matrix[r][c];
          if(counter % 100==0){
              println("$cur | ");
            }
      }
  }
  var endTime = System.currentTimeMillis();
  println("\nImpresion de celdas multiplos de 100, matriz, orden fila-columna.")
  println("Tiempo: " + (endTime-startTime) + "ms.")
}

fun printMultipleOfThousandRowColumn(matrix: Array<IntArray>): Unit {
 println("\nImpresion de celdas multiplos de 1000, matriz, orden fila-columna.")
 var rows = matrix.size;
  var cols = matrix[0].size;

  var startTime = System.currentTimeMillis();
  var counter = 0;  
  for (r in 0..rows-1) {
      for (c in 0..cols-1) {
        var cur = matrix[r][c];
          if(counter % 1000==0){
              println("$cur | ");
            }
      }
  }
  var endTime = System.currentTimeMillis();
  println("\nImpresion de celdas multiplos de 1000, matriz, orden fila-columna.")
  println("Tiempo: " + (endTime-startTime) + "ms.")
}

fun fillMatrixColumnRow(matrix: Array<IntArray>): Unit {
    println("\nLlenar matriz con orden columna-fila")
    var rows = matrix.size;
    var cols = matrix[0].size;

    var startTime = System.currentTimeMillis();
    for (i in 0..cols-1) {
        for (j in 0..rows-1) {
            matrix[j][i] = 42;
        }
    }
  var endTime = System.currentTimeMillis();
  println("\nLlenar matriz con orden columna-fila")
  println("Tiempo: " + (endTime-startTime) + "ms.")
}
fun printAllCellsColumnRow(matrix: Array<IntArray>): Unit {
  var rows = matrix.size;
  var cols = matrix[0].size;

  var startTime = System.currentTimeMillis();  
  for (c in 0..cols-1) {
      for (r in 0..rows-1) {
        var cur = matrix[r][c];
          print("$cur | ")
      }
      println()
  }
  var endTime = System.currentTimeMillis();
  println("Tiempo: " + (endTime-startTime) + "ms.")
}

fun printMultipleOfTenColumnRow(matrix: Array<IntArray>): Unit {
  println("\nImpresion de celdas multiplos de 10, matriz, orden columna-fila.")
  var rows = matrix.size;
  var cols = matrix[0].size;

  var startTime = System.currentTimeMillis();
  var counter = 0;  
  for (c in 0..cols-1) {
      for (r in 0..rows-1) {
        var cur = matrix[r][c];
          if(counter % 10==0){
              println("$cur | ");
            }
          counter++;
      }
  }
  var endTime = System.currentTimeMillis();
  println("\nImpresion de celdas multiplos de 10, matriz, orden columna-fila.")
  println("Tiempo: " + (endTime-startTime) + "ms.")
}

fun printMultipleOfHundredColumnRow(matrix: Array<IntArray>): Unit {
  println("\nImpresion de celdas multiplos de 100, matriz, orden columna-fila.")
 var rows = matrix.size;
  var cols = matrix[0].size;

  var startTime = System.currentTimeMillis();
  var counter = 0;  
  for (c in 0..cols-1) {
      for (r in 0..rows-1) {
        var cur = matrix[r][c];
          if(counter % 100==0){
              println("$cur | ");
            }
          counter++;
      }
  }
  var endTime = System.currentTimeMillis();
  println("\nImpresion de celdas multiplos de 100, matriz, orden columna-fila.")
  println("Tiempo: " + (endTime-startTime) + "ms.")
}

fun printMultipleOfThousandColumnRow(matrix: Array<IntArray>): Unit {
  println("\nImpresion de celdas multiplos de 1000, matriz, orden columna-fila.")
 var rows = matrix.size;
  var cols = matrix[0].size;

  var startTime = System.currentTimeMillis();
  var counter = 0;  
  for (c in 0..cols-1) {
      for (r in 0..rows-1) {
        var cur = matrix[r][c];
          if(counter % 1000==0){
              println("$cur | ");
            }
          counter++;
      }
  }
  var endTime = System.currentTimeMillis();
  println("\nImpresion de celdas multiplos de 1000, matriz, orden columna-fila.")
  println("Tiempo: " + (endTime-startTime) + "ms.")
}
