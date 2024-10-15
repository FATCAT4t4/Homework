# FATCAT
# 10/01/2024
# This program prints subtracts two integer numbers, and prints both of them and the difference separated by spaces
# registers:
	# $t0 - hold the first integer
	# $t1 - hold the second integer
	# $t2 - hold the difference of the two integers
	# $a0 - temporarily hold the contents of the previous 3 registers to print them
	# $v0 - used for syscalls


.text
# Load two integers into $t0 and $t1
li $t0, 15
li $t1, 8

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

# Perform subtraction: result = $t0 - $t1
sub $t2, $t0, $t1

# Print a space
li $a0, ' '
li $v0, 11
syscall

# Print difference
move $a0, $t2
li $v0, 1
syscall

# Exit the program
li $v0, 10
syscall
