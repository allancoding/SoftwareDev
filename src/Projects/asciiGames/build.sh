#!/bin/bash
# Build the project
echo "Building asciiGames"
# create the .tmp directory
mkdir -p .tmp/games
# copy the source files to the tmp directory
cp -r *.java .tmp
cp -r games/*.java .tmp/games
# fix the package name
sed -i 's/Projects.asciiGames/asciiGames/' .tmp/*.java
sed -i 's/Projects.asciiGames/asciiGames/' .tmp/games/*.java
sed -i 's/"Projects.asciiGames";/"asciiGames";/' .tmp/*.java
# get all of the files
cd .tmp
find ./ -name "*.java" > sources.txt
# compile the source files
javac -encoding UTF-8 -cp ../lib/* -d ../build @sources.txt
cd ..
unzip -q -o lib/*.jar -d build
# add the jar dependencies to the classpath
jar cmf build/manifest.txt asciiGames.jar -C build .
# remove the .tmp directory
#read
rm -r .tmp
echo "Done!"