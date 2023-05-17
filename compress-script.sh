#!/bin/bash

input_file=$1
output_file=${input_file%%.*}".huf"

cd files/
mv $input_file ../
cd ..
mv $input_file compressor-files/
cd compressor-files/
./compressor.exe -f $input_file
mv $input_file ../
mv $output_file ../
cd ..
mv $input_file files/
mv $output_file files/
