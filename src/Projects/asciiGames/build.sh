#!/bin/bash

# Build the project
echo "Building asciiGames"
# create the .tmp directory
mkdir -p .tmp/games
# copy the source files to the tmp directory
cp -r *.java .tmp
cp -r games/*.java .tmp/games
# fix the package name
sed -i 's/package asciiGames;/package Projects.asciiGames;/' .tmp/*.java
sed -i 's/package asciiGames;/package Projects.asciiGames;/' .tmp/games/*.java
# fix imports
sed -i 's/import asciiGames\./import Projects.asciiGames\./' .tmp/*.java
sed -i 's/import asciiGames\./import Projects.asciiGames\./' .tmp/games/*.java
# get all of the files
find .tmp -name "*.java" > .tmp/sources.txt
# compile the source files
javac -d build .tmp/@sources.txt
# add the jar dependencies to the classpath
jar cvfm asciiGames.jar build/META-INF/MANIFEST.MF -C build . -C lib .
# remove the .tmp directory
rm -r .tmp
read