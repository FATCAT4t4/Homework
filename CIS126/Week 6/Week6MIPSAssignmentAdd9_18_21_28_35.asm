#FATCAT
#10/15/2024
#This progtam adds the integers 9, 18, 21, 28, and 35 using the add instruction and then prints the sum.
#Registers:
#	$t0 - Holds 9
#	$t1 - Holds 18
#	$t2 - Holds 21
#	$t3 - Holds 28
#	$t4 - Holds 35
#	$t5 - Holds the sum of the numbers
#	$v0 - Used for system calls
#	$a0 - Holds the string and sum for printing

.data
result: .asciiz "The sum of 9, 18, 21, 28, and 35 is "

.text
# Load the numbers into registers
li $t0, 9
li $t1, 18
li $t2, 21
li $t3, 28
li $t4, 35

# Add the numbers
add $t5, $t0, $t1   # $t5 = 9 + 18
add $t5, $t5, $t2   # $t5 = $t5 + 21
add $t5, $t5, $t3   # $t5 = $t5 + 28
add $t5, $t5, $t4   # $t5 = $t5 + 35

# Print the result
li $v0, 4           # System call for printing a string
la $a0, result  # Load address of the string
syscall
li $v0, 1           # System call for printing an integer
move $a0, $t5       # Move the result to $a0
syscall

# Exit the program
li $v0, 10          # System call for exit
syscall
