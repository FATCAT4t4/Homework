#FATCAT
#10/15/2024
#This progtam multiplies the integer numbers 5 and 16 using the sll instruction and then prints the product.
#Registers:
#	$t0 - Holds 5
#	$t1 - Holds 16
#	$t2 - Holds the product
#	$v0 - Used for system calls
#	$a0 - Holds the string and product for printing

.data
result: .asciiz "The result of 5 * 16 is "

.text
# Multiply 5 and 16 using shift left logical
li $t0, 5          # Load 5 into $t0
li $t1, 16         # Load 16 into $t1
sll $t2, $t0, 4    # $t2 = $t0 << 4 (5 * 2^4 = 5 * 16)

# Print the result
li $v0, 4          # System call for printing a string
la $a0, result     # Load address of the string
syscall
li $v0, 1          # System call for printing an integer
move $a0, $t2      # Move the result to $a0
syscall

# Exit the program
li $v0, 10         # System call for exit
syscall
