# Jacob Sowden
# 10/01/2024
# This program prints the character 'P'
# registers:
	# $a0 - hold the character
	# $v0 - used for syscalls


.data
# Define the character
char: .byte 'P'  

.text
# Load the byte containing 'P' into $a0
la $a0, char
lb $a0, 0($a0)

# Set $v0 to 11 for syscall to print a character
li $v0, 11
syscall

# Exit the program
li $v0, 10
syscall
