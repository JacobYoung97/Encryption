# Encryption

This is a simple encryption/decryption program that will take a key file and a text file and encrypt it and then translate it.
I copied the basic algorithm from the description of this repo. 

The programs do use `System.out.println()` to print out the text to the console. If something like this is implemented by a company, it is probably a good idea to remove them (at least the ones that print the plaintext). 

## Real world applications

This program shows a way to store data that is not 100% plaintext or human readable. It will take the file, encrypt it, and place it in another file for later decrypting. 
The encrypted text is stored in a "txt" file so it can still be opened by other programs, but the text is encrypted so it is not as easily readable as before. 

The key is stored in another file to remove any possibility of finding out the secret in the code. 

These programs are just a simple reading and writing application. 
For it to be useful, it would have to be incorporated into another application instead. 

## Usage

