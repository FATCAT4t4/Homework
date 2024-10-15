# Jacob Sowden
# 10/01/2024
# This program prints the string "Hello World"
# registers:
	# $a0 - hold the string
	# $v0 - used for syscalls


.data
str: .asciiz "Hello World\n"  # Define the string

.text

# Load address of the string into register $a0
la $a0, str

# Set $v0 to 4 for syscall to print string
li $v0, 4
syscall

# Exit the program
li $v0, 10
syscall
