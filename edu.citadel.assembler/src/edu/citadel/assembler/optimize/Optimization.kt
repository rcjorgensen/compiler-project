package edu.citadel.assembler.optimize

import edu.citadel.assembler.ast.Instruction

/**
 * Perform peephole optimization on the list of instructions starting with
 * the instruction at the specified position in the list and looking at
 * that instruction plus the next several instructions.  Any class that
 * implements this interface can remove/replace instructions in the list.
 */
interface Optimization {
    fun optimize(instructions: MutableList<Instruction>, instNum: Int)
}
