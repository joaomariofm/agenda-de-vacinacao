#!/bin/bash

# Set root directory
COMPARISON_DIR_SHA256="64575e4a74f4ef1712de420f9d32d16646ebe48853f0dda902c393fdecd81493"
ROOT_DIR_SHA256=$(find ../ -name ".root-dir" -exec cat {} +)
ROOT_DIR_PATH=$(find ../ -name ".root-dir" -exec dirname {} +)

# Set main class
MAIN_CLASS=$(find $ROOT_DIR_PATH/target/classes -name "Main.class")

if [ "$ROOT_DIR_SHA256" == "$COMPARISON_DIR_SHA256" ]; then
	if [ -f "$MAIN_CLASS" ]; then
		java -cp "$ROOT_DIR_PATH/target" -jar "$ROOT_DIR_PATH/target/agenda-vacinacao-1.0-SNAPSHOT.jar"
	else
		echo "Main class not found"
	fi
fi

