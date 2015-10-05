package com.shayan.realmtest.model;

import android.util.Log;

import io.realm.Realm;
import io.realm.RealmMigration;

/**
 * Created by alex on 10/5/15.
 */
public class Migration implements RealmMigration{

    @Override
    public long execute(Realm realm, long version) {
        if (version == 0) {
            Log.d("hi", "test");
            version++;
        }
        if(version ==1){
            version++;
        }
        return version;
    }
}
