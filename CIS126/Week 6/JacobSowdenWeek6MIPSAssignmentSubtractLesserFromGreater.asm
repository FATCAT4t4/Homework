#FATCAT
#10/15/2024
#This progtam compares two integers (input by user) using the slt instruction and subtracts the smaller one from the greater one. It then prints the difference.
#Registers:
#	$t0 - Holds the first integer
#	$t1 - Holds the second integer
#	$t2 - Used as a boolean in the logic operation
#	$t3 - Holds $t0 temporarily to swap the registers
#	$t4 - Holds the difference
#	$v0 - Used for system calls
#	$a0 - Holds the string and sum for printing
#	$zero - The constant 0

.data
result: .asciiz "The result of subtracting the smaller value from the larger value is: "
prompt: .asciiz "Input an integer number: "


.text
# Load two user-input values into registers
li $v0, 4          # System call for printing a string
la $a0, prompt     # Load address of the string
syscall
li $v0, 5	   # System call for getting an integer from the console
syscall
move $t0, $v0	   #Move the integer to $t0
li $v0, 4          # System call for printing a string
la $a0, prompt     # Load address of the string
syscall
li $v0, 5	   # System call for getting an integer from the console
syscall
move $t1, $v0	   #Move the integer to $t0


# Compare the two values using slt
slt $t2, $t0, $t1  # $t2 = 1 if $t0 < $t1, otherwise $t2 = 0
beq $t2, $zero, ELSE # If $t2 is 0, then $t0 is greater or equal to $t1

# If $t0 < $t1, swap the values so $t1 becomes the larger value
move $t3, $t0      # Store $t0 in $t3 temporarily
move $t0, $t1      # $t0 = $t1
move $t1, $t3      # $t1 = $t3

ELSE:
    # Subtract the smaller value from the larger value
    sub $t4, $t0, $t1  # $t4 = larger value - smaller value

    # Print the result
    li $v0, 4          # System call for printing a string
    la $a0, result     # Load address of the string
    syscall
    li $v0, 1          # System call for printing an integer
    move $a0, $t4      # Move the result to $a0
    syscall

    # Exit the program
    li $v0, 10         # System call for exit
    syscall
