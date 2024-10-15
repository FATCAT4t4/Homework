# FATCAT
# 10/01/2024
# This program prints the integer number 19
# registers:
	# $a0 - hold the integer
	# $v0 - used for syscalls


.text
# Load 19 into $a0
li $a0, 19

# Set $v0 to 1 for syscall to print an integer
li $v0, 1
syscall

# Exit the program
li $v0, 10
syscall
