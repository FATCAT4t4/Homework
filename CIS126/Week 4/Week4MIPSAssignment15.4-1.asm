# Jacob Sowden
# 10/01/2024
# This program prints the floating point number 15.4
# registers:
	# $f12 - hold the float
	# $v0 - used for syscalls


.data
# Define the float
float: .float 15.4

.text
# Load floating-point number into $f12
lwc1 $f12, float

# Set $v0 to 2 for syscall to print float
li $v0, 2
syscall

# Exit the program
li $v0, 10
syscall
