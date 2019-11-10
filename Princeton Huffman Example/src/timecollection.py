"""
created Sat Mar 31, 2018
@author: jessicazhou
"""

#python3 autoscraping.py sampleURLS.txt

import os
import os.path
import io
import sys
import csv
import time
import string

'''
/******************************************************************************
 *  Compilation:  javac Huffman.java
 *  Execution:    java Huffman - < input.txt   (compress)
 *  Execution:    java Huffman + < input.txt   (expand)
 *  Dependencies: BinaryIn.java BinaryOut.java
 *  Data files:   https://algs4.cs.princeton.edu/55compression/abra.txt
 *                https://algs4.cs.princeton.edu/55compression/tinytinyTale.txt
 *                https://algs4.cs.princeton.edu/55compression/medTale.txt
 *                https://algs4.cs.princeton.edu/55compression/tale.txt
 *
 *  Compress or expand a binary input stream using the Huffman algorithm.
 *
 *  % java Huffman - < abra.txt | java BinaryDump 60
 *  010100000100101000100010010000110100001101010100101010000100
 *  000000000000000000000000000110001111100101101000111110010100
 *  120 bits
 *
 *  % java Huffman - < abra.txt | java Huffman +
 *  ABRACADABRA!
 *
 ******************************************************************************/
'''

#param_1= sys.argv[1]

global output 

directory_in_str = 'files'
directory = os.fsencode(directory_in_str)

#data collection file
output = open('output.txt','w') 
output.write("file, compression, expansion\n")
print(os.getcwd()) #current working directory is src
#os.chdir(directory)

for file in os.listdir(directory):
    filename = os.fsdecode(file)
    print(file)

    output.write(filename + ",")

    start_time = time.time()
    os.system("java Huffman - < /Users/jessicazhou/Desktop/technica/technica-research-2019/Princeton\\ Huffman\\ Example/src/files/" + str(filename)) #change this line
    end_time = time.time()
    output.write(str(end_time - start_time)+",")

    start_time = time.time()
    os.system("java Huffman + < < /Users/jessicazhou/Desktop/technica/technica-research-2019/Princeton\\ Huffman\\ Example/src/files/" + str(filename)) #change this line
    end_time = time.time()
    output.write(str(end_time - start_time))

    output.write("\n")

'''
output.write("\n\nTotal projects: "+str(linecount)+"\nProjects with wiki tab and wiki content: "+str(wikitab)+" / "+str(linecount)+" or {:.2%}".format(wikitab/linecount))
output.write("\nProjects that don't exist anymore: "+str(noproject)+" / "+str(linecount)+" or {:.2%}".format(noproject/linecount))
output.write("\nProjects with no wiki tab or no wiki content: "+str(nowikiornocontent)+" / "+str(linecount)+" or {:.2%}".format(nowikiornocontent/linecount))
output.write("\nRuntime: %s seconds" %(time.time() - start_time))
'''
output.close()

