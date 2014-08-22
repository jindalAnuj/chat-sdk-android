package com.braunster.chatsdk.dao.entities;

import android.graphics.Bitmap;

import com.braunster.chatsdk.dao.BMetadata;
import com.braunster.chatsdk.dao.BThread;
import com.braunster.chatsdk.dao.BUser;
import com.braunster.chatsdk.network.firebase.BFirebaseDefines;
import com.braunster.chatsdk.network.firebase.BPath;
import com.firebase.simplelogin.enums.Provider;

import java.io.File;
import java.util.List;

/**
 * Created by braunster on 25/06/14.
 */
public abstract class BUserEntity extends Entity<BUser> {

    public boolean hasApp = false;
    public boolean pictureExist = false;
    public String email ="";
    public String pictureURL = "";

    public static String safeAuthenticationID(String aid, Provider type){

        String prefix = "";
        switch (type){
            case PASSWORD:
                prefix = "pw";
                break;
            case FACEBOOK:
                prefix = "fb";
                break;
            case TWITTER:
                prefix = "tw";
                break;
            case ANONYMOUS:
                prefix = "an";
                break;
            case GOOGLE:
                prefix = "go";
                break;
        }

        prefix += aid;

        return prefix;
    }

    @Override // Note Done!
    public BPath getPath() {
        return new BPath().addPathComponent(BFirebaseDefines.Path.BUsersPath, getEntityID());
    }

    public abstract String[] getCacheIDs();

    public abstract List<BThread> getThreads();

    public abstract List<BThread> getThreads(int type);

    public abstract List<BUser> getContacts();

    public abstract void addContact(BUser user);

    public abstract void addMetaDataObject(BMetadata metadata);

    public abstract Bitmap getThumnail();

    public abstract void setMetaPicture(Bitmap bitmap);

    public abstract void setMetaPicture(String base64);

    public abstract void setMetaPicture(File image);

    public abstract void setMetaPictureUrl(String imageUrl);

    public abstract String getMetaPictureUrl();

    public abstract void setMetaName(String name);

    public abstract String getMetaName();

    public abstract void setMetaEmail(String email);

    public abstract String getMetaEmail();

    public abstract String getThumbnailPictureURL();
/*    public abstract BMetadata fetchOrCreateMetadataForKey(String key, int type);*/





}
