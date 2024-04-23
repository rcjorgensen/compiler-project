package test.cprl

import edu.citadel.compiler.ErrorHandler
import edu.citadel.compiler.Source
import edu.citadel.cprl.Scanner
import edu.citadel.cprl.Symbol
import edu.citadel.cprl.Token

import java.io.FileReader
import java.io.PrintStream
import kotlin.system.exitProcess

private val out = PrintStream(java.lang.System.out, true, Charsets.UTF_8)

fun main(args : Array<String>)
  {
    try
      {
        // check args
        if (args.size != 1)
            printUsageAndExit()

        println("initializing...")

        val fileName = args[0]
        val errorHandler = ErrorHandler()
        val reader  = FileReader(fileName, Charsets.UTF_8)
        val source  = Source(reader)
        val scanner = Scanner(source, 4, errorHandler)   // 4 lookahead tokens
        var token : Token

        println("starting main loop...")
        println()

        do
          {
            token = scanner.token
            printToken(token)
            scanner.advance()
          }
        while (token.symbol != Symbol.EOF)

        println()
        println("...done")
      }
    catch (e : Exception)
      {
        e.printStackTrace()
      }
  }

private fun printToken(token : Token)
  {
    out.printf("line: %2d   char: %2d   token: ",
        token.position.lineNumber,
        token.position.charNumber)

    val symbol = token.symbol
    if (symbol.isReservedWord())
        out.print("Reserved Word -> ")
    else if (symbol == Symbol.identifier    || symbol == Symbol.intLiteral
          || symbol == Symbol.stringLiteral || symbol == Symbol.charLiteral)
        out.print(token.symbol.toString() + " -> ")

    out.println(token.text)
  }

private fun printUsageAndExit()
  {
    println("Usage: java TestScanner <test file>")
    println()
    exitProcess(0)
  }
