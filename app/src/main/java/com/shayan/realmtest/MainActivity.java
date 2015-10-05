package com.shayan.realmtest;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.shayan.realmtest.model.Migration;
import com.shayan.realmtest.model.User;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmQuery;
import io.realm.RealmResults;

public class MainActivity extends Activity {

    private static final String outputFileName = "exampleOutput.csv";
    private Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        copyBundledRealmFile(this.getResources().openRawResource(R.raw.default0), "default0");
        RealmConfiguration config0 = new RealmConfiguration.Builder(this)
                .name("default0")
                .schemaVersion(2)
                .migration(new Migration())
                .build();

        Realm.migrateRealm(config0, new Migration());
        realm = Realm.getInstance(config0);
        loadRealmData();
        realm.close();
    }

    public void loadRealmData() {
        Log.d("", "path: " + realm.getPath());

        RealmQuery<User> query = realm.where(User.class);
        RealmResults<User> users = query.findAll();
        generateCsvFile(users);
    }

    //calling openFileOutput() to get a FileOutputStream that writes to a file in your internal directory
    private void generateCsvFile(RealmResults<User> users) {
        FileOutputStream outputStream;
        String columnHeader = "fullName,email,title,category,organization,locationCity,locationState," +
                "locationCountry,facebook,twitter,instagram,linkedin,website,memberType";
        String comma = ",";
        String newLine = "\n";

        try {
            outputStream = openFileOutput(outputFileName, Context.MODE_PRIVATE);
            outputStream.write(columnHeader.getBytes());
            outputStream.write(newLine.getBytes());

            for (User user : users) {
                outputStream.write(user.getFullName().getBytes());
                outputStream.write(comma.getBytes());
                outputStream.write(user.getEmail().getBytes());
                outputStream.write(comma.getBytes());
                outputStream.write(user.getTitle().getBytes());
                outputStream.write(comma.getBytes());
                outputStream.write(user.getCategory().getBytes());
                outputStream.write(comma.getBytes());
                outputStream.write(user.getOrganization().getBytes());
                outputStream.write(comma.getBytes());
                outputStream.write(user.getLocationCity().getBytes());
                outputStream.write(comma.getBytes());
                outputStream.write(user.getLocationState().getBytes());
                outputStream.write(comma.getBytes());
                outputStream.write(user.getLocationCountry().getBytes());
                outputStream.write(comma.getBytes());
                outputStream.write(user.getFacebook().getBytes());
                outputStream.write(comma.getBytes());
                outputStream.write(user.getTwitter().getBytes());
                outputStream.write(comma.getBytes());
                outputStream.write(user.getInstagram().getBytes());
                outputStream.write(comma.getBytes());
                outputStream.write(user.getLinkedin().getBytes());
                outputStream.write(comma.getBytes());
                outputStream.write(user.getWebsite().getBytes());
                outputStream.write(comma.getBytes());
                outputStream.write(user.getMemberType().getBytes());
                outputStream.write(newLine.getBytes());
            }

            outputStream.flush();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private String copyBundledRealmFile(InputStream inputStream, String outFileName) {
        try {
            File file = new File(this.getFilesDir(), outFileName);
            FileOutputStream outputStream = new FileOutputStream(file);
            byte[] buf = new byte[1024];
            int bytesRead;
            while ((bytesRead = inputStream.read(buf)) > 0) {
                outputStream.write(buf, 0, bytesRead);
            }
            outputStream.close();
            return file.getAbsolutePath();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
