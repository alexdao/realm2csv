Realm2CSV
==============

### Instructions

1. Works for SDK Version 21+
2. Update the app/src/main/res/raw/default0.realm file with the one you want to convert (name must be default0). 
Note: Currently this Android app migrates Realms up to version 2 (assuming identical schemas). If you want to go higher, you need to modify app/src/main/java/com/shayan/realmtest/model/Migration.java
3. Change .csv output file name in app/src/main/java/com/shayan/realmtest/MainActivity.java. Default is exampleOutput.csv
4. Use ./adb pull /data/data/com.shayan.realmtest/files/exampleOutput.csv  /dest to extract .csv file.