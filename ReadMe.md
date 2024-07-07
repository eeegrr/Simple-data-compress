# DNA Encoding and Decoding Program

## Description
This Java console application encodes and decodes DNA sequences represented by the characters A, C, G, and T. Each nucleotide is encoded using two bits (A = 00, C = 01, G = 10, T = 11) instead of the 16 bits typically required for characters in Java strings. This results in a significant reduction in memory usage. The program handles commands to encode and decode DNA sequences, display information about the program author, and exit the program.

## Commands
The program processes the following commands:

### `comp`
Encodes a DNA sequence into an array of bytes.
#### Format
comp str
- `str`: A string consisting of the characters A, C, G, and T.

#### Actions
- Check if the string contains only A, C, G, and T (case insensitive).
  - If not, display `wrong command format` and exit the command.
- Encode the string into an array of bytes, where each character is represented by two bits.
- The first byte of the array contains the length of the string.
- If the last byte has unused bits, they are filled with zeros.
- Display the byte array in hexadecimal, separated by spaces.

#### Example
Input: comp CGATAAG
Output: 7 63 8

### `decomp`
Decodes an array of bytes back into a DNA sequence.
#### Format
decomp n b1 b2 b3 … bn
- `n`: The number of bytes following.
- `b1 b2 b3 … bn`: Bytes to be decoded.

#### Actions
- Display the byte array in hexadecimal, separated by spaces.
- Decode the byte array back into a string of A, C, G, and T.
- If the input format is incorrect, display `wrong command format` and exit the command.

#### Example
Input: decomp 4 10 30 -127 32
Output: A 1E 81 20
ACTGGAACAG

### `about`
Displays information about the program author.
#### Format
about

#### Actions
- Display the student ID, name, and group.

### `exit`
Exits the program.
#### Format
exit

#### Actions
- Terminate the program.

## Error Handling
- For unknown commands, the program will display `wrong command` and continue to accept commands.
- The program includes validation to ensure correct input formats and appropriate handling of errors.

## Execution Flow
The program runs in a loop, accepting and executing commands until the `exit` command is entered. Each command is processed according to the rules and formats described above.

## File Information
- **Main.java**: Contains the source code for the program. Ensure the file includes the author information as a comment at the beginning.

## Example Usage
comp CGATAAG
Output: 7 63 8

decomp 4 10 30 -127 32
Output: A 1E 81 20
ACTGGAACAG

about
Output: [Student ID] [Name] [Group]

exit
Output: Program terminates
