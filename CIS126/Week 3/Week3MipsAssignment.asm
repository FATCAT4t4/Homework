#Jacob Sowden
#9/18/2024
#This program prompts the user for two numbers, then adds them together, and prints the resulting sum.
#Registers used:
#$v0 - used for syscalls
#$a0 - used to store the text to print to console
#$t0 - used for holding the first number the user inputs
#$t1 - used for holding the second number the user inputs
#$t2 - used for hold the sum of $t0 and $t1
#$zero - used as a constant 0 for setting the value of other registers

.data
#Declare all the variables
Prompt1: .asciiz "Input first number: "
Prompt2: .asciiz "Input second number: "
SumText1:.asciiz "The sum of "
SumText2:.asciiz " and "
SumText3:.asciiz " is "
SumText4:.asciiz "."

.text
#syscall to print Prompt1
add $v0, $zero, 4
la $a0, Prompt1
syscall

#syscall to get number from user and save to $t0
add $v0, $zero, 5
syscall
add $t0, $zero, $v0

#syscall to print Prompt2
add $v0, $zero, 4
la $a0, Prompt2
syscall

#syscall to get number from user and save to $t1
add $v0, $zero, 5
syscall
add $t1, $zero, $v0

#Add $t0 and $t1 into $t2
add $t2, $t0, $t1

#syscall to print SumText1
add $v0, $zero, 4
la $a0, SumText1
syscall

#syscall to print $t0
add $v0, $zero, 1
la $a0, ($t0)
syscall

#syscall to print SumText2
add $v0, $zero, 4
la $a0, SumText2
syscall

#syscall to print $t1
add $v0, $zero, 1
la $a0, ($t1)
syscall

#syscall to print SumText3
add $v0, $zero, 4
la $a0, SumText3
syscall

#syscall to print $t2
add $v0, $zero, 1
la $a0, ($t2)
syscall

#syscall to print SumText4
add $v0, $zero, 4
la $a0, SumText4
syscall

# syscall 10 to exit
add $v0, $zero, 10
syscall
