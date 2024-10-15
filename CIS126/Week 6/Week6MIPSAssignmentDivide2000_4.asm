#FATCAT
#10/15/2024
#This progtam divides the integer numbers 2000 and 4 using the srl instruction and then prints the quotient.
#Registers:
#	$t0 - Holds 2000
#	$t1 - Holds the quotient
#	$v0 - Used for system calls
#	$a0 - Holds the string and quotient for printing

.data
result_div: .asciiz "The result of 2000 / 4 is "

.text
# Divide 2000 by 4 using shift right logical
li $t0, 2000       # Load 2000 into $t0
srl $t1, $t0, 2    # $t1 = $t0 >> 2 (2000 / 2^2 = 2000 / 4)

# Print the result
li $v0, 4          # System call for printing a string
la $a0, result_div # Load address of the string
syscall
li $v0, 1          # System call for printing an integer
move $a0, $t1      # Move the result to $a0
syscall

# Exit the program
li $v0, 10         # System call for exit
syscall
