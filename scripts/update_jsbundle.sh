
if ! [ -x "$(command -v react-native)" ]; then
    echo 'React-native CLI is missing, installing...'
    npm install -g react-native-cli
fi

cd ..
echo 'Updating main.jsbundle file for iOS...'
react-native bundle --platform ios  --dev false --assets-dest ./ios --entry-file index.js --bundle-output ios/main.jsbundle

echo 'Updating main.jsbundle file for Android...'
react-native bundle --platform android --dev false --entry-file index.js --bundle-output android/app/src/main/assets/index.android.bundle --assets-dest android/app/src/main/res/
