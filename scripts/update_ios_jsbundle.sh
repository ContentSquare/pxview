#!/bin/bash

[ "${PWD##*/}" == "scripts" ] && cd ..

jsbundlePath="./ios/main.jsbundle"
assetsPath="./ios/assets/"

#Remove the old files and folders for iOS
if [ -f $jsbundlePath ]; then
	echo "Removing old file at $jsbundlePath"
	rm -rf $jsbundlePath
else
	echo "No file at $jsbundlePath, continuing"
fi

if [ -d $assetsPath ]; then
	echo "Removing old folder at $assetsPath"
	rm -rf $assetsPath
else
	echo "No folder at $assetsPath, continuing"
fi

#Create the react-native bundle for iOS
echo "Updating main.jsbundle file for iOS..."
react-native bundle --platform ios  --dev false --assets-dest ./ios --entry-file index.js --bundle-output ios/main.jsbundle
