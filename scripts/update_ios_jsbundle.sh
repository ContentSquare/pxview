if ! [ -x "$(command -v node)" ]; then
    echo 'Node is missing, installing...'
    brew install node
fi

if ! [ -x "$(command -v watchman)" ]; then
    echo 'Watchman is missing, installing...'
    brew install watchman
fi

if ! [ -x "$(command -v react-native)" ]; then
    echo "Restore ownership of the user's npm related folders to the current user..."
    sudo chown -R $USER:$GROUP ~/.npm
    sudo chown -R $USER:$GROUP ~/.config

    echo 'React-native CLI is missing, installing...'
    npm install -g react-native-cli
fi

cd ..
echo 'Updating main.jsbundle file for iOS...'
react-native bundle --platform ios  --dev false --assets-dest ./ios --entry-file index.js --bundle-output ios/main.jsbundle

# we do not need to update it for Android currently.
# echo 'Updating main.jsbundle file for Android...'
# react-native bundle --platform android --dev false --entry-file index.js --bundle-output android/app/src/main/assets/index.android.bundle --assets-dest android/app/src/main/res/
