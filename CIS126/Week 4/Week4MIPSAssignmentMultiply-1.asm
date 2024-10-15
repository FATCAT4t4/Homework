# Jacob Sowden
# 10/01/2024
# This program multiplies two integer numbers, and prints the two input numbers and the product, separated by spaces.
# registers:
	# $t0 - hold the first integer
	# $t1 - hold the second integer
	# $t2 - hold the product of the two integers
	# $a0 - temporarily hold the contents of the previous 3 registers to print them
	# $v0 - used for syscalls


.text
# Load two integers into $t0 and $t1
li $t0, 6
li $t1, 7

# Print first integer
move $a0, $t0
li $v0, 1
syscall

# Print a space
li $a0, ' '
li $v0, 11
syscall

# Print second integer
move $a0, $t1
li $v0, 1
syscall
    
# Perform multiplication: result = $t0 * $t1
mul $t2, $t0, $t1

# Print a space
li $a0, ' '
li $v0, 11
syscall

# Print product
move $a0, $t2
li $v0, 1
syscall

# Exit the program
li $v0, 10
syscall
