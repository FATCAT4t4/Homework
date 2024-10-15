# Jacob Sowden
# 10/08/2024
# This program does several things:
	# Adds two integers that are stored in variables and prints the sum
	# Subtracts two integers that are stored in variables and prints the difference
	# Multiplies two integers that are stored in variables and prints the prodcut
	# Multiplies two immediate integers and prints the product
	# Multiplies two immediate integers and prints the product in hex
	# Divides two immediate integers and prints the quotient and remainder
	
# registers:
	# $t0 - holds var1, and later the immediate 5
	# $t1 - hold var2, and later the product of 5000 and 5
	# $t2 - hold the sum of var1 amd var2, and later the immediate 500000
	# $t3 - hold var3, and later the immediate 200000
	# $t4 - hold var4, and later the lower half of the product of 500000 and 200000
	# $t5 - hold the difference of var3 and var4, and later the upper hald of the product of 500000 and 200000
	# $t6 - hold var5, and later the immediate 716
	# $t7 - hold var6, and later the immediate 19
	# $t8 - hold the product of var5 and var6, and later the quotient of 716 and 19
	# $t9 - hold the immediate 5000, and later the remainder of 716 and 19
	# $a0 - temporarily hold the contents of the $tX registers to print them
	# $v0 - used for syscalls

.data
# Variables
	var1:   .word 272              # Store value 272
	var2:   .word 86               # Store value 86
	var3:   .word 3844             # Store value 3844
	var4:   .word 791              # Store value 791
	var5:   .word 413              # Store value 413
	var6:   .word 212              # Store value 212
	msg_add:    .asciiz "\nThe sum of 272 and 86 is: "
	msg_sub:    .asciiz "\nThe result of 3844 - 791 is: "
	msg_mul1:   .asciiz "\nThe product of 413 and 212 is: "
	msg_mul2:   .asciiz "\nThe product of 5000 and 5 is: "
	msg_hex:    .asciiz "\nThe product of 500000 and 200000 in hex is: 0x"
	msg_div:    .asciiz "\nThe quotient of 716 / 19 is: "
	msg_rem:    .asciiz ", and the remainder is: "

.text
# 1. Adding 272 and 86, then printing the result
    lw    $t0, var1            # Load var1 (272) into $t0
    lw    $t1, var2            # Load var2 (86) into $t1
    add   $t2, $t0, $t1        # Add $t0 and $t1, store in $t2
    li    $v0, 4               # Syscall to print string (Descriptive results)
    la    $a0, msg_add         
    syscall                    
    li    $v0, 1               # Syscall for printing integer (Sum)
    move  $a0, $t2             
    syscall                    

# 2. Subtracting 791 from 3844, then printing the result
    lw    $t3, var3            # Load var3 (3844) into $t3
    lw    $t4, var4            # Load var4 (791) into $t4
    sub   $t5, $t3, $t4        # Subtract $t4 from $t3, store in $t5
    li    $v0, 4               # Syscall for printing string (Descriptive results)
    la    $a0, msg_sub         
    syscall                    
    li    $v0, 1               # Syscall for printing integer (Difference)
    move  $a0, $t5             
    syscall                    

# 3. Multiplying 413 and 212, then printing the result
    lw    $t6, var5            # Load var5 (413) into $t6
    lw    $t7, var6            # Load var6 (212) into $t7
    mul   $t8, $t6, $t7        # Multiply $t6 and $t7, store in $t8
    li    $v0, 4               # Syscall for printing string (Descriptive results)
    la    $a0, msg_mul1        
    syscall                    
    li    $v0, 1               # Syscall for printing integer (Product)
    move  $a0, $t8             
    syscall                    

# 4. Multiplying 5000 and 5 using mult, then printing the result
    li    $t9, 5000            # Load immediate 5000 into $t9
    li    $t0, 5               # Load immediate 5 into $t0
    mult  $t9, $t0             # Multiply $t9 and $t0 using mult (result in hi/lo)
    mflo  $t1                  # Move lower 32-bit result from lo to $t1
    li    $v0, 4               # Syscall for printing string (Descriptive results)
    la    $a0, msg_mul2        
    syscall                    
    li    $v0, 1               # Syscall for printing integer (Product)
    move  $a0, $t1             
    syscall                    

# 5. Multiplying 500000 and 200000 using mult, print the result in hex
    li    $t2, 500000          # Load immediate 500000 into $t2
    li    $t3, 200000          # Load immediate 200000 into $t3
    mult  $t2, $t3             # Multiply $t2 and $t3 (result in hi/lo)
    mflo  $t4                  # Move lower 32-bit result from lo to $t4
    mfhi  $t5                  # Move upper 32-bit result from hi to $t5
    li    $v0, 4               # Syscall for printing string (Descriptive results)
    la    $a0, msg_hex         
    syscall                    
    li    $v0, 34              # Syscall for printing hex (upper 32 bits of product)
    move  $a0, $t5             
    syscall                    
    li    $v0, 34              # Syscall for printing hex (lower 32 bits of product)
    move  $a0, $t4             
    syscall                    

# 6. Dividing 716 by 19, print the quotient and remainder
    li    $t6, 716             # Load immediate 716 into $t6
    li    $t7, 19              # Load immediate 19 into $t7
    div   $t6, $t7             # Divide $t6 by $t7
    mflo  $t8                  # Move quotient from lo to $t8
    mfhi  $t9                  # Move remainder from hi to $t9
    li    $v0, 4               # Syscall for printing string (Descriptive results)
    la    $a0, msg_div         
    syscall                    
    li    $v0, 1               # Syscall for printing integer (quotient)
    move  $a0, $t8             
    syscall                    
    li    $v0, 4               # Syscall for printing string (Descriptive results)
    la    $a0, msg_rem         
    syscall                    
    li    $v0, 1               # Syscall for printing integer (remainder)
    move  $a0, $t9             
    syscall                    

# Syscall to end program
    li    $v0, 10              
    syscall
