package edu.citadel.assembler.ast

import edu.citadel.cvm.Opcode
import edu.citadel.assembler.Symbol
import edu.citadel.assembler.Token

/**
 * This class implements the abstract syntax tree for the assembly
 * language instruction STOREB.
 */
class InstructionSTOREB(labels: MutableList<Token>, opcode: Token) : InstructionNoArgs(labels, opcode) {
    override fun assertOpcode() = assertOpcode(Symbol.STOREB)

    override fun emit() = emit(Opcode.STOREB)
}
