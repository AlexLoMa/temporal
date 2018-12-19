package com.sam.samproject;

/**
 * Created by Alejandro Lopez Malvaez on 23/09/2018.
 */


import com.sam.samproject.di.DaggerApplicationComponent;
import com.sam.samproject.login.LoginModel;

import java.util.ArrayList;
import java.util.HashMap;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;

public class SamApplication extends DaggerApplication{

    private HashMap<Integer,ArrayList<LoginModel>> hsLoging;

    @Override
    public void onCreate() {
        super.onCreate();
        hsLoging = new HashMap<>();

        setLoginAuthenticator();
    }

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return DaggerApplicationComponent.builder().create(this);
    }


    private void setLoginAuthenticator(){

        //Relationship manager
        LoginModel loginModel1 = new LoginModel();
        loginModel1.setUserType(1);
        loginModel1.setPassword("123456");
        loginModel1.setEmailId("relmanager1@gmail.com");

        LoginModel loginModel2 = new LoginModel();
        loginModel2.setUserType(1);
        loginModel2.setPassword("123456");
        loginModel2.setEmailId("relmanager2@gmail.com");

        ArrayList<LoginModel> arrayListB = new ArrayList<>();
        arrayListB.add(loginModel1);
        arrayListB.add(loginModel2);

        hsLoging.put(1,arrayListB);

        //Personal banker
        LoginModel personall = new LoginModel();
        personall.setUserType(2);
        personall.setPassword("123456");
        personall.setEmailId("personalbanker1@gmail.com");

        LoginModel personal2 = new LoginModel();
        personal2.setUserType(2);
        personal2.setPassword("123456");
        personal2.setEmailId("personalbanker2@gmail.com");

        ArrayList<LoginModel> arrayListP = new ArrayList<>();
        arrayListP.add(personal2);
        arrayListP.add(personall);

        hsLoging.put(2,arrayListP);

        //Branch manager
        LoginModel branch1 = new LoginModel();
        branch1.setUserType(3);
        branch1.setPassword("123456");
        branch1.setEmailId("branchmanager1@gmail.com");

        LoginModel branch2 = new LoginModel();
        branch2.setUserType(3);
        branch2.setPassword("123456");
        branch2.setEmailId("branchmanager2@gmail.com");

        ArrayList<LoginModel> arrayListBM = new ArrayList<>();
        arrayListBM.add(branch1);
        arrayListBM.add(branch2);


        hsLoging.put(3,arrayListBM);
    }


    public boolean validateUser(LoginModel loginModel){
        boolean isValidateSuccessfully = false;
        ArrayList<LoginModel> data = hsLoging.get(loginModel.getUserType());
        for(int i=0;i<data.size();i++){
            if(loginModel.getEmailId().equals(data.get(i).getEmailId()) && loginModel.getPassword().equals(data.get(i).getPassword())){
                isValidateSuccessfully = true;
                break;
            }
        }
        return isValidateSuccessfully;
    }
}
